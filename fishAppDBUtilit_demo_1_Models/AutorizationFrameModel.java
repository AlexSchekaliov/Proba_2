package fishAppDBUtilit_demo_1_Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fishAppSql.SqlConnectSingleton;

public class AutorizationFrameModel {
	
	private final static Connection connection = SqlConnectSingleton.getInstance().getConnection();
    
	ArrayList<String> list = new ArrayList<String>();
	
	public ArrayList<String> autorizationInformation(String login, String password) throws SQLException{
		
		try(CallableStatement statement=connection.prepareCall(" { call authorization_new(?,?,?) } ")){
			
			statement.setString(1, login);
			statement.setString(2, password);
			statement.setInt(3, 4);
			
		
			try(ResultSet resultSet=statement.executeQuery()){
				
				while(resultSet.next()){
				list.add(resultSet.getString(1));
				list.add(resultSet.getString(2));
				}
			}
		}
		return list;
	}
}