package javaclasses;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.http.Part;

public class HouseDAO {
	
	
	private static final String INSERT_HOMES_SQL = "INSERT into homes (image, location, homeDetail, salePrice, rentPrice, brokerDetail) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String SELECT_HOME_BY_ID = "SELECT id, image, location, homeDetail, salePrice, rentPrice, brokerDetail from homes where id=? ";
	private static final String SELECT_ALL_HOMES = "SELECT * from homes";
	private static final String DELETE_HOME = "DELETE from homes where id=?";
	private static final String UPDATE_HOME_SQL = "UPDATE homes SET image=?, location=?, homeDetail=?, salePrice=?, rentPrice=?, brokerDetail=? where id=?";
	
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/housing?useSSL=false","root","Wakeuptoreality123");
	            
		} catch(SQLException e) {
			 e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	//Create House method
	
	public void insertHouse(House house) throws SQLException {
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_HOMES_SQL)){
			
			   statement.setBlob(1, house.getFile());
	           statement.setString(2, house.getLocation());
	           statement.setString(3, house.getHomeDetail());
	           statement.setString(4, house.getSalePrice());
	           statement.setString(5, house.getRentPrice());
	           statement.setString(6, house.getBrokerDetail());
	           statement.executeUpdate();
			connection.close();
			
		}
		catch(Exception e){
            e.printStackTrace();
        }
		
	}
	
	//Update House Method
	
	public boolean updateHouse(House house) throws SQLException {
		boolean rowUpdated = false;
		
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_HOME_SQL)){
				
			statement.setBlob(1, house.getFile());
			statement.setString(2, house.getLocation());
			statement.setString(3, house.getHomeDetail());
			statement.setString(4, house.getSalePrice());
			statement.setString(5, house.getRentPrice());
			statement.setString(6, house.getBrokerDetail());
			statement.setInt(7, house.getId());
			statement.executeUpdate();

			connection.close();
			rowUpdated = true;
			
		}
		return rowUpdated;
		
		
	}
	
	//Select House
	public House selectHouse(int id){
		House house = null;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_HOME_BY_ID)){
			
			preparedStatement.setInt(1,id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id2 = rs.getInt("id");
				String location = rs.getString("location");
				String homeDetail = rs.getString("homeDetail");
				String salePrice = rs.getString("salePrice");
				String rentPrice = rs.getString("rentPrice");
				String brokerDetail = rs.getString("brokerDetail");
				InputStream file = rs.getBinaryStream("image");
				house = new House(id2, location, homeDetail, salePrice, rentPrice, brokerDetail, file);
			}
		}
		catch(Exception e){
            e.printStackTrace();
        }
		return house;
		
	}
	
	
//	Select All Houses
	public List<House> selectAllHouses(){
		List<House> houses = new ArrayList<>();
		
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_HOMES)){
			
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
		
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String location = rs.getString("location");
				String homeDetail = rs.getString("homeDetail");
				String salePrice = rs.getString("salePrice");
				String rentPrice = rs.getString("rentPrice");
				String brokerDetail = rs.getString("brokerDetail");
				InputStream file = rs.getBinaryStream("image");
				
				houses.add(new House(id, location, homeDetail, salePrice, rentPrice, brokerDetail, file));
			}
		}
		catch(Exception e){
            e.printStackTrace();
        }
		return houses;
		
	}
	
	
	//Delete House
	
	public boolean deleteHouse(int id) throws SQLException{
		boolean rowDeleted = false;
		try(Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_HOME);){
			statement.setInt(1, id);
			 statement.executeUpdate();
			 rowDeleted = true;
			
		}
		return rowDeleted;
	}
	
	
	

}
