package com.project.EmailVerification.auth.mail;

import com.project.EmailVerification.exception.EmailVerificationException;
import com.project.EmailVerification.exception.ExceptionMessage;
import com.project.EmailVerification.utils.EmailConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static com.project.EmailVerification.utils.EmailConstants.*;

public class MailConfig {

    @Bean
    public static JavaMailSenderImpl getMailConfig(){



        // Email Credentials
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();
        emailConfig.setHost(HOST);
        emailConfig.setPort(PORT);
        emailConfig.setUsername(USERNAME);
        emailConfig.setPassword(PASSWORD);


        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.auth", true);
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");


        return emailConfig;
    }
}
