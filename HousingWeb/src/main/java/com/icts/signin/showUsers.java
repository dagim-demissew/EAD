package com.icts.signin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaclasses.House;
import javaclasses.HouseDAO;
import javaclasses.UserDatabase;
import javaclasses.connectionPro;
import javaclasses.users;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

@WebServlet("/showUsers")
public class showUsers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		UserDatabase userData = new UserDatabase(connectionPro.getConnection());
    	List<users> listUsers;
		listUsers = userData.selectAllUsers();
 		request.setAttribute("listUsers", listUsers);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("users.jsp");
 		dispatcher.forward(request, response);
    }

}
