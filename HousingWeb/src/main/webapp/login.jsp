<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
        <!-- Include SweetAlert CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">

<!-- Include SweetAlert JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>
    <title>Document</title>
</head>
<body>
<input type = "hidden" id="status" value ="<%= request.getAttribute("status")%>">
    <div class="bgmg" style="height: 100vh; width: 100%;"></div>
    <div class="container">
        <div class="loginPage">
            <div class="loginForm shadow p-3 mb-5 bg-body-tertiary rounded" >
                <h1 class="loginTitle">Login</h1>
                <hr>
                <form method="post" action="Login">
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Email address</label>
                      <input type="email" class="form-control" name="email" id="exampleInputEmail1" aria-describedby="emailHelp">
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Password</label>
                      <input type="password" name="password" class="form-control" id="exampleInputPassword1">
                    </div>
                  
                    
                    <button type="submit" name="login" class="btn btn-primary">Login</button>
                    <div>
                        <span>don't have an account? <a href="signUp.jsp">Sign up</a> </span>
                    </div>
                  </form>
            </div>
           
        </div>
    </div>
     <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>
     <script>
        
        	var status = document.getElementById("status").value;
   		 	var messageFromServlet = "${requestScope.status}";
   			if(messageFromServlet == "failed"){
 				
   				
   			 
 	        Swal.fire({
 	             title: 'Login Failed!',
 	             text: 'Please input the correct credentials',
 	             icon: 'error',
 	             confirmButtonText: 'OK'
 	             
 	         }).then((result) => {
 	        	  if (result.isConfirmed) {
 	        		    // Redirect to another page
 	        		    window.location.href = 'login.jsp';
 	        		  }
 	        		});
 	         }
   			document.getElementById("message").innerText = messageFromServlet;	
        
    </script>
    
</body>
</html>