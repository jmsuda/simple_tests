package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentLoad {
	
	public static boolean visibilityOfElementLocatedBydId(WebDriver driver, String id){
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			resultado = true;
		} catch (Exception e) {
			resultado = false;		
		}
		return resultado;
	}
	
	public static boolean elementToBeClickableBydId(WebDriver driver, String id){
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			resultado = true;			
		} catch (Exception e) {
			resultado = false;		
		}
		return resultado;
	}

	public static boolean visibilityOfElementLocatedByXpath(WebDriver driver, String xpath){
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			resultado = true;			
		} catch (Exception e) {
			resultado = false;		
		}
		return resultado;
	}
	
	public static boolean visibilityOfElementLocatedByClassName(WebDriver driver, String className){
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
			resultado = true;			
		} catch (Exception e) {
			resultado = false;		
		}
		return resultado;
	}
	
	public static boolean invisibilityOfElementLocatedByClassName(WebDriver driver, String className){
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(className)));
			resultado = true;			
		} catch (Exception e) {
			resultado = false;		
		}
		return resultado;
	}
	
}
