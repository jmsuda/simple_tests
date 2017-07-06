package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentValidate {
	
	public static boolean elementIsPresentById(WebDriver driver, String id){
		boolean resultado = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			resultado = true;			
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o valor no campo informado.\n"+e);
		}
		return resultado;
	}

}
