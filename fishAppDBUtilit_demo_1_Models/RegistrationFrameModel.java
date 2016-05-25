package fishAppDBUtilit_demo_1_Models;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import fishAppSql.SqlConnectSingleton;

public class RegistrationFrameModel {
	
	private final static Connection connection = SqlConnectSingleton.getInstance().getConnection();
	private final static String loginSQLQuery = "SELECT [Id Моряка] FROM dbo.Моряк WHERE [Логин]=?";

	public boolean checkLoginDuplicate(String login) throws SQLException {

		try (PreparedStatement statement = connection.prepareStatement(loginSQLQuery)) {

			statement.setString(1, login.trim());

			try (ResultSet resultSet = statement.executeQuery()) {

				if (resultSet.next())
					return false;
			}
		}

		return true;
	}
	
	public void registationUser(String surname, String name,String patronymic, String dataBirth,String address) throws SQLException {
		
		try(CallableStatement callableStatement=connection.prepareCall(" { call registration(?,?,?) } "))
		{
		callableStatement.setString(1, formatClientData(surname)+" "+formatClientData(name)+" "+formatClientData(patronymic));
        callableStatement.setString(2, dataBirth.trim());
        callableStatement.setString(3, address.trim());
        callableStatement.executeUpdate();
		}
	}
		
		private String formatClientData(String data){
			
			return data.substring(0,1).toUpperCase()+data.substring(1).toLowerCase().trim();
		}
		
	public boolean isEmptyDataUser(String dataUser){
		
		
		return dataUser.equals("") ? true:false; 
	}
	
	public boolean checkAge(String string){
		if((Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(string.split("/")[2]))>60||(Calendar.getInstance().get(Calendar.YEAR)-Integer.parseInt(string.split("/")[2]))<20){
			return false;
		}
		
		return true;
	}
	
}