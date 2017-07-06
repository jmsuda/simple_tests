/**
 * @author Eduardo C. de S�
 *
 * 08/09/2015
 */
package webVisualTests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.Dimension;
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
public class VisualTesteHome {
	
	@Test
	public void carregouAplicacao() throws ClientProtocolException, IOException {
		Home hm = new Home();
		Disparador disp = new Disparador();
		Assert.assertEquals(200, disp.getHealthCheck(Rotas.URLBUSCA));
		Assert.assertTrue(hm.loadLoginPage(WebdriverWeb.obterInstancia(), "username"));
		Util.gerarEvidenciaTeste();		
	}

	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaHome() {

		System.out.println("----> Visual Testes: Tela Home - Tela Home.");
		
		String path = Rotas.PATHIMAGENSWEB+"compararTelaHome";
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		String current = Visual.capturarTela(WebdriverWeb.obterInstancia(), path);
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
	}
	
	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaHome800x600() {

		System.out.println("----> Visual Testes: Tela Home - Tela Home Resolu��o 800x600.");
		
		Dimension d = new Dimension(800,600);
		WebdriverWeb.obterInstancia().manage().window().setSize(d);
		String path = Rotas.PATHIMAGENSWEB+"compararTelaHome800x600";
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		String current = Visual.capturarTela(WebdriverWeb.obterInstancia(), path);
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
		WebdriverWeb.obterInstancia().manage().window().maximize();
	}
	
	@Test(groups = { "compararTelaHome" }, dependsOnMethods = { "carregouAplicacao" })
	public void compararTelaHome1024x768() {

		System.out.println("----> Visual Testes: Tela Home - Tela Home Resolu��o 1024x768.");
		
		Dimension d = new Dimension(1024,768);
		WebdriverWeb.obterInstancia().manage().window().setSize(d);
		String path = Rotas.PATHIMAGENSWEB+"compararTelaHome1024x768";
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		String current = Visual.capturarTela(WebdriverWeb.obterInstancia(), path);
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+"/logout");
		WebdriverWeb.obterInstancia().manage().window().maximize();
	}
	
}


