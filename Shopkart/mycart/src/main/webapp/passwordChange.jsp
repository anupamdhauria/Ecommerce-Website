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




                        <div class="card-body">                            
                      
                       <form action="ResetPassword" method="post">
                         
                           <div class="form-group">
                               <label for="exampleInputPassword1">New Password</label>
                               <input  name="newpassword" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                           </div>

                           <div class="container text-center"> 
                               <button type="submit" class="btn btn-primary border-0 custom-bg ">Reset Password</button>
                               <button type="reset" class="btn btn-primary custom-bg border-0 ">Reset</button>
                           </div>

                       </form>

                   </div>

           </div>



                    </div>
                </div>
            </div>





    </body>
</html>

