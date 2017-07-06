/**
 * @author Eduardo C. de S�
 *
 * 20/04/2016
 */
package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author eduardo.sa
 *
 */
public class PlatformAuthentication {

	@SuppressWarnings({ "resource" })
	public static String platUser(){
		String user = "";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(new File(System.getProperty("user.home")), ".bashrc")));
			for(String line = reader.readLine(); line != null; line = reader.readLine()){
				String regexUser = "PLAT_USER=\\s*([^\\n\\r]*)";
				Pattern patternUser = Pattern.compile(regexUser);
				Matcher matcherUser = patternUser.matcher(line);

				if (matcherUser.find()) {
					user = matcherUser.group(1);
					return user;
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return user;

	}

	public static String platPass(){
		String pass = "";

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(new File(System.getProperty("user.home")), ".bashrc")));


			for(String line = reader.readLine(); line != null; line = reader.readLine()){
				String regexPass = "PLAT_PASSWORD=\\s*([^\\n\\r]*)";
				Pattern patternPass = Pattern.compile(regexPass);
				Matcher matcherPass = patternPass.matcher(line);

				if (matcherPass.find()) {
					pass = matcherPass.group(1);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pass;

	}
}
