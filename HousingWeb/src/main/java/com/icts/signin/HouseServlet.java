//package com.icts.signin;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import javaclasses.House;
//import javaclasses.HouseDAO;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Servlet implementation class HouseServlet
// */
//
//@WebServlet("/HouseServlet")
//public class HouseServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	private HouseDAO houseDAO;
//       
//    public HouseServlet() {
//        this.houseDAO = new HouseDAO();
//        
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	this.doGet(request, response);
//	}
//	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getServletPath();
//		
//		switch(action) {
//		case"/new":
//			showNewForm(request, response);
//		case"/insert":
//			try {
//				insertHouse(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		case"/delete":
//			try {
//				deleteHouse(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		case"/edit":
//			try {
//				HouseEditForm(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		case"/update":
//			try {
//				updateHouse(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		default:
//			try {
//				listHouse(request, response);
//			} catch (ServletException | IOException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	
//	
//	private void showNewForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
//		RequestDispatcher dispatcher = request.getRequestDispatcher("addHomes.jsp");
//		dispatcher.forward(request, response);
//	}
//	
////	insert new home method
//	
//	private void insertHouse(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
//		 String location = request.getParameter("location");
//		 String homeDetail = request.getParameter("homeDetail");
//		 String salePrice = request.getParameter("salePrice");
//		 String rentPrice = request.getParameter("rentPrice");
//		 String brokerDetail = request.getParameter("brokerDetail");
//		 
//		 House newHouse = new House(location, homeDetail, salePrice, rentPrice, brokerDetail);
//		 houseDAO.insertHouse(newHouse);
//		 response.sendRedirect("list");
//	}
//	
//	//Delete House method
//	
//	private void deleteHouse(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
//	int id = Integer.parseInt(request.getParameter("id"));
//		houseDAO.deleteHouse(id);
//		response.sendRedirect("list");
//	}
//	
//	
//	private void HouseEditForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
//		int id = Integer.parseInt(request.getParameter("id"));
//			House existingHouse = houseDAO.selectHouse(id);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("editHomes.jsp");
//			request.setAttribute("house", existingHouse);
//			dispatcher.forward(request, response);
//		}
//	
////	//Update House Method
////	private void updateHouse(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
////		int id = Integer.parseInt(request.getParameter("id"));
////		 String location = request.getParameter("location");
////		 String homeDetail = request.getParameter("homeDetail");
////		 String salePrice = request.getParameter("salePrice");
////		 String rentPrice = request.getParameter("rentPrice");
////		 String brokerDetail = request.getParameter("brokerDetail");
////		 
////		 House updatedHouse = new House(id, location, homeDetail, salePrice, rentPrice, brokerDetail);
////		 houseDAO.updateHouse(updatedHouse);
////		 response.sendRedirect("list");
////		}
////	
//	
//	//List Houses Method
//	
//	private void listHouse(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException{
//		
//		List<House> listHouse = houseDAO.selectAllHouses();
//		request.setAttribute("listHouse", listHouse);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
//		dispatcher.forward(request, response);
//		}
//	
//		
//	
//	
//
//}
