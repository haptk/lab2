package library;

public class book {
	public String name="";
	public String auther="";
	public String ID="";
	public book(String id,String name,String auther){
		this.name=name;
		this.auther=auther;
		this.ID=id;
	}
	
	public String getName(){
		return name;
	}
	public String getID(){
		return ID;
	}
	public void setID(String ID){
		this.ID=ID;
	}
	public String getAuther(){
		return auther;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setAuther(String name){
		this.auther=name;
	}
}
