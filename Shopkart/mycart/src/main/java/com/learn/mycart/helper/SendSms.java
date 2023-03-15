/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.learn.mycart.helper;

import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

public class SendSms 
{

    public static void sendOTP(String OTP, String mobileNumber) {

        try {
            String apiKey = "1PLGtdsilOJohgS5802mpn6TuNjIBRYbaC9UVMAec4qQ3Df7yExN6KaXv9RhJk1s0SCIc2GyDl5Mfi34";
            String routeValue = "v3";
            String sender_id = "TXTIND";
            String language = "english";
            String message = "your OTP :" + OTP;
            message = URLEncoder.encode(message, "UTF-8");
            System.out.println(message);
//creating url
            String url = "https://www.fast2sms.com/dev/bulkV2?authorization=" + apiKey + "&sender_id=" + sender_id
                    + "&message=" + message + "&route=" + routeValue + "&numbers=" + mobileNumber;
//sending URL request
            URL myUrl = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) myUrl.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("cache-control", "no-cache");
            int code = con.getResponseCode();
            System.out.println("response code" + code);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    
}
