/**
 * @author Eduardo C. de S�
 *
 * 07/08/2015
 */
package mobileFunctionalTests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import pages.Home;
import tools.Rotas;
import tools.WebdriverMobile;

/**
 * @author eduardo.sa
 *
 */
public class TesteAcessoProtocoloSenha {

	@Test
	public void testeAcessoProtocoloSenha() throws MalformedURLException {

		Home hm = new Home();

		WebdriverMobile.carregarUrl(Rotas.URLBUSCA);
		
	}

}
