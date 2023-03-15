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




                        <div class="card-body" id="verify id">                            
                            <%@include file="components/message.jsp" %>
                            <form action="VerifyCode" method="post">

                                <div class="form-group">
                                    <label for="Inputverificationcode">Please Enter your One Time Password</label>
                                    <input  name="verifycode" type="text" class="form-control" id="verifycode" placeholder="Enter OTP">
                                </div>

                                <div class="container text-center"> 
                                    <button type="submit" onclick="emailenabled()" class="btn btn-primary border-0 custom-bg ">Verify</button>
                                    <button type="reset" class="btn btn-primary custom-bg border-0 ">Reset</button>
                                </div>

                            </form>

                        </div>



                    </div>
                </div>
            </div>





    </body>
</html>

