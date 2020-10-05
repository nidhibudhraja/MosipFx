package application;

public class User {
	String fname;
	String lname;
	String pfname;
	String plname;
	int age;
	public User() {
		
	}
	public User(String fname, String lname, String pfname, String plname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.pfname = pfname;
		this.plname = plname;
		this.age = age;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPfname() {
		return pfname;
	}
	public void setPfname(String pfname) {
		this.pfname = pfname;
	}
	public String getPlname() {
		return plname;
	}
	public void setPlname(String plname) {
		this.plname = plname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
