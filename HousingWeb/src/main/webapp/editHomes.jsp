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
    <link rel="stylesheet" type="text/css" href="css/editHomes.css">
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
                <div class="content" style = "display:flex; ">
                 <% House house = (House) request.getAttribute("house");%>
                     <%
								    // Assuming house.getFile() returns a ByteArrayInputStream
								    InputStream imageStream = house.getFile();
								    String base64Image = ImageUtil.convertInputStreamToBase64(imageStream);
								 %>
						            <div>
						                <img src="data:image/png;base64,<%= base64Image %>" style=" margin:40px 80px; width:400px; border:1px solid lightgray; height:400px; object-fit:cover; ">
						            </div>
                    <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Edit House Details</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
             
              <form role="form" action="updateHouse" method="post" enctype="multipart/form-data">
              <input type="hidden" name="id" value="<%= house.getId()%>">
                <div class="card-body">
                  <div class="form-group">
                    <label for="location">Location</label>
                    <input type="text" name="location" class="form-control" id="location" value="<%= house.getLocation()%>" placeholder="Enter House location">
                    
                  </div>

                  <div class="form-group">
                    <label for="details">House Details</label>
                    <input type="text" name="homeDetail" class="form-control"value="<%= house.getHomeDetail()%>" id="detail" placeholder="Enter The details of the house">
                  </div>

                  <div class="form-group">
                    <label for="sale">Sale Price</label>
                    <input type="text" name="salePrice" class="form-control" value="<%= house.getSalePrice()%>" id="sale" placeholder="Enter The Saling Price">
                  </div>

                  <div class="form-group">
                    <label for="rent">Rent Price</label>
                    <input type="text" name="rentPrice" class="form-control" value="<%= house.getRentPrice()%>" id="rent" placeholder="Enter The rent Price">
                  </div>

                  <div class="form-group">
                    <label for="broker">Broker Detail</label>
                    <input type="text" name="brokerDetail" class="form-control" value="<%= house.getBrokerDetail()%>" id="broker" placeholder="Enter The Details of the specifc Broker">
                  </div>

                
                  <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file"  name="file" class="custom-file-input" id="exampleInputFile">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text" id="">Upload</span>
                      </div>
                    </div>
                  </div>
               
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Update</button>
                </div>
              </form>
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
