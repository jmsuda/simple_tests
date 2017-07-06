/**
 * @author Eduardo C. de Sa
 *
 * 09/10/2015
 */
package tools;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;


/**
 * @author eduardo.sa
 *
 */
public class WebdriverWeb {

	private static WebDriver driver;

	public static WebDriver obterInstancia() {
		if (driver == null) {
			System.out.println("-->> Driver == null");
		}
		return driver;
	}

	public static void fecharInstancia() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static void carregarUrl(String url) {
		driver.get(url);
	}

	public static void criarInstanciaWeb(String plataforma, @Optional String browser, @Optional String versao)
			throws MalformedURLException {	
		if (plataforma.equalsIgnoreCase("local")) {					
			File file = new File("driver/chromedriver");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
			
		} else {
			DesiredCapabilities caps = null;
			switch (browser) {
			case "ie":
				caps = DesiredCapabilities.internetExplorer();
				break;
			case "firefox":
				caps = DesiredCapabilities.firefox();
				break;
			case "chrome":
				caps = DesiredCapabilities.chrome();
				break;
			case "safari":
				caps = DesiredCapabilities.safari();
				break;
			}
			caps.setCapability("platform", plataforma);
			caps.setCapability("version", versao);
			System.out.println("-->>> IP Selenium Server: "+ Rotas.IP_SELENIUM_SERVER);
			driver = new RemoteWebDriver(new URL("http://"+ Rotas.IP_SELENIUM_SERVER + ":PORTA/wd/hub"), caps);
		}
		driver.get(Rotas.URL);
		driver.manage().window().maximize();
	}

}

