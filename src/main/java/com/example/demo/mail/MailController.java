/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.mail;

import java.io.IOException;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
 @RequestMapping("/mail")    
public class MailController {
    @Autowired
    private MailService mailService;
    
    @RequestMapping(method = RequestMethod.GET,value = "/sendTextMail")    
    public String  sendTextMail() {
       mailService.sendEmail();
       return "Email sent successfully";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/sendHtmlMail")    
    public String  sendHtmlMail() throws MessagingException, IOException {
       mailService.sendHtmlMail();
       return "Html Email sent successfully";
    } 
    @RequestMapping(method = RequestMethod.GET,value = "/sendMailAttachement")    
    public String  sendMailAttachement() throws MessagingException, IOException {
       mailService.sendMailAttachement();
       return "Mail with Attachement sent successfully";
    }
    
}
