package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.ComponentFind;
import components.ComponentInput;
import components.ComponentLoad;

public class Busca {

	public boolean loadLoginPage(WebDriver driver, String id) {
		//		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
		return ComponentLoad.visibilityOfElementLocatedByXpath(driver, id);
	}

	public boolean loadLoginPageProdutos(WebDriver driver, String id) {
		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
	}

	public void inserirTextoBusca(WebDriver driver, String valor) {
		ComponentInput.setText(driver, "neemu-search", valor);
		//		WebDriverWait wait = new WebDriverWait(driver,20);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div/div[3]/div[1]/form/input"))).sendKeys(valor);
	}

	public void limparTextoBusca(WebDriver driver) {
		//			ComponentInput.setText(driver, "username", emailProtocolo);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div/div[3]/div[1]/form/input"))).clear();
	}

	public void clicarBuscar(WebDriver driver) {
		//		ComponentButton.oneClickById(driver, " ");
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[1]/div/div[3]/div[1]/form/button"))).click();
	}

	public String findJSONTopSearchNeemu(WebDriver driver) {
		return ComponentFind.findTextByTagName(driver, "pre");	 
	}

	public List<String> findSugestaoBuscaNeemu(WebDriver driver) {
		return ComponentFind.findListTextByClassName(driver, "ac-suggest-term");	 
	}

	public boolean verificarRelacaoEntrePesquisadoSugestao(List<String> list, String termoPesquisado) {
		boolean verificar = false; 
		for (String x : list) {
			if(x.indexOf(termoPesquisado) != -1){
				System.out.println ("---------------------------------------");
				System.out.println ("Relacao Ok: ["+termoPesquisado+"] com ["+x+"]");
			}else{
				System.out.println ("---------------------------------------");
				System.out.println ("Verificar relacao: ["+termoPesquisado+"] com ["+x+"]");
				verificar = true;
			}
		}
		return verificar;
	}

	public boolean loadSugestaoBusca(WebDriver driver) {
		return ComponentLoad.visibilityOfElementLocatedByClassName(driver, "ac-terms-container");
	}

	public boolean loadInvisibilitySugestaoBusca(WebDriver driver) {
		return ComponentLoad.visibilityOfElementLocatedByClassName(driver, "ac-terms-container");
	}

	public boolean loadInvisibilityTopSearchNeemu(WebDriver driver) {
		return ComponentLoad.invisibilityOfElementLocatedByClassName(driver, "ac-container");
	}

	public boolean loadTopSearchNeemu(WebDriver driver) {
		return ComponentLoad.visibilityOfElementLocatedByClassName(driver, "ac-container");
	}


}
