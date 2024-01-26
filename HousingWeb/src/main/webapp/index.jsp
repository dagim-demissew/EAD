<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%
   if(session.getAttribute("name")== null){
	    response.sendRedirect("login.jsp");
	    }
%>
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/design2.css">
</head>
<body>
    
<div class="banner">

    <div class="navbar">
        <h1><a href="" style="text-decoration:none; color:white;">ICT Housings</a></h1>
        <ul>
            <li><a href="">Home</a></li>
            <li><a href="">Saved</a></li>
            <li style="color:white; text-transform: uppercase;"><%=session.getAttribute("name")%></li>
            <li><a href="logout">logOut</a></li>
        </ul>
    </div>
<div class="content">
    <h1>Desing Your House</h1>
    <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Eveniet nihil repudiandae pariatur rem, dicta error, consectetur <br>iusto cumque totam delectus deserunt amet consequatur alias deleniti. Labore eum dolorum quod voluptas.</p>
<div>
   <a href="houseList.jsp"> <button type="button"><span></span>Explore Homes</button></a>
    
</div>

</div>
</div>

</body>
</html>