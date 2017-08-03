// /**
//  * @author Eduardo C. de Sa
//  *
//  * 13/08/2015
//  */
// package tools;

// import java.net.MalformedURLException;

// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Optional;
// import org.testng.annotations.Parameters;

// /**
//  * @author eduardo.sa
//  *
//  */
// public class CriarAmbienteMobile {

// 	@Parameters({ "so", "navegador", "versao" })
// 	@BeforeTest
// 	public void iniciarInstancia(String so, @Optional String navegador,@Optional String versao) throws MalformedURLException {
// 		System.out.println("----> Inicio dos testes Mobile: "+ System.currentTimeMillis());
// 		System.out.println("----> Instanciando o Driver");
// 		System.out.println("----> Plataforma: " + so);
// 		System.out.println("----> Navegador: " + navegador);
// 		System.out.println("----> Versao: " + versao);
// 		WebdriverMobile.criarInstanciaMobile();
// 	}

// 	//	@AfterTest
// 	public void finalizar(@Optional String version) {
// 		System.out.println("----> Finalizando o Driver: " + version);
// 		WebdriverWeb.fecharInstancia();
// 		System.out.println("----> Fim dos testes: " + System.currentTimeMillis());
// 	}
// }
