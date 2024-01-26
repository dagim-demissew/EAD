<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="javaclasses.House" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="javaclasses.ImageUtil" %>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg  bg-light fixed-top">
        <h2>Admin</h2>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="editAdmin.jsp">Settings</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">logOut</a>
                </li>
                <li class="nav-item"><a class="nav-link"><%=session.getAttribute("name")%></a></li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid" >
        <div class="row">

            <!-- Sidebar -->
            <nav class="col-md-3 col-lg-2 d-md-block bg-light  sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="showHouses">
                                <i class="fas fa-tachometer-alt"></i> Houses
                            </a>
                        </li>
                        <li class="nav-item">
                             <a class="nav-link" href="showUsers">
                                <i class="fas fa-chart-bar"></i> Users
                            </a>
                        </li>
                       
                        <!-- Add more sidebar items as needed -->
                    </ul>
                </div>
            </nav>

            <!-- Main Content Area -->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="content">
                    <h2>Main Content Area</h2>
                    <div class="card">
                    <div class="card-header">
                      <h3 class="card-title">Data Table With Full Features</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                      <table id="example1" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                          <th>Image</th>
                          <th>Location</th>
                          <th>House detail</th>
                          <th>Sale price</th>
                          <th>Rent price</th>
                          <th>Broker Detail</th>
                          <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                       <% List<House> list = (List<House>) request.getAttribute("listHouse");
                       
                       for (House house : list) {

						%>
						         <tr>
						         <%
								    // Assuming house.getFile() returns a ByteArrayInputStream
								    InputStream imageStream = house.getFile();
								    String base64Image = ImageUtil.convertInputStreamToBase64(imageStream);
								 %>
						            <td>
						                <img src="data:image/png;base64,<%= base64Image %>" style="width:200px; border:1px solid lightgray; height:200px; object-fit:cover;">
						            </td>
						            
						            <td><%= house.getLocation() %></td>
						            <td><%= house.getHomeDetail() %></td>
						            <td><%= house.getSalePrice() %></td>
						            <td><%= house.getRentPrice() %></td>
						            <td><%= house.getBrokerDetail() %></td>
						           
						            <td>
						             <form action="editHouse" method="get" style= "margin:10px;">
						                 <input type="hidden" name="id" value="<%= house.getId()%>">
										    <button type="submit" class="btn btn-primary">Edit</button>
										</form>
						                <form action="deleteHouse" method="post" style= "margin:10px;">
						                 <input type="hidden" name="id" value="<%= house.getId()%>">
										    <button type="submit" class="btn btn-danger">Delete</button>
										</form>
		
						            </td>
						        </tr>
						<%
                       }
						%>
                        </tbody>
                        <tfoot>
                        <tr>
                          <th><a href="addHomes.jsp"><button type="button" class="btn btn-success" style="margin-right: 10px;">+ Add new</button></a></th>
                          
                        </tr>
                        </tfoot>
                      </table>
                    </div>
                    <!-- /.card-body -->
                  </div>
                </div>
            </main>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/your-font-awesome-kit-id.js" crossorigin="anonymous"></script>


</body>
</html>
