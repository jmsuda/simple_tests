/**
 * @author Eduardo C. de S�
 *
 * 01/06/2016
 */
package webFunctionalTests;

import java.io.FileOutputStream;
import java.net.MalformedURLException;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * @author eduardo.sa
 *
 */
public class TrafficNetwork {

	@Test
	public void loginHome() throws MalformedURLException {

		try{

			BrowserMobProxy proxy = new BrowserMobProxyServer();
			proxy.start(0);
			Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
			WebDriver driver = new FirefoxDriver(capabilities);

//			proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
			proxy.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
			proxy.newHar("URL APLICAÇÃO");
			driver.get("URL APLICAÇÃO");
			Har har = proxy.getHar();

			FileOutputStream fos = new FileOutputStream("/SuiteAutomationTests/log.har");
			har.writeTo(fos);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}


