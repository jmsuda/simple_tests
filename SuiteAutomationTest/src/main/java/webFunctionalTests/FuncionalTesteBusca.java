/**
 * @author Eduardo C. de Sa
 *
 * 07/07/2015
 */
package webFunctionalTests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Busca;
import tools.Disparador;
import tools.GeradorNumeros;
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

	//	@Test(dependsOnMethods = { "carregouAplicacao" })
	@Test
	public void verificarNeemuTopSearch() throws MalformedURLException {

		Busca b = new Busca();

		System.out.println("----> Inicio dos testes: Verificacao se existe JSON diferente de null ou vazio no Top Search Neemu.");

		WebdriverWeb.carregarUrl(Rotas.URLBUSCA+Rotas.URLTOPSEARCHNEEMU);		
		String text = b.findJSONTopSearchNeemu(WebdriverWeb.obterInstancia());
		Assert.assertNotNull(text);
		Assert.assertNotEquals(text, "");	
		System.out.println("JSON do Top Search: "+text);

	}

	//	@Test(dependsOnMethods = { "carregouAplicacao" })
	@Test
	public void verificarSegestaoBusca() throws MalformedURLException {

		Busca b = new Busca();

		System.out.println("----> Inicio dos testes: Verificacao das sugestões de Busca Neemu se possuem relacao.");

		String termoPesquisado = "infantil";

		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		b.inserirTextoBusca(WebdriverWeb.obterInstancia(), termoPesquisado);
		List<String> list = b.findSugestaoBuscaNeemu(WebdriverWeb.obterInstancia());
		Assert.assertFalse(b.verificarRelacaoEntrePesquisadoSugestao(list, termoPesquisado));

	}

	//	@Test(dependsOnMethods = { "carregouAplicacao" }, invocationCount = 100, threadPoolSize = 1)
	@Test(invocationCount = 5, threadPoolSize = 1)
	public void verificarSegestaoBuscaRandom() throws MalformedURLException, InterruptedException {

		Busca b = new Busca();
		GeradorNumeros gn = new GeradorNumeros();
		System.out.println("----> Inicio dos testes: Verificacao das sugestões de Busca Neemu se possuem relacao, utilizando gerador de String.");
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);
		//			String termoPesquisado = gn.gerarStringRandom(3);
		String termoPesquisado = gn.gerarNumeroRandom(3);
		b.inserirTextoBusca(WebdriverWeb.obterInstancia(), termoPesquisado);
		if(b.loadSugestaoBusca(WebdriverWeb.obterInstancia())==true){
			List<String> list = b.findSugestaoBuscaNeemu(WebdriverWeb.obterInstancia());
			Assert.assertFalse(b.verificarRelacaoEntrePesquisadoSugestao(list, termoPesquisado));
		}else{
			System.out.println("Nao retornou sugestões de busca.");
		}
		WebdriverWeb.carregarUrl(Rotas.URLBUSCA);	
	}

}
