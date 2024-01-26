
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/signup.css">
    <!-- Include SweetAlert CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">

<!-- Include SweetAlert JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>
    

   
    <title>Document</title>
</head>
<body style ="padding-right: 0 !important;">
	<input type = "hidden" id="status" value ="<%= request.getAttribute("status")%>">
	

    <div class="bgmg" style="height: 100vh; width: 100%;"></div>
    <div class="container">
        <div class="signUpPage">
          
            <div class="signUpForm shadow p-3 mb-5 bg-body-tertiary rounded" >
              <h1 class="signUpTitle">Sign Up</h1>
              <hr>
                <form method ="post" action = "signUp">
                    <div class="mb-3">
                        <label for="name" class="form-label">Full Name</label>
                        <input class="form-control" type="text" placeholder="Type here" id="name" name="name" aria-label="default input example">
                      </div>
                    <div class="mb-3">
                      <label for="exampleInputEmail1" class="form-label">Email address</label>
                      <input type="email" name="email" class="form-control" id="exampleInputEmail1"placeholder="jhon12@gmail.com" aria-describedby="emailHelp">
                      <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Password</label>
                      <input type="password" name="password" class="form-control" placeholder="Type here" id="exampleInputPassword1">
                    </div>
                    <div class="mb-3">
                      <label for="exampleInputPassword1" class="form-label">Confirm Password</label>
                      <input type="password" name="confpass" class="form-control" placeholder="Type here" id="exampleInputPassword1">
                    </div>
                    
                    
                    <button type="submit"  value="Register" class="btn btn-primary">Sign-In</button>
                    <div>
                        <span>Already have an account? <a href="login.jsp">Login</a> </span>
                    </div>
                  </form>
            </div>
           
        </div>
    </div>
   
      <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>

    
	
	 <script>
        
        	var status = document.getElementById("status").value;
   		 	var messageFromServlet = "${requestScope.status}";
   			if(messageFromServlet == "success"){
 				
   				
   			 
 	        Swal.fire({
 	             title: 'Registration Successfull!!',
 	             text: 'Login to your account',
 	             icon: 'success',
 	             confirmButtonText: 'OK'
 	             
 	         }).then((result) => {
 	        	  if (result.isConfirmed) {
 	        		    // Redirect to another page
 	        		    window.location.href = 'login.jsp';
 	        		  }
 	        		});
 	         }
   			else if(messageFromServlet == "failed"){
   			 Swal.fire({
 	             title: 'Registration Failed',
 	             text: 'Account already exsist',
 	             icon: 'error',
 	             confirmButtonText: 'OK'
 	             
 	         })
   				
   			}
   			document.getElementById("message").innerText = messageFromServlet;	
        
    </script>


</body>
</html>