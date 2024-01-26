package javaclasses;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;

public class UserDatabase {
    Connection con ;

    public UserDatabase(Connection con) {
        this.con = con;
    }
    
    //for register user 
    public boolean saveUser(users user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into user_table(name, email, password) values(?,?,?)";
           PreparedStatement validateuser = con.prepareStatement("select * from user_table where email = ?" );
           validateuser.setString(1,user.getEmail());
          
            ResultSet result = validateuser.executeQuery();
           if(result.next()) {
        	   set = false;
           }
           else {
        	    PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPassword());
           
           pt.executeUpdate();
           con.close();
           set = true;
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        return set;
    }
    
//	Select All Users
	public List<users> selectAllUsers(){
		List<users> Users = new ArrayList<>();
		
		try{
			
			String query = "SELECT * from user_table";
	        PreparedStatement getUser = con.prepareStatement(query);
			System.out.println(getUser);
			ResultSet rs = getUser.executeQuery();
		
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				
				
				Users.add(new users(id, name, email));
			}
		}
		catch(Exception e){
            e.printStackTrace();
        }
		return Users;
		
	}
	
	//Delete User
	
		public boolean deleteUser(int id) throws SQLException{
			boolean rowDeleted = false;
			try{
				String query = "DELETE from user_table where id=?";
		        PreparedStatement deleteUser = con.prepareStatement(query);
		        deleteUser.setInt(1, id);
		        deleteUser.executeUpdate();
				 rowDeleted = true;
				
			}
			catch(Exception e){
	            e.printStackTrace();
	        }
			return rowDeleted;
		}
		
	
}