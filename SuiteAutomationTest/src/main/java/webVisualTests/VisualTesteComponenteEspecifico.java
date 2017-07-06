/**
 * @author Eduardo C. de S�
 *
 * 08/09/2015
 */
package webVisualTests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import tools.Disparador;
import tools.Rotas;
import tools.Util;
import tools.Visual;
import tools.WebdriverWeb;

/**
 * @author eduardo.sa
 *
 */
public class VisualTesteComponenteEspecifico {
	
	@Test
	public void carregouAplicacao() throws ClientProtocolException, IOException {
		Home hm = new Home();
		Disparador disp = new Disparador();
		Assert.assertEquals(200, disp.getHealthCheck(Rotas.URLBUSCA));
//		Assert.assertTrue(hm.loadLoginPage(WebdriverWeb.obterInstancia(), "username"));
				
	}

//	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaComponentEspecifico() {

		System.out.println("----> Visual Testes: Tela Home - Teste de componente especifico.");
		
		String path = Rotas.PATHIMAGENSWEB+"compararTelaXviewer";
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		String current = Visual.capturarElementoEspecifico(WebdriverWeb.obterInstancia(), path, "username");
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
	}
	
	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaComponentEspecificoXViewerSucesso() {

		System.out.println("----> Visual Testes: Tela Home - Teste de Imagem - Sucesso.");
		
		String path = Rotas.PATHIMAGENSWEB+"compararTelaXviewer";
//		WebdriverWeb.carregarUrl("http://ec2-54-94-17-14.sa-east-1.compute.amazonaws.com:8888/xviewer/study/open/1207027?h=479546203f3f4face16af645f492454ecfe6894b");
		String current = Visual.capturarElementoEspecifico(WebdriverWeb.obterInstancia(), path, "main");
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
	}
	
	
	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaComponentEspecificoXViewerFalha() {

		System.out.println("----> Visual Testes: Tela Home - Teste de Imagem - Falha.");
		WebDriverWait wait = new WebDriverWait(WebdriverWeb.obterInstancia(),20);
		
		String path = Rotas.PATHIMAGENSWEB+"compararTelaXviewerPaletaCores";
//		WebdriverWeb.carregarUrl("http://ec2-54-94-17-14.sa-east-1.compute.amazonaws.com:8888/xviewer/study/open/1207027?h=479546203f3f4face16af645f492454ecfe6894b");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/nav[1]/div[2]/div[1]/div/div/div[3]/div/ul/li[2]"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toolbar_palette"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[4]/div/div[1]/img"))).click();
		String current = Visual.capturarElementoEspecifico(WebdriverWeb.obterInstancia(), path, "main");
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
	}
	
}


