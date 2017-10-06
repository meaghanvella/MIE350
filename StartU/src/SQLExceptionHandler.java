import java.sql.SQLException;
//Copied from CMS

/*
 * 
 * @author wluo
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/*
 * A class to handle some possible exceptions of executing SQL's.
 */
public class SQLExceptionHandler {
	
	/*
	 * Print out each detailed meaningful error message according to SQL state code. 
	 * Note: 
	 * 1. When called, "static" methods can be called by the class name, instead of instance name
	 */
	public static void handleException(SQLException se){
		se.printStackTrace();

		String SQLState = se.getSQLState();
		String stateMessage = "";
		if( SQLState.equals( "23502" )){
			stateMessage = "An insert or update value is null, but the column cannot contain null values.";
		}
		else if ( SQLState.equals( "23503" ) ){ 
			stateMessage = "The insert or update value of a foreign key is invalid."; 
		}
		else if ( SQLState.equals( "23505" ) ){ 
			stateMessage = "A violation of the constraint imposed by a unique index or a unique constraint occurred."; 
		}
		else if ( SQLState.equals( "22003" ) ) {
		    stateMessage = "A numeric value is out of range.";  
		}
		else if ( SQLState.equals( "08001" ) ) {
		    stateMessage = "The application requester is unable to establish the connection.";  
		}
		
		else if ( SQLState.equals( "08002" ) ) {
		    stateMessage = "The connection already exists.";  
		}
		else if ( SQLState.equals( "S1000" )) {
			stateMessage = "There is a key violation";
		}
		else if ( SQLState.equals( "08003" ) ) {
		    stateMessage = "The connection does not exist.";  
		}else{
			stateMessage = "Need more investigation to SQL state.";
		}
		System.out.println("SQLException: " + se.getMessage());
		System.out.println("VendorError: " + se.getErrorCode());
		System.out.println("SQLState: " + se.getSQLState());
		System.out.println(stateMessage);
	}

}
