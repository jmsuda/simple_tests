/**
 * @author Eduardo C. de S�
 *
 * 06/08/2015
 */
package mobileFunctionalTests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;


/**
 * @author eduardo.sa
 *
 */
public class TesteAbrindoApp {

	@Test
	public void testeTriangulo() throws MalformedURLException {
		
		File diretorioAplicacao = new File ("C:/app/triangulo");
		File arquivoAplicacao = new File (diretorioAplicacao, "TrianguloApp.apk");
		
		DesiredCapabilities capacidade = new DesiredCapabilities();
		capacidade.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capacidade.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		capacidade.setCapability(MobileCapabilityType.APP, arquivoAplicacao.getAbsolutePath());
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capacidade);
		
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txt_lado1")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txt_lado2")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txt_lado3")).sendKeys("3");
		driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/btn_Calcular")).click();
		AssertJUnit.assertEquals("O tringulo e Equilatero",driver.findElement(By.id("com.eliasnogueira.trianguloapp:id/txt_triangulo")).getText());
		
	}

}
