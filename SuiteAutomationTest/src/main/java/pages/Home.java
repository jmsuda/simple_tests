/**
 * @author Eduardo C. de Sá
 *
 * 07/07/2015
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.ComponentButton;
import components.ComponentInput;
import components.ComponentLoad;

/**
 * @author eduardo.sa
 *
 */
public class Home {

	public Home() {
	}

	public boolean loadLoginPage(WebDriver driver, String id) {
		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
	}

	public void clicarEntrar(WebDriver driver) {
//		ComponentButton.oneClickById(driver, " ");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[3]/div/form/div[6]/div/button"))).click();
	}

	public void inserirProtocolo(WebDriver driver, String emailProtocolo) {
		ComponentInput.setText(driver, "username", emailProtocolo);
	}
	
	public void inserirSenha(WebDriver driver, String senha) {
		ComponentInput.setText(driver, "password2", senha);		
	}

	public void clicarBotaoLogin(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
	
	public void clicarBotaoVantagens(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
	
	public void clicarBotaoContato(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
	
	public void clicarBotaoAdmin(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
	public void clicarBotaoCadastreSe(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
	
	public void clicarBotaoEsqueciMinhaSenha(WebDriver driver) {
		ComponentButton.oneClickById(driver, " ");
	}
}
