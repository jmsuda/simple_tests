package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.WebdriverWeb;

public class ComponentSelect {

	/**
	 * MÃ©todo para selecionar um item de uma lista
	 * 
	 * @param driver WebDriver
	 * @param id String contendo o ID do elemento que contem a lista.
	 * @param nomeItem String contendo o valor do item visÃ­vel na tela. ?? 
	 */
	
	public static void selectItemByVisibleText(WebDriver driver, String id, String nomeItem){
		try {
			WebDriverWait wait = new WebDriverWait(WebdriverWeb.obterInstancia(), 20);
			WebElement e = wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			new org.openqa.selenium.support.ui.Select(e).selectByVisibleText(nomeItem);			
		} catch (Exception e){
			System.err.println("Não foi possível inserir o valor no campo informado.\n"+e);
		}		
	}
	
	public static String getLastValueSelectItemByVisibleText(String id){	
		org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(WebdriverWeb.obterInstancia().findElement(By.id(id)));	
		WebElement option = dropdown.getFirstSelectedOption();
		return option.getText();
	}
}
