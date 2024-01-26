package com.icts.signin;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("email");
		String upassword = request.getParameter("password");
		HttpSession session  = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/housing?useSSL=false", "root","Wakeuptoreality123");

            // Check if the user is in the admin table
            PreparedStatement adminCheck = con.prepareStatement("select * from admin_table where email = ? and password = ?" );
            adminCheck.setString(1, uemail);
            adminCheck.setString(2, upassword);

            ResultSet adminResult = adminCheck.executeQuery();

            if (adminResult.next()) {
                
                session.setAttribute("name", adminResult.getString("name"));
                dispatcher = request.getRequestDispatcher("landingPage.jsp");
               
            } else {
                
                PreparedStatement userCheck = con
                .prepareStatement("select * from user_table where email = ? and password = ?");
                userCheck.setString(1, uemail);
                userCheck.setString(2, upassword);

                ResultSet userResult = userCheck.executeQuery();
                if (userResult.next()) {
                    session.setAttribute("name", userResult.getString("name"));
                    dispatcher = request.getRequestDispatcher("index.jsp");
                } else {
                    String message = "Invalid username or password";
                    request.setAttribute("status", "failed");
                    request.setAttribute("myMessage", message);
                    dispatcher = request.getRequestDispatcher("login.jsp");
                }
			}
			dispatcher.forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
