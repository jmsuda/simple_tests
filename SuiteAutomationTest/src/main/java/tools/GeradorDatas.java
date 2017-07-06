// /**
//  * @author Eduardo C. de S�
//  *
//  * 27/07/2015
//  */
// package tools;

// import java.text.SimpleDateFormat;
// import java.util.Date;
// import java.util.GregorianCalendar;

// /**
//  * @author eduardo.sa
//  *
//  */
// public class GeradorDatas {

// 	public String gerarDataNascimento() {   
// 		long ONE_YEAR_AS_MILLISECONDS = 365*24*60*60*1000;
// 		long TWENTY_FIVE_YEARS_AS_MILLISECONDS = 25*ONE_YEAR_AS_MILLISECONDS;
// 		long FIFTY_YEARS_AS_MILLISECONDS = 50*ONE_YEAR_AS_MILLISECONDS;
// 		long someTimeBetween25And50YearsInMilliSeconds = TWENTY_FIVE_YEARS_AS_MILLISECONDS + 
// 				(long)(Math.random() * ((FIFTY_YEARS_AS_MILLISECONDS - TWENTY_FIVE_YEARS_AS_MILLISECONDS) + 1));
// 		Date d = new Date(System.currentTimeMillis() - someTimeBetween25And50YearsInMilliSeconds);
// 		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
// 		String strDate = sdf.format(d);
// 		return strDate;  
// 	}

// 	@SuppressWarnings("static-access")
// 	public String gerarAnoDataNascimento() {
// 		GregorianCalendar gc = new GregorianCalendar();
// 		int year = randBetween(1900, 2010);
// 		gc.set(gc.YEAR, year);
// 		String anoNascimento = Integer.toString(gc.get(gc.YEAR));
// 		return anoNascimento;  
// 	}

// 	private static int randBetween(int start, int end) {
// 		return start + (int)Math.round(Math.random() * (end - start));
// 	}

// 	public String gerarDataAtual(){
// 		Date hoje = new Date();
// 		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
// 		String data = sdfDate.format(hoje);
// 		return data;
// 	}

// 	public String gerarDataIso8601(){
// 		Date hoje = new Date();
// 		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
// 		String data = sdfDate.format(hoje);
// 		return data;
// 	}

// 	public String normalizarDataIso8601(String data) {
// 		String strData = data.toString();
// 		try{
// 			String ano = strData.substring(0, 4);
// 			String mes = strData.substring(5, 7);
// 			String dia = strData.substring(8, 10);
// 			strData = dia+"/"+mes+"/"+ano;
// 		} catch (Exception e) {
// 			System.out.println("N�o foi poss�vel normalizar a Data. "+e);
// 		}
// 		return strData;
// 	}
	
// 	public String normalizarData(Date data) {
// 		String strData = data.toString();
// 		try{
// 			String ano = strData.substring(0, 4);
// 			String mes = strData.substring(5, 7);
// 			String dia = strData.substring(8, 10);
// 			strData = dia+"/"+mes+"/"+ano;
// 		} catch (Exception e) {
// 			System.out.println("N�o foi poss�vel normalizar a Data. "+e);
// 		}
// 		return strData;
// 	}
// }


