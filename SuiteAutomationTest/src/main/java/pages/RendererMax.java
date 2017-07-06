package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import components.ComponentButton;
import components.ComponentCheckbox;
import components.ComponentFind;
import components.ComponentInput;
import components.ComponentLoad;

public class RendererMax {

	public boolean loadLoginPage(WebDriver driver, String id) {
		//		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
		return ComponentLoad.visibilityOfElementLocatedByXpath(driver, id);
	}

	public boolean loadLoginPageProdutos(WebDriver driver, String id) {
		return ComponentLoad.visibilityOfElementLocatedBydId(driver, id);
	}

	public void inserirEmailLogin(WebDriver driver, String valor) {
		ComponentInput.setTextByCssSelector(driver, "input[name=email]", valor);			
	}

	public void inserirSenhaLogin(WebDriver driver, String valor) {
		ComponentInput.setTextByCssSelector(driver, "input[name=password]", valor);
	}
	
	public void capturarAssunto(WebDriver driver) {
		String assunto = ComponentInput.getText(driver, "theSubject");
		System.out.println("Assunto: "+assunto);
	}

	public void inserirEmailDestino(WebDriver driver, String valor) {
		loadRender(driver);
		ComponentInput.editTextInput(driver, "sendMailTo", valor);
		System.out.println("E-mail destino: "+valor);
	}

	public void loadRender(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layover")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail_body")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("layover")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mail_body")));
	}

	public void loadListProducts(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1")));
	}

	public void selecionarCliente(WebDriver driver, String valor) {
		loadRender(driver);
		ComponentButton.oneClickById(driver, "client_chosen");
		ComponentInput.setTextByCssSelector(driver, "div.chosen-search input", valor);
		ComponentButton.oneClickByCssSelector(driver, "ul.chosen-results");
	}

	public void selecionarCampanha(WebDriver driver, String valor) {
		loadRender(driver);
		WebElement campanha = driver.findElement(By.id("type_chosen"));
		campanha.click();
		//		campanha.findElement(By.id("type_chosen")).click(); - Selenium 3 implementa de outra forma
		campanha.findElement(By.cssSelector("div.chosen-search input")).sendKeys(valor);
		campanha.findElement(By.cssSelector("div.chosen-search input")).sendKeys(Keys.ENTER);
		System.out.println("Campanha: "+valor);
	}

	public void inserirIdProduto(WebDriver driver, int numberProducts) {
		loadRender(driver);
		for(int produtosAdd=1;numberProducts>=produtosAdd; produtosAdd++){
			driver.findElement(By.id("array_products-tokenfield")).sendKeys("1");
			loadListProducts(driver);
			WebElement element = driver.findElement(By.id("ui-id-1"));
			List<WebElement> listProduct =  element.findElements(By.xpath("li"));
			System.out.println(listProduct.get(listProduct.size() - produtosAdd).getText().toString());
			listProduct.get(listProduct.size() - produtosAdd).click();
		}
		clicarRender(driver);
	}



	public void selecionarUseDummyRecs(WebDriver driver) {
		loadRender(driver);			
		ComponentCheckbox.setCheckbox(driver, "use_dummy_recs");
		loadRender(driver);
	}

	public void clicarRender(WebDriver driver) {
		loadRender(driver);
		
//		driver = driver.findElement(By.className("btn-group"));
		ComponentButton.oneClickByCssSelector(driver, "button.btn.btn-primary");
	}

	public void clicarFerramentasRendererMax(WebDriver driver) {
		ComponentButton.oneClickByCssSelector(driver, "li.tools.dropdown");		
	}

	public void clicarEntrarRendererMax(WebDriver driver) {
		ComponentButton.oneClickByCssSelector(driver, "button[type=submit]");
		ComponentLoad.visibilityOfElementLocatedBydId(driver, "content");
	}

	public void clicarBotaoSendEmail(WebDriver driver) {
		loadRender(driver);
		ComponentButton.oneClickByCssSelector(driver, "a.send-mail-btn.btn.pull-left");
	}

	public void enviarEmail(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sendEmailModal")));
		WebElement enviar = driver.findElement(By.id("sendEmailModal"));
		enviar.findElement(By.cssSelector("button.btn.btn-primary")).click();
	}


	public void closeWindow(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);	
		}
		WebElement text = driver.findElement(By.cssSelector("html body"));
		System.out.println(text.getText());
		System.out.println("-------------------");

		if(driver.getWindowHandles().size()>1){
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}

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
