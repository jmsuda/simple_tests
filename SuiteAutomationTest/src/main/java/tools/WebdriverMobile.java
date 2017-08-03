/**
 * @author Eduardo C. de Sa
 *
 * 13/08/2015
 */
package tools;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author eduardo.sa
 *
 */
public class WebdriverMobile {

	@SuppressWarnings("rawtypes")
	private static AndroidDriver driver;

	@SuppressWarnings("rawtypes")
	public static void criarInstanciaMobile() throws MalformedURLException {

		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		//	capacidade.setCapability("browserName", MobileBrowserType.BROWSER);
		capacidade.setCapability("browserName", MobileBrowserType.CHROME);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);

	}
	@SuppressWarnings("rawtypes")
	public static AndroidDriver obterInstancia() {
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

}
