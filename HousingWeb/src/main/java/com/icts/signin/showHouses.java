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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/showHouses")
public class showHouses extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HouseDAO houseDAO = new HouseDAO();
    	List<House> listHouse = houseDAO.selectAllHouses();
 		request.setAttribute("listHouse", listHouse);
 		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
 		dispatcher.forward(request, response);
    }

}
