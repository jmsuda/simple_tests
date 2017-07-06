/**
 * @author Eduardo C. de Sa
 *
 * 01/06/2016
 */
package webFunctionalTests;

import java.io.File;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import pages.Chillibeans;
import tools.Rotas;
import tools.WebdriverWeb;

/**
 * @author eduardo.sa
 *
 */
public class FuncionalTesteNewsletter {

	@Test
	public void verificarChamadaNewsletter() throws MalformedURLException {
		
		Chillibeans cb = new Chillibeans();

//		System.out.println("----> Inicio dos testes: Verificacao se existe Vitrines.");
//		WebdriverWeb.carregarUrl("http://loja.chillibeans.com.br/");
//		cb.inserirEmailNewsletter(WebdriverWeb.obterInstancia(), "xxx@xxx.com");
//		cb.clicarBotaoNewsletter(WebdriverWeb.obterInstancia());
		
		try{
			
			File pathToBinary = new File("/home/eduardocorrea/Documents/chaordicWorkspaceAutomationTests/firefox/firefox-bin");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			BrowserMobProxy proxy = new BrowserMobProxyServer();
			proxy.start(0);
			Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
			WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile,capabilities);

//			proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
			proxy.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
			proxy.newHar("http://loja.chillibeans.com.br/");
			driver.get("http://loja.chillibeans.com.br/");
			
			cb.inserirEmailNewsletter(driver, "xxx@xxx.com");
			cb.clicarBotaoNewsletter(driver);
			
			Har har = proxy.getHar();

			FileOutputStream fos = new FileOutputStream("/home/eduardocorrea/Documents/chaordicWorkspace/integration-tools/SuiteAutomationTest/resource/log.har");
			har.writeTo(fos);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
}


