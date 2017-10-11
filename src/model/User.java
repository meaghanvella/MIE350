package model;
import java.util.Iterator;


public abstract class User {
	private String email; 
	private String name;
	private String digest;
	private String description;
	
	
	public void init(Iterator args){
		email = (String) args.next();
		name = (String) args.next();
		digest = DigestHash.encryptPwd(((String) args.next()));
		description = (String) args.next();
	}


	private void setDigest(String next) {
		// TODO Auto-generated method stub
		
	} 

	public String getEmail(){return this.email;}
	public String getName(){return this.name;}
	public String getDigest(){return this.digest;}
	public String getDesc(){return this.description;}

	
}