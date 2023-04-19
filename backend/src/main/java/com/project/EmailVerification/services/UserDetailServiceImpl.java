package com.project.EmailVerification.services;

import com.project.EmailVerification.auth.userDetails.UserDetailsImpl;
import com.project.EmailVerification.entites.User;
import com.project.EmailVerification.exception.EmailVerificationException;
import com.project.EmailVerification.exception.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userService.getUserByEmail(username);
            return UserDetailsImpl.buildUser(user);
        } catch (EmailVerificationException e) {
            throw new UsernameNotFoundException(ExceptionMessage.USER_NOT_EXIST.getMessage());

        }

    }
}
