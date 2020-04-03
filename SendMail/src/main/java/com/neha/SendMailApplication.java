package com.neha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;


@SpringBootApplication
public class SendMailApplication  implements CommandLineRunner{


    @Autowired
    private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(SendMailApplication.class, args);
	}
	
    @Override
    public void run(String... args) {
        try {
            //sendEmail();
            sendEmailWithAttachment();
        }
        catch (MessagingException e) {e.printStackTrace();}
         catch (IOException e) {e.printStackTrace();}
        System.out.println("Om Namah Shivay");
        System.out.println("successful");
    }

    void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        //send to Mail ID
        helper.setTo("11@gmail.com");
        helper.setSubject("By Spring Boot Program :) ");
        helper.setText("<h1> Ram-Ram!Neha Here.! Sent Email by Spring Boot program !</h1>", true);
        javaMailSender.send(msg);
    }


}
