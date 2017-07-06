package pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import de.sstoehr.harreader.HarReader;
import de.sstoehr.harreader.model.HarEntry;
import de.sstoehr.harreader.model.HarQueryParam;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import tools.Util;
import tools.WebdriverWeb;

public class Platform {

	public void acessarPlatform(String urlPlatform) throws IOException {

		String sURL = urlPlatform; 

		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		Authenticator.setDefault (new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (Util.PLATUSER, Util.PLATPASS.toCharArray());
			}
		});
		request.connect();

		JsonParser jp = new JsonParser(); 
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
		JsonObject rootobj = root.getAsJsonObject(); 
		String apiKey = rootobj.get("apiKey").getAsString(); 
		String name = rootobj.get("name").getAsString(); 
		String urlProduct = rootobj.get("url").getAsString(); 

		System.out.println("ApiKey: "+apiKey);
		System.out.println("Product Name: "+name);
		System.out.println("Url product: "+urlProduct);
	}

	public ArrayList<String> getUrlProductsByRankigProducts(String apiKey, int quantProd, ArrayList<String> listIdProductPlatform ) throws IOException, ParseException {
		System.out.println("----> Montando "+quantProd+" url de produtos randomicos.");
		ArrayList<String> urlProductPlatform = new ArrayList<String>();
		ArrayList<String> listUrlProductPlatform = new ArrayList<String>();

		for(String o: listIdProductPlatform){
			urlProductPlatform.add("https://platform.chaordicsystems.com/raas/v2/clients/"+apiKey+"/products/"+o);			
		}
		for (Iterator<String> i = urlProductPlatform.iterator(); i.hasNext();) {
			String item = i.next();
			if (!getUrlProductPlatform(item).isEmpty()){
				if(listUrlProductPlatform.size()<quantProd){
					listUrlProductPlatform.add(getUrlProductPlatform(item));
				}
			}
		}
		return listUrlProductPlatform;
	}

	private String getUrlProductPlatform(String urlPlatform) throws IOException {

		String sURL = urlPlatform; 
		String urlProduct="";

		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		Authenticator.setDefault (new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (Util.PLATUSER, Util.PLATPASS.toCharArray());
			}
		});
		request.connect();

		JsonParser jp = new JsonParser(); 
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 
		JsonObject rootobj = root.getAsJsonObject();
		String status = rootobj.get("status").getAsString();

		if (status.equals("AVAILABLE")){
			urlProduct = rootobj.get("url").getAsString(); 
			urlProduct = "http://"+urlProduct;

			return urlProduct;
		}	

		return urlProduct;
	}

	public void acessarProducts(ArrayList<String> urlProductsPlatform){

		for (Iterator<String> i = urlProductsPlatform.iterator(); i.hasNext();) {
			String urlProduct = i.next();
			WebdriverWeb.carregarUrl(urlProduct);
		}
		WebdriverWeb.fecharInstancia();
	}

	public ArrayList<String> acessarPaginasProduto(ArrayList<String> urlProductsPlatform){		
		System.out.println("----> Acessando paginas de produtos e capturando o id do usuario.");
		String anonymousUserId = "";
		ArrayList<String> anonymousUserIdList = new ArrayList<String>();

		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.start(0);
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
		WebDriver driver = new ChromeDriver(capabilities);

		for (Iterator<String> i = urlProductsPlatform.iterator(); i.hasNext();) {
			String urlProduct = i.next();

			try{
				proxy.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
				proxy.newHar(urlProduct);
				driver.get(urlProduct);
				net.lightbody.bmp.core.har.Har har = proxy.getHar();

				FileOutputStream fos = new FileOutputStream("\\SuiteAutomationTest\\resource\\log.har");
				har.writeTo(fos);

				HarReader harReader = new HarReader();
				de.sstoehr.harreader.model.Har harLog = harReader.readFromFile(new File("\\SuiteAutomationTest\\resource\\log.har"));

				for (HarEntry entry : harLog.getLog().getEntries()){
					for (HarQueryParam QueryString : entry.getRequest().getQueryString()) {
						if(
								QueryString.getName().equals("q") 
								&& QueryString.getValue().contains("page") 
								&& QueryString.getValue().contains("product")
								&& !QueryString.getValue().contains("view")						
								){
							JsonParser jp = new JsonParser(); 
							JsonElement root = jp.parse(QueryString.getValue());
							if (root instanceof JsonObject) {
								JsonObject  jobject = new JsonObject();
								jobject = root.getAsJsonObject();
								JsonObject identity = jobject.getAsJsonObject("identity");
								anonymousUserId = identity.get("anonymousUserId").getAsString();

								if (anonymousUserId.toLowerCase().contains("anon".toLowerCase())){																
									anonymousUserIdList.add(anonymousUserId);
								}

							} else if (root instanceof JsonArray) {
								JsonArray  jarray =  new JsonArray();
								jarray = root.getAsJsonArray();
								for(JsonElement o: jarray){
									JsonObject oElement = o.getAsJsonObject(); 
									JsonObject identity = oElement.getAsJsonObject("identity");
									anonymousUserId = identity.get("anonymousUserId").getAsString();
								}
							}
						}
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}	
		}

		proxy.stop();
		driver.quit();
		return anonymousUserIdList;
	}

	public boolean verificarAnonymousUserId(ArrayList<String> anonymousUserIdList){
		System.out.println("----> Conferindo o id do usuario com os id capturados no acesso aos produtos.");
		String anonymousUserIdCompare = "";
		anonymousUserIdCompare = anonymousUserIdList.get(0);

		for (String i: anonymousUserIdList) {

			if(anonymousUserIdCompare.equals(i)){
				System.out.println("----> Id do usuario: "+anonymousUserIdCompare);
				return true;
			}else{
				System.out.println("----> Problema com id do usuario.");
				return false;
			}
		}
		return true;
	}

	public boolean verificarIdProducts(ArrayList<String> listIdProductAccess, ArrayList<String> listIdProductPlaform){
		System.out.println("----> Comparando id de produtos acessados com id de produtos no Platfom.");		
		for (int i = 0; i < listIdProductAccess.size(); i++) {
			if (!listIdProductPlaform.contains(listIdProductAccess.get(i))) {
				System.out.println("----> Id de produto com problema: "+listIdProductAccess.get(i).toString());
				return false;
			}
		}
		return true;
	}

	public ArrayList<String> verificarViews(String apiKey, ArrayList<String> anonymousUserIdList) throws IOException{		
		System.out.println("----> Capturando id de produtos acessados pelo usuario.");
		ArrayList<String> listIdProductAccess = new ArrayList<String>();
		String sURL = "https://platform.chaordicsystems.com/raas/v2/clients/"+apiKey+"/users/"+anonymousUserIdList.get(0)+"/views"; 

		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		Authenticator.setDefault (new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (Util.PLATUSER, Util.PLATPASS.toCharArray());
			}
		});
		request.connect();

		JsonParser jp = new JsonParser(); 
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 

		if (root instanceof JsonObject) {
			JsonObject  jobject = new JsonObject();
			jobject = root.getAsJsonObject();
		} else if (root instanceof JsonArray) {
			JsonArray  jarray =  new JsonArray();
			jarray = root.getAsJsonArray();

			for(JsonElement o: jarray){
				JsonObject oElement = o.getAsJsonObject(); 
				String pbid = oElement.get("productId").getAsString();
				listIdProductAccess.add(pbid);
			}
		}		
		return listIdProductAccess;
	}

	public ArrayList<String> getIdProductsPlatform(String apiKey) throws IOException, ParseException {
		System.out.println("----> Capturando do Platform o id dos produtos.");
		ArrayList<String> listIdProductPlatform = new ArrayList<String>();
		String sURL = "https://platform.chaordicsystems.com/raas/v2/clients/"+apiKey+"/recommendations/ranking/algorithmReference/dummy";

		URL url = new URL(sURL);
		HttpURLConnection request = (HttpURLConnection) url.openConnection();
		Authenticator.setDefault (new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication (Util.PLATUSER, Util.PLATPASS.toCharArray());
			}
		});
		request.connect();

		JsonParser jp = new JsonParser(); 
		JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); 

		if (root instanceof JsonObject) {
			JsonObject  jobject = new JsonObject();
			jobject = root.getAsJsonObject();
		} else if (root instanceof JsonArray) {
			JsonArray  jarray =  new JsonArray();
			jarray = root.getAsJsonArray();

			for(JsonElement o: jarray){
				JsonObject oElement = o.getAsJsonObject(); 
				String pbid = oElement.get("pbid").getAsString();
				listIdProductPlatform.add(pbid);			
			}
		}		
		
		if(listIdProductPlatform.isEmpty()){
			System.out.println("----> Nao ha produtos no Platform. Possivelmente apiKey invalida!");
		}
		
		return listIdProductPlatform;
	}


}
