/**
 * @author Eduardo C. de S�
 *
 * 09/10/2015
 */
package tools;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * @author eduardo.sa
 *
 */
public class Util {

	public static final String NAMEDB= "";
	public static final String PLATUSER= PlatformAuthentication.platUser();
	public static final String PLATPASS= PlatformAuthentication.platPass();



	public static final void gerarEvidenciaTeste() {
		String nomeMetodo = Thread.currentThread().getStackTrace()[2].getMethodName();
		String nomeArquivo = nomeMetodo + "-" + System.currentTimeMillis()+ ".png";
		try {
			File screenshot = ((TakesScreenshot) WebdriverWeb.obterInstancia()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("test-output/evidencias/"+ nomeArquivo));
		} catch (Exception e) {
			System.err.println("Falha ao capturar evidencia \n" + e);
		}
	}
}
