/**
 * @author Eduardo C. de Sa
 *
 * 07/07/2015
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author eduardo.sa
 *
 */
public class GeradorNumeros {

	public String gerarNumeroRandom(int quantidadeNumero){
		Random ran = new Random();
		int data = 0;
		String numero = "";
		for (int i=1; i<=quantidadeNumero; i++) {
			data = ran.nextInt(9)+1;
			numero = data + numero;
		}
		return numero;
	}

	public String retornaUltimosNumeros(String numero, int quantidadeRetornar){
		int tamanhoString = numero.length();
		if(quantidadeRetornar<tamanhoString){
			numero = numero.substring(numero.length() - 25);
			return numero;
		}else{
			return numero;
		}
	}

	public String gerarNumeroDateRandom(String formato){
		Date hoje = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		String numero = sdf.format(hoje);
		return numero;
	}

	public String gerarId(){
		String id = gerarNumeroDateRandom("yyyyddMMHHmmss");
		return id;
	}

	public String gerarIdMilliseconds () throws InterruptedException{
		String id = gerarNumeroDateRandom("yyyyddMMHHmmssSSS");
		return id;
	}

	public  String gerarStringRandom(int quantidadeCharacter){
		Random r = new Random();
		String characters = "0123456789abcdefghijklmnopqrstuvxyz";
		char[] text = new char[quantidadeCharacter];
		for (int i = 0; i < quantidadeCharacter; i++){
			text[i] = characters.charAt(r.nextInt(characters.length()));
		}
		return new String(text);
	}	
}


