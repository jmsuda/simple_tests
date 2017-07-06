/**
 * @author Eduardo C. de S�
 *
 * 07/07/2015
 */
package pages;

import org.openqa.selenium.WebDriver;

import components.ComponentButton;
import components.ComponentInput;
import components.ComponentLoad;

/**
 * @author eduardo.sa
 *
 */
public class Chillibeans {

	public Chillibeans() {
	}

	public boolean loadLoginPage(WebDriver driver, String id) {
		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
	}

	public void inserirEmailNewsletter(WebDriver driver, String email) {
		ComponentInput.setText(driver, "newsletterClientEmail", email);
	}

	public void clicarBotaoNewsletter(WebDriver driver) {
		ComponentButton.oneClickById(driver, "newsletterButtonOK");
	}

}
