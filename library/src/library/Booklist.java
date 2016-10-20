package library;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;






import SQL.BookTable;
import SQL.autherTable;

import com.opensymphony.xwork2.ActionSupport;

public class Booklist extends ActionSupport {
    private String name,ID,order;
    public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	private String[] bookR;
	public String[] getBookR() {
		return bookR;
	}

	public void setBookR(String[] bookR) {
		this.bookR = bookR;
	}

	private List<book> books;
    private List<String> book;
    public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


    public List<String> getBook() {
		return book;
	}

	public void setBook(List<String> book) {
		this.book = book;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	private String bookId;
    

    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setBooks(List<book> b){
    	this.books=b;
    }
    
    public List<book> getBooks(){
    	return books;
    }
    
    public String refresh()
    {
    	BookTable bt=new BookTable();
    	ArrayList l=bt.get(ID);
    	bookR=new String[6];
    	if(l!=null)
    	return "REFRESH";
    	else return "error";
    }
    
    
    public String detail(){
    	BookTable bt=new BookTable();
    	autherTable auth=new autherTable();
    	book=bt.get(ID);
    	if(book==null)return "error";
    	ArrayList<String> a=auth.Find(book.get(2));
    	book.addAll(a);
    	bt.close();
    	if(book.size()<10)return "error";
    	return "detail";
    }

    public String delete(){
    	BookTable bt=new BookTable();
    	autherTable auth=new autherTable();
    	
    	if(bt.Delete(ID))return "delete";
    	else return "error";
    }
    
    public String execute() {
    	BookTable bt=new BookTable();
    	autherTable at=new autherTable();
    	ArrayList<String> arr=at.FindID(name);
    	System.out.println(name);
    	if(arr==null)return "error";
    	books=new ArrayList<book>();
    	for(int i=0;i<arr.size();i++){
    		books.addAll(bt.Find(arr.get(i),name));
    		//System.out.println()
    	}
      //  System.out.println(books.size());
        bt.close();
        return "list";
    }
}
