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
