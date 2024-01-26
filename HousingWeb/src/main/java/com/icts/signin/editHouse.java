package com.icts.signin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaclasses.House;
import javaclasses.HouseDAO;

import java.io.IOException;
@WebServlet("/editHouse")
public class editHouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public editHouse() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseDAO houseDAO = new HouseDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		House existingHouse = houseDAO.selectHouse(id);
		request.setAttribute("house", existingHouse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("editHomes.jsp");
		dispatcher.forward(request, response);
	}

	

}
