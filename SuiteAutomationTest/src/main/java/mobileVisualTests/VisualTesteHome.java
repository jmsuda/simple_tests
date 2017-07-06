/**
 * @author Eduardo C. de S�
 *
 * 08/09/2015
 */
package mobileVisualTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import tools.Rotas;
import tools.Visual;
import tools.WebdriverMobile;

/**
 * @author eduardo.sa
 *
 */
public class VisualTesteHome {
	
	@Test
	public void compararTelaHome() {

		System.out.println("----> Mobile Visual Testes: Tela Home - Tela Home.");
		
		String path = Rotas.PATHIMAGENSMOBILE+"compararTelaHome";
		WebdriverMobile.carregarUrl(Rotas.URLBUSCA);
		String current = Visual.capturarTela(WebdriverMobile.obterInstancia(), path);
		boolean compareSuccess = Visual.compareImages(path+"/expected.png", current, path+"/difference.png");
		Assert.assertEquals(true, compareSuccess);
		WebdriverMobile.carregarUrl(Rotas.URLBUSCA+"/logout");
	}
	
}


