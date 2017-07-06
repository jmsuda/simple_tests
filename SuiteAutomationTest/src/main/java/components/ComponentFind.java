package components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.WebdriverWeb;

public class ComponentFind {

	public static String findTextByTagName(WebDriver driver, String tagName){
		String text = null;
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
			text = driver.findElement(By.tagName(tagName)).getText();			
		} catch (Exception e) {
			System.err.println("Nao foi possivel pegar o valor no campo informado.\n"+e);
		}
		return text;
	}

	public static List<String> findListTextByClassName(WebDriver driver, String className){
		String text = null;
		List<String> list = new ArrayList<String>();
		try {

			WebDriverWait wait = new WebDriverWait(WebdriverWeb.obterInstancia(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
			List<WebElement> listaText = null;
			listaText = WebdriverWeb.obterInstancia().findElements(By.className(className));
			//		System.out.println("TamanhoLista: " + listaText.size());
			for (WebElement webElement : listaText) {
				//				text = text + webElement.getText();
				text = webElement.getAttribute("term");
				list.add(text);
			}
			//			System.out.println("Text: " + list);
		} catch (Exception e) {
			System.err.println("Nao foi possivel pegar os valores no campo informado.\n"+e);
		}
		return list;
	}

}
