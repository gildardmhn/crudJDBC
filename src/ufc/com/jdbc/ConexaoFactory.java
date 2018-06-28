package ufc.com.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoFactory {
	
	public Connection conectarBanco() {
		String url = "jdbc:mysql://localhost/TrabalhoJDBC";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(url, "root", "Nokiagld93");
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
}
