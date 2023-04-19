package com.project.EmailVerification.controllers;


import com.project.EmailVerification.auth.jwt.JwtTokenProvider;
import com.project.EmailVerification.auth.mail.HTML;
import com.project.EmailVerification.auth.mail.MailMessenger;
import com.project.EmailVerification.entites.Credentials;
import com.project.EmailVerification.entites.User;
import com.project.EmailVerification.exception.EmailVerificationException;
import com.project.EmailVerification.exception.ExceptionMessage;
import com.project.EmailVerification.services.UserService;
import com.project.EmailVerification.utils.EmailConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.mail.MessagingException;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final Log logger = LogFactory.getLog(AuthController.class);

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * Logs the user in and returns a JWT token if authentication is successful.
     *
     * @param credentials The user's login credentials.
     * @return A JWT token if authentication is successful.
     */
    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody Credentials credentials) {
        System.out.println("atlogin " + credentials);
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credentials.getEmail(), credentials.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            logger.info("Email obtained from SecurityContextHolder: " + credentials.getEmail());
            logger.info("Is " + credentials.getEmail() + " Authenticated? : " + SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
            String jwt = jwtTokenProvider.generateToken(credentials);
        try {

            if (jwtTokenProvider.validateToken(jwt)) {
                boolean isAuthenticated = userService.getUserByEmail(credentials.getEmail()).isAuthenticated();
                System.out.println("isAuthenticated" + isAuthenticated);
                if (!isAuthenticated) {
                    System.out.println("got into not authenticated");
                    // Send verification mail
                    sendVerificationMail(credentials.getEmail());
                    return new ResponseEntity<>("Your account is not verified!, verification mail has been sent.", HttpStatus.UNAUTHORIZED);
                }
                return new ResponseEntity<>(jwt, HttpStatus.OK);
            }
            return new ResponseEntity<>(ExceptionMessage.AUTHENTICATION_FAILED, HttpStatus.BAD_REQUEST);
        } catch (UsernameNotFoundException | EmailVerificationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Registers a new user and sends a verification email to the user's email address.
     *
     * @param userForm The user's registration details.
     * @return A response entity indicating whether registration was successful or not.
     */
    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody User userForm) {
        try {

            User user = new User();
            user.setEmail(userForm.getEmail());
            if (this.userService.existByEmail(userForm.getEmail())) {
                return new ResponseEntity<>(ExceptionMessage.EXIST_BY_EMAIL.getMessage(), HttpStatus.CONFLICT);
            }

            user.setFirstName(userForm.getFirstName());
            user.setLastName(userForm.getLastName());
            user.setPassword(passwordEncoder.encode(userForm.getPassword()));
            this.userService.registerUser(user);

            // Send verification mail
            sendVerificationMail(userForm.getEmail());

            return new ResponseEntity<>("Account Registered Successfully, Please proceed and verify your account. \n Verification email has been sent.", HttpStatus.CREATED);
        } catch (EmailVerificationException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Verifies the user's email address using the confirmation code sent to their email.
     *
     * @param code The confirmation code sent to the user's email.
     * @return A response entity indicating whether email verification was successful or not.
     */
    @GetMapping("/verify")
    private ResponseEntity<?> registrationConfirm(@RequestParam String code) {
        try {
            logger.debug("User is trying to getAuthenticated with token: " + code);
            if (jwtTokenProvider.validateCode(code)) {
                String email = jwtTokenProvider.getCredentialsFromCode(code);
                User user = userService.getUserByEmail(email);
                user.setAuthenticated(true);
                userService.updateUser(user);
                logger.trace("User has been authenticated: " + user.getEmail());
                return new ResponseEntity<>("You have been authenticated!", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Invalid Confirmation link! Try again.", HttpStatus.OK);
        } catch (EmailVerificationException e) {
            logger.error("Error at @registrationConfirm " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     * Sends a verification email to the specified user's email address.
     *
     * @param userEmail The email address of the user to send the verification email to.
     * @throws EmailVerificationException If an error occurs while sending the verification email.
     */
    public void sendVerificationMail(String userEmail) throws EmailVerificationException {
        try {
            String code = jwtTokenProvider.generateVerificationCode(userEmail);
            String emailBody = HTML.htmlEmailTemplate(code);
            MailMessenger.EmailSender(EmailConstants.USERNAME, userEmail, "Verify your Account", emailBody);
        } catch (MessagingException e) {
            throw new EmailVerificationException(e.getMessage());
        }
    }


}
