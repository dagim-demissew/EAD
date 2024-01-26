<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Admin Page</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css" href="css/addhomes.css">
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
                    
                    <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Add a new House</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form  method ="post" action="addHomes" enctype="multipart/form-data">
                <div class="card-body">
                  <div class="form-group">
                    <label for="location">Location</label>
                    <input type="text" class="form-control" id="location" name="location" placeholder="Enter House location">
                  </div>

                  <div class="form-group">
                    <label for="details">House Details</label>
                    <input type="text" class="form-control" id="detail" name="homeDetail" placeholder="Enter The details of the house">
                  </div>

                  <div class="form-group">
                    <label for="sale">Sale Price</label>
                    <input type="text" class="form-control" id="sale" name="salePrice" placeholder="Enter The Saling Price">
                  </div>

                  <div class="form-group">
                    <label for="rent">Rent Price</label>
                    <input type="text" class="form-control" id="rent" name="rentPrice" placeholder="Enter The rent Price">
                  </div>

                  <div class="form-group">
                    <label for="broker">Broker Detail</label>
                    <input type="text" class="form-control" id="broker" name="brokerDetail" placeholder="Enter The Details of the specifc Broker">
                  </div>

                
                  <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" name="file" class="custom-file-input" accept="image/*" id="exampleInputFile">
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
                  <button type="submit" class="btn btn-primary">Submit</button>
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
