/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.mycart.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.*;
import com.razorpay.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author win10
 */
@WebServlet("/CreateOrder")
public class CreateOrder extends HttpServlet {

    public CreateOrder() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain");
        //order creation razorpay
        RazorpayClient Client;
        String orderId = null;
        int amt = Integer.parseInt(request.getParameter("amount"));
        System.out.println(amt);
        try {
            Client = new RazorpayClient("rzp_test_bXYPmcOzqAdg2Z", "AaTCYGVSLfClSCq1KhDWoNeY");
            JSONObject options = new JSONObject();
            options.put("amount", amt * 100);
            options.put("currency", "INR");
            options.put("receipt", "txn_123456");
            Order order = Client.Orders.create(options);
            System.out.println(order);
            orderId = order.get("id");
        } catch (RazorpayException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.getWriter().print(orderId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RazorpayClient Client;

        try {
            Client = new RazorpayClient("rzp_test_bXYPmcOzqAdg2Z", "AaTCYGVSLfClSCq1KhDWoNeY");
            JSONObject options = new JSONObject();
            options.put("razorpay_order_id", request.getParameter("razorpay_order_id"));
            options.put("razorpay_payment_id", request.getParameter("razorpay_payment_id"));
            options.put("razorpay_signature", request.getParameter("razorpay_signature"));
            boolean SigRes = Utils.verifyPaymentSignature(options, "AaTCYGVSLfClSCq1KhDWoNeY");
            if (SigRes) {
                response.getWriter().append("payment successfull");
            } else {
                response.getWriter().append("payment failed");
            }
        } catch (RazorpayException ex) {
            Logger.getLogger(CreateOrder.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
