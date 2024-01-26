package com.icts.signin;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaclasses.HouseDAO;
import javaclasses.UserDatabase;
import javaclasses.connectionPro;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteUser() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDatabase userData = new UserDatabase(connectionPro.getConnection());
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		try {
			userData.deleteUser(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("landingPage.jsp");
	}

}
