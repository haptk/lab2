package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DbUtil {

	private PreparedStatement pstmt = null;

	private Connection con = null;

	
	public DbUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=UTF-8",
					"root", "tby1234");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public Connection getCon() {
		return con;
	}

	public void close() {
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
 
	public static void main(String args[]){
		DbUtil d=new DbUtil();
		try {
			Statement stmt =d.getCon().createStatement();
			stmt.execute("Seclect * from Author where ('00001','习近平','50','中国')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

