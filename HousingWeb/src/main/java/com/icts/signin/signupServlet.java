package com.icts.signin;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import javaclasses.users;
import javaclasses.UserDatabase;
import javaclasses.connectionPro;

import java.io.IOException;



@WebServlet("/signUp")
public class signupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		
	
			
			users user = new users(name, email, password);
			UserDatabase regUser = new UserDatabase(connectionPro.getConnection());
			if (regUser.saveUser(user)){
//			   
				 String message = "success fully registered";
				 request.setAttribute("status", "success");
				 
				 
			        request.setAttribute("myMessage", message);
			       
			} else {
			    String errorMessage = "User Available";
			    HttpSession regSession = request.getSession();
			    regSession.setAttribute("RegError", errorMessage);
			    String message = "regestration failed";
		        request.setAttribute("myMessage", message);
		        request.setAttribute("status", "failed");
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("signUp.jsp");
	        dispatcher.forward(request, response);
		

		}
		
	
			
	}
	


