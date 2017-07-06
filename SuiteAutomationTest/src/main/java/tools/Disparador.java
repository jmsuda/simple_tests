/**
 * @author Eduardo C. de S�
 *
 * 07/07/2015
 */
package tools;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author eduardo.sa
 *
 */
@SuppressWarnings("deprecation")
public class Disparador {

	public int getHealthCheck(String urlString){
		int code = 0;
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
			code = connection.getResponseCode();
			if (code==200)
			{
				System.out.println("Connection Ok! "+code);
			}else{
				System.out.println("Connection fail! "+code);
			}
		} catch (IOException e) {
			System.err.println("Erro ao tentar obter o status code do ambiente "+ e.getMessage());
			e.printStackTrace();
		}
		return code;
	}

	@SuppressWarnings({ "resource", "unused" })
	public int sendXML(String url, String arquivo) throws ClientProtocolException, IOException {
		int code = 0;
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.addHeader("content-type", "application/xml");
		String xml = "";
		HttpEntity entity;
		try {
			File arquivoXml = new File(arquivo);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			xml = stringBuilder.toString();
			entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			code = response.getStatusLine().getStatusCode();

			System.out.println("Envio XML status code: " + response.getStatusLine().getStatusCode());
		} catch (UnsupportedEncodingException e) {
			System.err.println("Erro ao tentar enviar arquivo: "+arquivo+" - "+ e.getMessage());
		}
		return code;
	}

	public void sendString(String urlString, String doc){

		try {
			String toSend = doc;
			String urlParameters = toSend;
			String request = urlString;
			URL url = new URL(request);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type","application/xml");
			connection.setRequestProperty("charset", "utf-8");
			connection.setRequestProperty("Content-Length","" + Integer.toString(urlParameters.getBytes().length));
			connection.setUseCaches(false);

			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(urlParameters);

			int code = connection.getResponseCode();
			String responseMessage = connection.getResponseMessage();
			System.out.println(code+" "+responseMessage);
			wr.flush();
			wr.close();
			connection.disconnect();
		} catch (Exception e) {
			System.err.println("Erro ao tentar enviar arquivo: "+ e.getMessage());
		}

	}

	@SuppressWarnings("resource")
	public int sendJson(String url, String arquivo) throws ClientProtocolException, IOException {
		int code = 0;
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		post.addHeader("content-type", "application/json");
		String xml = "";
		HttpEntity entity;
		try {
			File arquivoJson = new File(arquivo);
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(arquivoJson));
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			String ls = System.getProperty("line.separator");

			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			xml = stringBuilder.toString();
			entity = new ByteArrayEntity(xml.getBytes("UTF-8"));
			post.setEntity(entity);
			HttpResponse response = client.execute(post);
			code = response.getStatusLine().getStatusCode();
			System.out.println("Envio JSON status code: " + response.getStatusLine().getStatusCode());
		} catch (UnsupportedEncodingException e) {
			System.err.println("Erro ao tentar enviar arquivo: "+arquivo+" - "+ e.getMessage());
		}
		return code;
	}
}
