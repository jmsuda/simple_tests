package tools;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CriarAmbienteWeb {

	@Parameters({ "so", "navegador", "versao" })
	@BeforeTest
	public void iniciarInstancia(String so, @Optional String navegador,@Optional String versao) throws MalformedURLException {
		System.out.println("----> Inicio dos testes Web: "+ System.currentTimeMillis());
		System.out.println("----> Instanciando o Driver");
		System.out.println("----> Plataforma: " + so);
		System.out.println("----> Navegador: " + navegador);
		System.out.println("----> Versao: " + versao);
		WebdriverWeb.criarInstanciaWeb(so, navegador, versao);
	}

	@Parameters({ "version" })
	@AfterTest
	public void finalizar(@Optional String version) {
		System.out.println("----> Finalizando o Driver.");
		WebdriverWeb.fecharInstancia();
		System.out.println("----> Fim dos testes: " + System.currentTimeMillis());
	}

}
