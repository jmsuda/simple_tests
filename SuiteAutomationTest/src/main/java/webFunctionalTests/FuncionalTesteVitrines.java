/**
 * @author Eduardo C. de Sa
 *
 * 07/07/2015
 */
package webFunctionalTests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Busca;
import pages.Vitrines;
import tools.Disparador;
import tools.Rotas;
import tools.Util;
import tools.WebdriverWeb;

/**
 * @author eduardo.sa
 *
 */
public class FuncionalTesteVitrines {

	@Test
	public void carregouAplicacao() throws ClientProtocolException, IOException {
		Busca b = new Busca();
		Disparador disp = new Disparador();
		Assert.assertEquals(200, disp.getHealthCheck(Rotas.URLVITRINES));
		Assert.assertTrue(b.loadLoginPage(WebdriverWeb.obterInstancia(), "xx"));
		Util.gerarEvidenciaTeste();		
	}

	//	@Test(dependsOnMethods = { "carregouAplicacao" })
	@Test
	public void verficarVitrines() throws ClientProtocolException, IOException {

		Vitrines v = new Vitrines();

		System.out.println("----> Inicio dos testes: Verificacao se existe Vitrines.");
		WebdriverWeb.carregarUrl(Rotas.URLVITRINES);		
		v.verificarPresencaVitrines(WebdriverWeb.obterInstancia());

	}

	//	@Test(dependsOnMethods = { "carregouAplicacao" })
	@Test
	public void verficarAcessoLinks() throws ClientProtocolException, IOException {
		Vitrines v = new Vitrines();
		System.out.println("----> Inicio dos testes: Verificacao de acesso aos links disponiveis na pagina.");
		WebdriverWeb.carregarUrl(Rotas.URLVITRINES);		
		v.verificarLinks(WebdriverWeb.obterInstancia());
	}
}