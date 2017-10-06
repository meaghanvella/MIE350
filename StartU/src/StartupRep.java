import java.util.Iterator;


public class StartupRep extends User{
	private String position;
	private String companyName;
	private String companyWebsite;
	
	@Override
	public void init(Iterator args){} 
	public boolean update(StartupRep s){return false;}
	public boolean readNewStartupRepLoginfo(Iterator args){return false;};

}
