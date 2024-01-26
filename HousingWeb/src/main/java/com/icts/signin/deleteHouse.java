package com.icts.signin;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaclasses.HouseDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteHouse")
public class deleteHouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteHouse() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseDAO houseDAO = new HouseDAO();
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		try {
			houseDAO.deleteHouse(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("addHomes.jsp");
	}

}
