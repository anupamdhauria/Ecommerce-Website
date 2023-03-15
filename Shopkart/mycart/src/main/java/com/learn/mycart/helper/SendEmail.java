package com.learn.mycart.helper;

import com.learn.mycart.entities.User;
import com.learn.mycart.entities.ForgotPassword;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {

//genarate verification code
    public String getOtp() {
        Random rand = new Random();
        int otp = rand.nextInt(999999);
        return String.format("%06d", otp);

    }

//send email
    public boolean sendEmail(ForgotPassword fuser) throws Exception {
        boolean test = false;
        String toEmail = fuser.getEmail();
//System.out.println(toEmail);
        final String fromEmail = "shopkarteasy@gmail.com";
        final String password = "onlineshop";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        });
        System.out.println(fuser.getCode());

        System.out.println("hii");

        try {
//set email deatils
            Message mess = new MimeMessage(session);
//set from email address
            mess.setFrom(new InternetAddress(fromEmail));

//set to email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

//set email subject
            mess.setSubject("Password Verification");

//set message text
            mess.setText("Please verify your account using this code: " + fuser.getCode());

            //send the message
            Transport.send(mess);

            test = true;

        } catch (Exception ex) {
        }
        return test;
    }

//send password details to user
    public void sendNewPassword(String email, String newPassword) throws Exception {

        String toEmail = email;

        final String fromEmail = "shopkarteasy@gmail.com";
        final String password = "onlineshop";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        });

        try {
//set email deatils
            Message mess = new MimeMessage(session);
//set from email address
            mess.setFrom(new InternetAddress(fromEmail));

//set to email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

//set email subject
            mess.setSubject("Password change successfully!!New Password");

//set message text
            mess.setText("Your new password :   " + newPassword);

            //send the message
            Transport.send(mess);

            // test = true;
        } catch (Exception ex) {
        }

    }



//send user details 
    public void sendUserDetails(String userName, String userEmail, String userPassword, String userPhone, String userAddress) throws Exception {

        String toEmail = userEmail;

        final String fromEmail = "shopkarteasy@gmail.com";
        final String password = "onlineshop";

        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        });

        try {
//set email deatils
            Message mess = new MimeMessage(session);
//set from email address
            mess.setFrom(new InternetAddress(fromEmail));

//set to email address
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

//set email subject
            mess.setSubject("User Registration Successfull");

//set message text
            mess.setText("Your user name :   " + userName+"\n"+"user email id :   " + userEmail+
"\n"+"user password :   " + userPassword+"\n"+"user phone no. :   " + userPhone+"\n"+"user Address:   " + userAddress);
         

            //send the message
            Transport.send(mess);

            // test = true;
        } catch (Exception ex) {
        }

    }
}
