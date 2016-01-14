/*Copyright (c) 2016-2017 Business on Demand Ltd. All Rights Reserved. This software is the confidential and proprietary information of Business on Demand Ltd. You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with Business on Demand Ltd.*/

package com.bccontrolpanel.mailservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import java.util.Random;

//import com.bccontrolpanel.mailservice.model.*;
import com.wavemaker.runtime.service.annotations.ExposeToClient;
/**
 * This is a singleton class with all of its public methods exposed to the client via controller.
 * Their return values and parameters will be passed to the client or taken
 * from the client respectively.
 */
@ExposeToClient
public class MailService {

    private static final Logger logger=LoggerFactory.getLogger(MailService.class);

    private String generateRandomPassword() {
        String Characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrtsvuwxyz0123456789";
        Random rnd = new Random();
        int len = 10;
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < len; i++ ) 
            sb.append(Characters.charAt(rnd.nextInt(Characters.length())));
        return sb.toString(); 
    }


    public String sendPasswordReset(String toEmailAddress, String userID) {
    try{
        
        //Mysql update users password where id = userid;
        
        
        String username = "email username";
        String password = "email password";
        
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "SMTP HOST HERE");
        props.put("mail.smtp.port", "SMTP PORT HERE");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.required", "true");
        Session session = Session.getDefaultInstance(props,null);
        
        String randomPW = generateRandomPassword();
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("BoDConnect Control Panel"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAddress));
        message.setSubject("BoDConnect Control Panel Password Reset");
        message.setContent("New Password :" + randomPW, "text/html");
        
        Transport tr = session.getTransport("smtp");
        tr.connect("smtp.gmail.com", 587, username, password);
        message.saveChanges();
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
        
        return "Mail Sent Successfully";
    } catch (MessagingException e) {
        return "Error" + e;
    }
        
    }
    
    
    
    
    

}
