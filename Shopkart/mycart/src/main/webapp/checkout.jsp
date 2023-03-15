<%

    User user = (User) session.getAttribute("current-user");
    if (user == null) {

        session.setAttribute("message", "You are not logged in !! Login first to access checkout page");
        response.sendRedirect("login.jsp");
        return;

    }

%>





<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
        <%@include file="components/common_css_js.jsp" %>
        <script src="js/script.js" type="text/javascript"></script>
        <script type="text/javascript" src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
        <script>
            (function () {
                emailjs.init("wqzHg1o6ODEL3Kt3H");
            })();
        </script>
        <script>
            /*var xhttp = new XMLHttpRequest();
             var RazorpayOrderID;
             
             
             function CreateOrderId()
             {
             
             xhttp.open("GET", "CreateOrder", false);
             //alert("hii i am in this function...................");
             xhttp.send();
             RazorpayOrderID = xhttp.responseText;
             console.log(RazorpayOrderID);
             OpenCheckout();
             
             //alert("hii i am in this function");
             }*/
            var RazorpayOrderID;
            let order_id1 = 0;
            let payment_id = 0;
            function CreateOrderId()
            {
                // alert("hiii");
                $.ajax({

                    url: 'http://localhost:8080/mycart/CreateOrder',
                    type: 'GET',
                    data: {amount: amount},
                    success: function (response)
                    {
                        RazorpayOrderID = response.toString();
                        OpenCheckout();
                    }


                });
            }


            function OpenCheckout()
            {
                //alert("hii i am in this function");
                // alert(RazorpayOrderID);
                var options = {"key": "rzp_test_bXYPmcOzqAdg2Z",
                    "amount": "100",
                    "currency": "INR",
                    "name": "Shopkart",
                    "description": "Thank you for purchasing",
                    "order_id": RazorpayOrderID,
                    "image": "https://png.pngtree.com/png-clipart/20190614/original/pngtree-euro-golden-logo-png-image_3718297.jpg",
                    "handler": function (response)
                    {
                        console.log(response.razorpay_payment_id);
                        console.log(response.razorpay_order_id);
                        console.log(response.razorpay_signature);
                        swal("Thanks for Purchasing!!", "Your Order has been Confirmed", "success");
                      

                        //email integration from emailjs
                        var emailvalue = {
                            emaii_id: "<%=user.getUserEmail()%>",
                            to_name: "<%=user.getUserName()%>",
                            orderid: RazorpayOrderID,
                            amount: amount,
                            status: "success",
                        };
                        emailjs.send('service_m3jge5h', 'template_d7yo14d', emailvalue);
                        //window.location = "order.jsp";
                    },
                    "callback_url": "http://localhost:8080/mycart/CreateOrder",
                    "prefill":
                            {
                                "name": "<%= user.getUserName()%>",
                                "email": "<%= user.getUserEmail()%>",
                                "contact": "<%=user.getUserPhone()%> ",
                            },
                    "notes":
                            {"address": "shopkart office"
                            },
                    "theme":
                            {"color": "#3399cc"
                            }
                };
                //alert("hii i am in end function");
                var rzp1 = new Razorpay(options);
                rzp1.on('payment.failed', function (response) {
                    console.log(response.error.code);
                    console.log(response.error.description);
                    console.log(response.error.source);
                    console.log(response.error.step);
                    console.log(response.error.reason);
                    console.log(response.error.metadata.order_id);
                    console.log(response.error.metadata.payment_id);
                    swal("Oops!payment failed ", "please try again!", "error");
                    //window.location = "checkout.jsp";
                    //email integration from emailjs
                    var emailvalue = {
                        emaii_id: "<%=user.getUserEmail()%>",
                        to_name: "<%=user.getUserName()%>",
                        orderid: RazorpayOrderID,

                        amount: amount,
                        status: "failed",
                    };
                    emailjs.send('service_m3jge5h', 'template_gqjjbjc', emailvalue);
                });
                rzp1.open();
            }
        </script>



    </head>
    <body>
        <%@include  file="components/navbar.jsp" %>

        <div class="container">
            <div class="row mt-5">                

                <div class="col-md-6">
                    <!--card-->
                    <div class="card">
                        <div class="card-body">

                            <h3 class="text-center mb-5">Your selected items</h3>

                            <div class="cart-body">

                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-md-6">
                    <!--form details-->
                    <!--card-->
                    <div class="card">
                        <div class="card-body">

                            <h3 class="text-center mb-5">Your details for order</h3>
                            <form action="#">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input value="<%= user.getUserEmail()%>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="name">Your name</label>
                                    <input name="user_name" value="<%= user.getUserName()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name">
                                </div>


                                <div class="form-group">
                                    <label for="name">Your contact</label>
                                    <input name="user_phone" value="<%= user.getUserPhone()%>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter contact number">
                                </div>


                                <div class="form-group">
                                    <label for="exampleFormControlTextarea1" >Your shipping address</label>
                                    <input name="user_address" value="<%=user.getUserAddress()%>" class="form-control" id="exampleFormControlTextarea1" placeholder="Enter your address" rows="3" >
                                </div>

                                <div class="container text-center">
                                    <button   onclick="CreateOrderId()" class="btn btn-outline-success"  >Order Now</button>
                                    <a href="normal.jsp" class="btn btn-outline-primary ">Continue Shopping</a>
                                </div>

                            </form>    

                        </div>
                    </div>
                </div>
            </div>

        </div>


        <%@include  file="components/common_modals.jsp" %>
    </body>
</html>
