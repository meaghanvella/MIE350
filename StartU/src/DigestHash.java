import java.util.HashMap;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class DigestHash {
	//getters and setters
	public static String encryptPwd(String pwd) {
		//copied from jasypt 
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		String encryptedPassword = passwordEncryptor.encryptPassword(pwd);
		return encryptedPassword;
	}

}
