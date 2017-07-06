package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComponentButton {
	
	public static void oneClickById(WebDriver driver,String id){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).click();
		} catch (Exception e) {
			System.err.println("Nao foi possivel clicar no campo informado.\n"+e);
		}
	}	
	
	public static void oneClickByCssSelector(WebDriver driver,String selector){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector))).click();
		} catch (Exception e) {
			System.err.println("Nao foi possivel clicar no campo informado.\n"+e);
		}
	}
	
	public static void oneClickByClass(WebDriver driver,String selector){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(selector))).click();
		} catch (Exception e) {
			System.err.println("Nao foi possivel clicar no campo informado.\n"+e);
		}
	}
		
		public static void oneClickByXpath(WebDriver driver,String selector){
			try {
				WebDriverWait wait = new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector))).click();
			} catch (Exception e) {
				System.err.println("Nao foi possivel clicar no campo informado.\n"+e);
			}
		}
	
}
