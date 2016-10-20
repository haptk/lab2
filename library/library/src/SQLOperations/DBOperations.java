package SQLOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.book;

public class DBOperations {
	private Connection con;
	private PreparedStatement pstmt = null;
	
	public DBOperations(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://mwjphyeksnnd.rds.sae.sina.com.cn:10107/bookdb?useUnicode=true&characterEncoding=UTF-8",
					"root","123456");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
   public boolean Insert(ArrayList array){
	  	 int n=array.size();
	  	 String Order="INSERT INTO book VALUES(";
	  	 String tail=",";
	  	 for(int i=0;i<n;i++){
	  		 if(i==n-1)tail=")";
	  		 if(array.get(i) instanceof String)
	  		   Order=Order+"'"+array.get(i)+"'"+tail;
	  		 else Order=Order+array.get(i)+tail;
	  	 }
	  	 Statement stmt;
			try {
				stmt = con.createStatement();
				stmt.executeUpdate(Order);
				
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
	  	 return true;
	  	 
	    }
		
	public boolean DeleteBook(String id){
		 String Order="DELETE FROM book WHERE ISBN like "+id;
		 Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(Order);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		 return true;
	  }
	
    public ArrayList<String> GetBookInfo(String id){
    	ArrayList<String> a=new ArrayList();
    	String Order="SELECT * FROM book WHERE ISBN like "+id;
    	Statement stmt;
		try {
			ArrayList<book> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			if(rs.next()){
	  			for (int i=1;i<=6;i++)
    	  			{
	  					a.add(rs.getObject(i)+"");
    	  			}
    	  		return a;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
        
    public String FindAutherName(String AutherId){
    	String AuthorName="";
    	String Order="SELECT * FROM author WHERE AuthorID = "+AutherId;
    	Statement stmt;
		try {
			ArrayList<book> BookList=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
				AuthorName = rs.getObject(2)+"";
			}
			return AuthorName;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
    }
    
    public ArrayList<book> FindBooksByAutherId(String AutherId,String name){
  	  	String Order="SELECT * FROM book WHERE AuthorID = "+AutherId;
    	Statement stmt;
		try {
			ArrayList<book> BookList=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
				book Book=null;
	  			for (int i=1;i<=6;i++)
    	  			{
	  				
	  					if(i==1){
	  						String ISBN=rs.getObject(1)+"";
	  						String title=rs.getObject(2)+"";
	  						Book = new book(ISBN,title,name);
	  						BookList.add(Book);
	  					}
	  					else rs.getObject(i);
    	  			}

			}
			return BookList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
   }   
    
    public ArrayList<String> FindAuthersIdsByname(String name){
  	  	String Order="SELECT * FROM author WHERE Name like '"+name+"'";
    	Statement stmt;
		try {
			ArrayList<String> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
	  			for (int i=1;i<=4;i++)
    	  			{
	  					if(i==1)b.add(rs.getObject(i)+"");
	  					else rs.getObject(i);
    	  			}
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
    
    public ArrayList<String> FindAutherInfoByAutherId(String id){
  	  	String Order="SELECT * FROM author WHERE AuthorID like "+id;
    	Statement stmt;
		try {
			ArrayList<String> b=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			if(rs.next()){
	  			for (int i=1;i<=4;i++)
    	  			{
	  					b.add(rs.getObject(i)+"");
    	  			}
			}
			return b;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
    }
       
    public ArrayList<book> GetAllBooks(){
  	  	String Order="SELECT * FROM book";
    	Statement stmt;
		try {
			ArrayList<book> BookList=new ArrayList();
			stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery(Order);
			while(rs.next()){
				book Book=null;
	  			for (int i=1;i<=6;i++)
    	  			{
	  				
	  					if(i==1){
	  						String ISBN=rs.getObject(1)+"";
	  						String title=rs.getObject(2)+"";
	  						String authorid=rs.getObject(3)+"";
	  						String name = FindAutherName(authorid);
	  						Book = new book(ISBN,title,name);
	  						BookList.add(Book);
	  					}
	  					else rs.getObject(i);
    	  			}

			}
			return BookList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
   }
    
}
