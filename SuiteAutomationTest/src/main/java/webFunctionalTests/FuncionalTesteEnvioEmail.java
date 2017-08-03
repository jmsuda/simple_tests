/**
 * @author Eduardo C. de Sa
 *
 * 20/04/2016
 */
package webFunctionalTests;

import java.net.MalformedURLException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import pages.RendererMax;
import tools.Rotas;
import tools.WebdriverWeb;

/**
 * @author eduardo.sa
 *
 */
public class FuncionalTesteEnvioEmail {

	@Test
	public void envioEmailRendererMax() throws MalformedURLException {

		RendererMax rm = new RendererMax();

		System.out.println("----> Inicio dos testes: Envio de email via Renderer MAX para Outlook, Gmail e Yahoo.");

		String longinRendererMax = "mail@chaordicsystems.com";
		String senhaRendererMax = "gK*P-#TqDUSXZsfK*-7J";
		String cliente = "xxDel";
		int quantProd = 1;
		ArrayList<String> listaEmailDestino = new ArrayList<String>();
		listaEmailDestino.add("teste_chaos@yahoo.com.br");
		listaEmailDestino.add("dsn@litmustest.com");
		listaEmailDestino.add("chaordic.teste.22@outlook.com");
		listaEmailDestino.add("teste@chaordicsystems.com");

		WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX);		
		rm.inserirEmailLogin(WebdriverWeb.obterInstancia(), longinRendererMax);
		rm.inserirSenhaLogin(WebdriverWeb.obterInstancia(), senhaRendererMax);
		rm.clicarEntrarRendererMax(WebdriverWeb.obterInstancia());

		for (String emailDestino : listaEmailDestino) {
			
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "abandoned_cart");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());
			
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_full_infected");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());
			
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_full_complementary");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());
			
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_anonymous");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());
			
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_infected");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_complementary");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "price_reduced_full");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "decided");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.selecionarUseDummyRecs(WebdriverWeb.obterInstancia());
			rm.clicarRender(WebdriverWeb.obterInstancia());
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "undecided_name_based");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia()); 

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "visit_reactivation");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());
						
			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "alternative");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia()); 

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "available_now");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia()); 

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "trending");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "new_products");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "new_purchases");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "reengagement");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.selecionarUseDummyRecs(WebdriverWeb.obterInstancia());
			rm.clicarRender(WebdriverWeb.obterInstancia());
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

			WebdriverWeb.carregarUrl(Rotas.URLRENDERERMAX+"/tools/renderer_max/");
			rm.selecionarCliente(WebdriverWeb.obterInstancia(), cliente );
			rm.selecionarCampanha(WebdriverWeb.obterInstancia(), "missing_you");
			rm.inserirIdProduto(WebdriverWeb.obterInstancia(), quantProd);
			rm.selecionarUseDummyRecs(WebdriverWeb.obterInstancia());
			rm.clicarRender(WebdriverWeb.obterInstancia());
			rm.capturarAssunto(WebdriverWeb.obterInstancia());
			rm.clicarBotaoSendEmail(WebdriverWeb.obterInstancia());
			rm.inserirEmailDestino(WebdriverWeb.obterInstancia(), emailDestino);
			rm.enviarEmail(WebdriverWeb.obterInstancia());
			rm.closeWindow(WebdriverWeb.obterInstancia());

		}
	}


}
