/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mail;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
/**
 * 
 * To configure gmail account:
    after google account login visit:
    https://myaccount.google.com/lesssecureapps
    more info:
    https://stackoverflow.com/questions/35347269/javax-mail-authenticationfailedexception-535-5-7-8-username-and-password-not-ac
    https://myaccount.google.com/security

    This is necessary to avoid the following exception
    javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted. 
    Learn more at 535 5.7.8 https://support.google.com/mail/?p=BadCredentials c206sm12712889wmf.36 - gsmtp

    Sending mail by spring boot links:
    https://www.baeldung.com/spring-email
    https://mkyong.com/spring-boot/spring-boot-how-to-send-email-via-smtp/
    https://www.tutorialspoint.com/spring_boot/spring_boot_sending_email.htm

 * */
/* 
@author user
 */
@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    
    //1- Send a normal text email.
    public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("rabdelhamid.isfp@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");//comma separated

        msg.setSubject("Testing sending mail from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }
    //2-send html mail
    public void sendHtmlMail() throws MessagingException, IOException 
    {
         MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("rabdelhamid.isfp@gmail.com");

        helper.setSubject("Testing send html mail from Spring Boot");
        helper.setText("<h1>Testing send html mail from Spring Boot!</h1>", true);
      
        javaMailSender.send(msg);
    }
    //3-send html mail with attachement
     public void sendMailAttachement() throws MessagingException, IOException 
    {
         MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("rabdelhamid.isfp@gmail.com");

        helper.setSubject("Testing Send Attachement mail from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("Spring-Security-logo.png", new ClassPathResource("Spring-Security-logo.png"));

        javaMailSender.send(msg);
    }
    
}
