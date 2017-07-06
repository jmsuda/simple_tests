/**
 * @author Eduardo C. de S�
 *
 * 07/07/2015
 */
package webFunctionalParallelTests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Busca;
import tools.Disparador;
import tools.Rotas;
import tools.Util;
import tools.WebdriverWeb;

/**
 * @author eduardo.sa
 *
 */
public class FuncionalTesteBusca {

	@Test
	public void carregouAplicacao() throws ClientProtocolException, IOException {
		Busca b = new Busca();
		Disparador disp = new Disparador();
		Assert.assertEquals(200, disp.getHealthCheck(Rotas.URLBUSCA));
		Assert.assertTrue(b.loadLoginPage(WebdriverWeb.obterInstancia(), "/html/body/header/div[1]/div/div[3]/div[1]/form/input"));
		Util.gerarEvidenciaTeste();		
	}

//	@Test(dependsOnMethods = { "carregouAplicacao" }, invocationCount = 100, threadPoolSize = 1)
	@Test(invocationCount = 100, threadPoolSize = 1)
	public void paginaBusca() {

		System.out.println("----> Início dos testes paralelos: Buscar pelo mesmo termo N vezes, para subir no ranking de mais pesquisados.");

		Busca b = new Busca();
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		b.inserirTextoBusca(WebdriverWeb.obterInstancia(), "infantil");
		b.clicarBuscar(WebdriverWeb.obterInstancia());
		Assert.assertTrue(b.loadLoginPageProdutos(WebdriverWeb.obterInstancia(), "wrapper"));
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);

	}
}
