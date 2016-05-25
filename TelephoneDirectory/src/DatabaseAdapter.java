
import java.io.FileInputStream;
import java.sql.*;
public class DatabaseAdapter {
	Connection connection;
	PreparedStatement statement;
	ResultSet resultSet;
	public DatabaseAdapter(){
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","sem_v","avadhesh");
				
	}catch (Exception e) {
	
	}
}
	public PreparedStatement insertdata(String value) throws Exception {
		
			statement=connection.prepareStatement("insert into telephonedir "+value);
				
		
		return statement;
	}
	
	public ResultSet getTableData(String query)throws Exception {
	
		statement=  connection.prepareStatement(query);
			resultSet= statement.executeQuery();
			
		
		return resultSet;
	}
	
	
	public void close() {
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {  }
	}
}