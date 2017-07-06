// /**
//  * @author Eduardo C. de Sá
//  *
//  * 16/07/2015
//  */
// package tools;

// /**
//  * @author eduardo.sa
//  *
//  */
// public class CapturarFoco {

// 	public String capturarFocoTela(){
// 		String telaPrincipal = WebdriverWeb.obterInstancia().getWindowHandle();
// 		return telaPrincipal;
// 	}

// 	public void focoTelaPincipal(String telaPrincipal, String novaTela){
// 		WebdriverWeb.obterInstancia().switchTo().window(novaTela );  
// 		WebdriverWeb.obterInstancia().close();
// 		WebdriverWeb.obterInstancia().switchTo().window(telaPrincipal);
// 	}

// }
