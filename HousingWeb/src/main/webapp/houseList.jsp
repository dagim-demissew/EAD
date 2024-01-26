<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/houseList.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="css/login.css">
        <!-- Include SweetAlert CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-qvZ62R+FQ81I9+Uq3BEgOV2WjZtqSz6s8TH2gTL6S0l3L46Pcj5a2Q1YYutjz3e2oB2ixbAO8CzMqSF9UZoYNqA==" crossorigin="anonymous" referrerpolicy="no-referrer" />

<!-- Include SweetAlert JS -->
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.3/dist/sweetalert2.min.js"></script>
 
<title>Insert title here</title>
</head>
<body>
    <div class="navbar">
        <h1><a href="" style="text-decoration:none; color: black">ICT Housings</a></h1>
        <ul>
            <li><a href="">Home</a></li>
            <li><a href="">Saved</a></li>
            <li style="color: black text-transform: uppercase;"><%=session.getAttribute("name")%></li>
            <li><a href="logout">logOut</a></li>
        </ul>
    </div>
    <div>
      <div class="bookSection">
      
      <form method="post" action="" >
      
           <div class="search-container">
           <div class="form-group">
            
            <select class="form-control" id="exampleDropdown" style="width:100px; height:50px; margin-right:10px;" name="selectedOption">
                <option value="option1">Location</option>
                <option value="option2">Rent Price</option>
                <option value="option3">Sale Price</option>
                 <option value="option4">House Detail</option>
               
                <!-- Add more options as needed -->
            </select>
        </div>
       		 <input type="text" class="search-input" placeholder="Search...">
       		  <button type="submit" name="login" class="btn btn-primary">GO</button>
   			 </div>
   			 
      </form>
       
        <div class="cardsContainer">
        	<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="..." alt="Card image cap">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
   				 <a href="#" class="btn btn-primary">Go somewhere</a>
  			</div>
			</div>
			<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="..." alt="Card image cap">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
   				 <a href="#" class="btn btn-primary">Go somewhere</a>
  			</div>
			</div>
			<div class="card" style="width: 18rem;">
  			<img class="card-img-top" src="..." alt="Card image cap">
  			<div class="card-body">
    			<h5 class="card-title">Card title</h5>
    			<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
   				 <a href="#" class="btn btn-primary">Go somewhere</a>
  			</div>
			</div>
        	
          
        </div>
        

      </div>
    </div>

</body>
</html>