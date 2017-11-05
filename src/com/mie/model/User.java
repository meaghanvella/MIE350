package com.mie.model;

public class User {
	public String email;
	public String password;
	public boolean isValid;
	public String type;
	
	public String getEmail(){return email;}
	public String getPassword(){return password;}
	public boolean isValid(){return isValid;}
	public String getType(){return type;}
	
	public void setEmail(String e){email=e;}
	public void setPassword(String p){password=p;}
	public void setValid(boolean v){isValid=v;}
	public void setType(String t){type=t;}
	
}
