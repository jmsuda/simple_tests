package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.WebdriverWeb;

public class ComponentInput {

	public static void setText(WebDriver driver, String id, String valor){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).sendKeys(valor);
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o valor no campo informado.\n"+e);
		}
	}
	
	public static void setTextByCssSelector(WebDriver driver, String selector, String valor){
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector))).sendKeys(valor);
		} catch (Exception e) {
			System.err.println("Nao foi possivel inserir o valor no campo informado.\n"+e);
		}
	}
	
	public static String getText(WebDriver driver, String id){
		String resultado;
		try {
			WebDriverWait wait = new WebDriverWait(driver,20);
			resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id))).getText();			
		} catch (Exception e) {
			System.err.println("Nao foi possivel capturar o valor no campo informado.\n"+e);
			resultado = null;
		}
		return resultado;
	}
	
	public static void editTextInput(WebDriver driver, String id, String valor){
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			WebdriverWeb.obterInstancia().findElement(By.xpath("//input[contains(@id,'"+id+"')]")).clear();
			WebdriverWeb.obterInstancia().findElement(By.xpath("//input[contains(@id,'"+id+"')]")).sendKeys(valor);
		} catch (Exception e) {
			System.err.println("N�o foi poss�vel inserir o valor no campo informado.\n"+e);
		}
	}
	
	public static void editTextArea(WebDriver driver, String id, String valor){
		try {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			WebdriverWeb.obterInstancia().findElement(By.xpath("//textarea[contains(@id,'"+id+"')]")).clear();
			WebdriverWeb.obterInstancia().findElement(By.xpath("//textarea[contains(@id,'"+id+"')]")).sendKeys(valor);
		} catch (Exception e) {
			System.err.println("N�o foi poss�vel inserir o valor no campo informado.\n"+e);
		}
	}
	
}