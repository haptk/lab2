package library;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import SQLOperations.DBOperations;

import com.opensymphony.xwork2.ActionSupport;

public class LibraryOperations extends ActionSupport {
    private String name,ID;
    private String ISBN , Title,  Publisher, PublishDate, Price;
	private String AuthorID, AutherName, Age, Country;
	private String[] bookR;
	private List<book> books;
    private List<String> bookinfo;
    
    public String update()
    {
    	DBOperations bt=new DBOperations();
    	ArrayList<String> l=bt.GetBookInfo(ID);
    	bookR=new String[6];
    	if(l!=null)
    	return "update";
    	else return "error";
    }
    public String allbooks()
    {
     	DBOperations bt=new DBOperations();
    	
    	books=new ArrayList<book>();
    	
    	books.addAll(bt.GetAllBooks());
    	
        bt.close();
        return "allbooks";
    }
    
    public String bookdetail(){
    	DBOperations bt=new DBOperations();
    	bookinfo=bt.GetBookInfo(ID);
    	if(bookinfo==null)
    		return "error";
    	ArrayList<String> a=bt.FindAutherInfoByAutherId(bookinfo.get(2));
    	bookinfo.addAll(a);
    	bt.close();
    	if(bookinfo.size()<10)return "error";
    	return "bookdetail";
    }
    public String delete(){
    	DBOperations bt=new DBOperations();
    	
    	if(bt.DeleteBook(ID))
    		return "delete";
    	else 
    		return "error";
    }       
    public String execute() {
    	DBOperations bt=new DBOperations();
    	ArrayList<String> AutherIdList=bt.FindAuthersIdsByname(name);
    	if(AutherIdList==null)
    		return "error";
    	books=new ArrayList<book>();
    	for(int i=0;i<AutherIdList.size();i++){
    		books.addAll(bt.FindBooksByAutherId(AutherIdList.get(i),name));
    	}
        bt.close();
        return "searchresult";
    }
    public String UpdateBookInfo(){
		DBOperations bt=new DBOperations();
		ArrayList<String> b=bt.GetBookInfo(ISBN);
		if(b==null)
			return "error";
		AuthorID=b.get(2);
		ArrayList<String> info=new ArrayList<String>();
		info.add(ISBN);
		info.add(Title);
		info.add(AuthorID);
		info.add(Publisher);
		info.add(PublishDate);
		info.add(Price);
		if(bt.DeleteBook(ISBN)&&bt.Insert(info)){
			return "update_ok";}
		else{ return "error";}
	}
    
	
    public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String[] getBookR() {
		return bookR;
	}
	public void setBookR(String[] bookR) {
		this.bookR = bookR;
	}
    public List<String> getBookinfo() {
		return bookinfo;
	}
	public void setBookinfo(List<String> bookinfo) {
		this.bookinfo = bookinfo;
	}
    public void setBooks(List<book> b){
    	this.books=b;
    }
    public List<book> getBooks(){
    	return books;
    }	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getAutherName() {
		return AutherName;
	}
	public void setAutherName(String AutherName) {
		this.AutherName = AutherName;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
}
