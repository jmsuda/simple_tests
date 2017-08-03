package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ComponentCheckbox {

	public static void setCheckbox(WebDriver driver, String id){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
//			WebElement e = (WebElementwait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
			driver.findElement(By.id(id)).click();
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o valor no campo informado.\n"+e);
		}		
	}
	
}
