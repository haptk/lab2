package library;

import java.util.ArrayList;

import SQL.BookTable;
import SQL.autherTable;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateInfo extends ActionSupport{
	private String ISBN , Title,  Publisher, PublishDate, Price;
	private String AuthorID , Name, Age, Country,order;
	
	public String book(){
		BookTable bt=new BookTable();
		ArrayList<String> b=bt.get(ISBN);
		System.out.println(ISBN+Title);
		if(b==null)return "error";
		AuthorID=b.get(2);
		ArrayList<String> info=new ArrayList<String>();
		info.add(ISBN);
		info.add(Title);
		info.add(AuthorID);
		info.add(Publisher);
		info.add(PublishDate);
		info.add(Price);
		order="更新";
		if(bt.Delete(ISBN)&&bt.Insert(info)){
			return "update_ok";}
		else{ return "error";}
	}
	
	public String newAuthor(){
		autherTable at=new autherTable();
		BookTable bt=new BookTable();
		AuthorID=at.getNewID();
		order="插入";
		ArrayList<String> info=new ArrayList<String>();
		ISBN=bt.getNewID();
		info.add(ISBN);
		info.add(Title);
		info.add(AuthorID);
		info.add(Publisher);
		info.add(PublishDate);
		info.add(Price);
		if(Price.matches("\\d+")){
			if(at.insert(AuthorID, Name,Age,Country)&&bt.Insert(info))
				return "new_ok";
			else return "error";
		}
		
		return "error";
	}
	
	public String newbook(){
		BookTable bt=new BookTable();
		autherTable at=new autherTable();
		boolean flag=false;
		order="插入";
		//System.out.println(ISBN+Title);
		synchronized (ActionSupport.class) {
			ArrayList<String> auther=at.FindID(Name);
			if(auther.size()<1){
				flag=true;
				//AuthorID=at.getNewID();
				//if(!at.insert(AuthorID,Name))return "error";
			}
			else {
				AuthorID=auther.get(0);
				ArrayList<String> info=new ArrayList<String>();
				ISBN=bt.getNewID();
				info.add(ISBN);
				info.add(Title);
				info.add(AuthorID);
				info.add(Publisher);
				info.add(PublishDate);
				info.add(Price);
				if(bt.Insert(info))return "new_ok";
				else return "error";
			}
		}

		if(flag)return "new_a_ok";
		else{ return "error";}
	}
	
	
	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
