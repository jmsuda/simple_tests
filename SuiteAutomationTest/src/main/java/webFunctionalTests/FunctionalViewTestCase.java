/**
 * @author Eduardo C. de Sa
 *
 * 20/04/2016
 */
package webFunctionalTests;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pages.Platform;

/**
 * @author eduardo.sa
 *
 */
public class FunctionalViewTestCase {

	@Test
	public void testViewProducts() throws IOException, ParseException {

		Platform platform = new Platform();
		ArrayList<String> urlProductPlatform = new ArrayList<String>();
		ArrayList<String> anonymousUserIdList = new ArrayList<String>();
		ArrayList<String> listIdProductAccess = new ArrayList<String>();
		ArrayList<String> listIdProductPlatform = new ArrayList<String>(); 

		String apiKey = "cec";
		int quantProd = 2;

		System.out.println("----> Testes de view de produtos no cliente: "+apiKey);

		listIdProductPlatform = platform.getIdProductsPlatform(apiKey);
		urlProductPlatform = platform.getUrlProductsByRankigProducts(apiKey, quantProd, listIdProductPlatform);
		anonymousUserIdList = platform.acessarPaginasProduto(urlProductPlatform);
		Assert.assertTrue(platform.verificarAnonymousUserId(anonymousUserIdList));
		listIdProductAccess = platform.verificarViews(apiKey, anonymousUserIdList);		
		Assert.assertTrue(platform.verificarIdProducts(listIdProductAccess, listIdProductPlatform));

	}
}



