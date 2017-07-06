package pages;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import components.ComponentLoad;
import tools.Disparador;

public class Vitrines {

	public boolean loadLoginPage(WebDriver driver, String id) {
		//		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
		return ComponentLoad.visibilityOfElementLocatedByXpath(driver, id);
	}

	public void verificarLinks(WebDriver driver) throws ClientProtocolException, IOException {

		Disparador di =  new Disparador();
		List<WebElement> list=driver.findElements(By.xpath("//*[@href or @src]"));
		for(WebElement e : list){
			String link = e.getAttribute("href");
			if(null==link){
				link=e.getAttribute("src");
			}
			//			System.out.println(e.getTagName() + "=" + link);
			System.out.println("----------------");
			System.out.println(link);
			di.getHealthCheck(link);
			System.out.println("----------------");
		}
		
		try {			
			ComponentLoad.invisibilityOfElementLocatedByClassName(driver, "vitrine-reestruturacao");
			WebElement chaordic= driver.findElement(By.className("vitrine-reestruturacao"));
			List<WebElement> listIframe= chaordic.findElements(By.cssSelector("iframe"));
			for(WebElement e : listIframe){
				driver.switchTo().frame(e);			        
				WebElement isPresent = driver.findElement(By.id("widget"));
				if(isPresent!= null){
					verificarLinksIntern(driver);
				}
				driver.switchTo().defaultContent();
			}
		}catch(Exception e){

		}

	}
	
	private void verificarLinksIntern(WebDriver driver) throws ClientProtocolException, IOException {

		Disparador di =  new Disparador();
		List<WebElement> list=driver.findElements(By.xpath("//*[@href or @src]"));
		for(WebElement e : list){
			String link = e.getAttribute("href");
			if(null==link){
				link=e.getAttribute("src");
			}
			//			System.out.println(e.getTagName() + "=" + link);
			System.out.println("----------------");
			System.out.println(link);
			di.getHealthCheck(link);
			System.out.println("----------------");
		}
	}

	public void verificarPresencaVitrines(WebDriver driver)  {
		try {			
			ComponentLoad.invisibilityOfElementLocatedByClassName(driver, "vitrine-reestruturacao");
			WebElement chaordic= driver.findElement(By.className("vitrine-reestruturacao"));
			List<WebElement> list= chaordic.findElements(By.cssSelector("iframe"));
			for(WebElement e : list){
				driver.switchTo().frame(e);			        
				WebElement isPresent = driver.findElement(By.id("widget"));
				if(isPresent!= null){
					System.out.println("Vitrine: "+isPresent.getAttribute("className"));
				}else{
					System.out.println("Element is Absent");
				}
				driver.switchTo().defaultContent();
			}
		}catch(Exception e){

		}

	}
}
