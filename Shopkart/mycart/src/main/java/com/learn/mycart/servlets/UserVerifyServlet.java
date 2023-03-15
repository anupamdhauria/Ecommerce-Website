/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.learn.mycart.servlets;

import com.learn.mycart.entities.ForgotPassword;
import com.learn.mycart.helper.SendEmail;
import com.learn.mycart.helper.SendSms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author win10
 */
@WebServlet("/UserVerifyServlet")
public class UserVerifyServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Email = request.getParameter("emailforgot");
            String mobileNo = request.getParameter("mobileNoForgot");

//create sendemail instance
            SendEmail sm = new SendEmail();
            SendSms ss = new SendSms();
            String code = sm.getOtp();

//create fuser instance
            ForgotPassword fuser = new ForgotPassword(Email, code);

//call send mail method
            try {
                boolean test = sm.sendEmail(fuser);
                response.getWriter().print(test);
                if (test) {
                    ss.sendOTP(code, mobileNo);
                    HttpSession httpSession = request.getSession();
                    //session.setAttribute("authcode", user);
                    httpSession.setAttribute("message", "OTP send Successfully");
                    //response.getWriter().print(test);
                    httpSession.setAttribute("authcode", fuser);
                    httpSession.setAttribute("verifyemail", Email);
                    response.sendRedirect("verifyotp.jsp");
                } else {
                    out.println("Failed to send verification email");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
