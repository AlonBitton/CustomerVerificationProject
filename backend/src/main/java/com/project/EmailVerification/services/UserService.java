package com.project.EmailVerification.services;

import com.project.EmailVerification.entites.User;
import com.project.EmailVerification.exception.EmailVerificationException;
import com.project.EmailVerification.exception.ExceptionMessage;
import com.project.EmailVerification.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User updateUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserByEmail(String email) throws EmailVerificationException {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new EmailVerificationException(ExceptionMessage.USER_NOT_EXIST.getMessage()));
    }

    public boolean existByEmail(String email) throws EmailVerificationException {
         return userRepository.existsByEmail(email);

    }

    public User registerUser(User user) throws EmailVerificationException {
        return this.userRepository.save(user);
    }

}
