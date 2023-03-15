<%@page import="com.learn.mycart.entities.User" %>
<%@page import="com.learn.mycart.entities.ForgotPassword" %>
<%@page import="com.learn.mycart.helper.SendEmail"%>
<%@page import="com.learn.mycart.servlets.UserVerifyServlet"%>"
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
        <%@include file="components/common_css_js.jsp" %>


    </head>

    <body > 
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">

                    <div class="card mt-3">

                        <div class="card-header custom-bg text-white">
                            <h3>Forgot Password</h3>
                        </div>



                        <div class="card-body" id="emaildiv">                            
                            <%@include file="components/message.jsp" %>
                            <form action="UserVerifyServlet" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input  name="emailforgot" type="email" class="form-control" id="emailforgot" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputOTP">Mobile No.</label>
                                    <input  name="mobileNoForgot" type="text" class="form-control" aria-describedby="registeredMobileNo" placeholder="Enter registered mobileno">
                                    
                                </div>

                                <div class="container text-center"> 
                                    <button type="submit" class="btn btn-primary border-0 custom-bg ">Submit</button>
                                    <button type="reset" class="btn btn-primary custom-bg border-0 ">Reset</button>
                                </div>

                            </form>

                        </div>




                        <!--
                      
                       

                        -->


                    </div>
                </div>
            </div>





    </body>
</html>
