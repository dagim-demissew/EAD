package com.icts.signin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import javaclasses.House;
import javaclasses.HouseDAO;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/addHomes")
@MultipartConfig
public class addHouse extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public addHouse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String location = request.getParameter("location");
        String homeDetail = request.getParameter("homeDetail");
        String salePrice = request.getParameter("salePrice");
        String rentPrice = request.getParameter("rentPrice");
        String brokerDetail = request.getParameter("brokerDetail");
        Part filePart = request.getPart("file");
        InputStream inputStream = filePart.getInputStream();// Input stream of the upload file
        HouseDAO houseDAO = new HouseDAO();
        House newHouse = new House(location, homeDetail, salePrice, rentPrice, brokerDetail,  inputStream);
		try {
			houseDAO.insertHouse(newHouse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Connection conn = null; // Connection to the database
        String message = null;  // Message will be sent back to the client


        // obtains the upload file part in this multipart request
       

      
//        try {
//            // Load the JDBC driver
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Establish the connection
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/housing?useSSL=false", "root","Wakeuptoreality123");
//
//            // SQL query to insert data into the database
//            String sql = "INSERT into homes (image, location, homeDetail, salePrice, rentPrice, brokerDetail) VALUES (?, ?, ?, ?, ?, ?)";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setBlob(1, inputStream);
//            statement.setString(2, location);
//            statement.setString(3, homeDetail);
//            statement.setString(4, salePrice);
//            statement.setString(5, rentPrice);
//            statement.setString(6, brokerDetail);
//
//            // sends the statement to the database server
//            statement.executeUpdate();
//            
//            
//           
//            
//            conn.close();
//        } catch (Exception e) {
//            message = "Error: " + e.getMessage();
//        } 
        RequestDispatcher dispatcher = request.getRequestDispatcher("addHomes.jsp");
		dispatcher.forward(request, response);
        }
    }
