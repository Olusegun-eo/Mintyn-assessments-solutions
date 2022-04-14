package com.hospitalmanagementsystem.mailservice;


import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public static void sendMail(){
        System.out.println("The email is working!!!");
    }
}
