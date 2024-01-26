package com.icts.signin;

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
import java.sql.SQLException;

@WebServlet("/updateHouse")
@MultipartConfig
public class updateHouse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public updateHouse() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseDAO houseDAO = new HouseDAO();
		 int id = Integer.parseInt(request.getParameter("id"));
		 String location = request.getParameter("location");
		 String homeDetail = request.getParameter("homeDetail");
		 String salePrice = request.getParameter("salePrice");
		 String rentPrice = request.getParameter("rentPrice");
		 String brokerDetail = request.getParameter("brokerDetail");
		 Part filePart = request.getPart("file");
	     InputStream inputStream = filePart.getInputStream();// Input stream of the upload file
		 House updatedHouse = new House(id, location, homeDetail, salePrice, rentPrice, brokerDetail,  inputStream);
		 try {
			houseDAO.updateHouse(updatedHouse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 response.sendRedirect("addHomes.jsp");
	}

}
