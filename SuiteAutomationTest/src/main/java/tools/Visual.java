/**
 * @author Eduardo C. de Sa
 *
 * 04/09/2015
 */
package tools;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.im4java.core.CompareCmd;
import org.im4java.core.IMOperation;
import org.im4java.process.StandardStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author eduardo.sa
 *
 */
public class Visual {

	public static boolean compareImages (String exp, String cur, String diff) {
		// This instance wraps the compare command
		CompareCmd compare = new CompareCmd();

		// For metric-output
		compare.setErrorConsumer(StandardStream.STDERR);
		IMOperation cmpOp = new IMOperation();
		// Set the compare metric
		cmpOp.metric("mae");

		// Add the expected image
		cmpOp.addImage(exp);

		// Add the current image
		cmpOp.addImage(cur);

		// This stores the difference
		cmpOp.addImage(diff);

		try {
			// Do the compare
			compare.run(cmpOp);
			return true;
		}
		catch (Exception ex) {
			return false;
		}
	}
	
	public static String capturarTela(WebDriver driver, String path){
		String current = "";
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			current = path+"/image.png";
			FileUtils.copyFile(scrFile, new File(current));
		}catch(Exception e){
			System.err.println("Nao foi possivel capturar a imagem da tela.");
		}
		return current;
	}
	
	public static String capturarElementoEspecifico(WebDriver driver, String path, String elemento){
		String current = "";
		try{	
			WebElement ele = driver.findElement(By.id(elemento));   
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			BufferedImage  fullImg = ImageIO.read(scrFile);
			Point point = ele.getLocation();
			int eleWidth = ele.getSize().getWidth();
			int eleHeight = ele.getSize().getHeight();
			BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth,eleHeight);
			ImageIO.write(eleScreenshot, "png", scrFile);
			current = path+"/image.png";
			FileUtils.copyFile(scrFile, new File(current));
		}catch(Exception e){
			System.err.println("Nao foi possivel capturar a imagem do componente.");
		}
		return current;
	}
	
	public static void normalizaComponente(){
		try{
		JavascriptExecutor js = (JavascriptExecutor) WebdriverWeb.obterInstancia();
//		js.executeScript("document.getElementById('user-top-menu').style.visibility = 'hidden'");
		js.executeScript("document.getElementById('logged-user-name-holder').innerHTML = 'Anonimo'");
		}catch(Exception e){
			System.err.println("Nao foi possivel normalizar.");
		}
	}
	
	public static void waitAction() {
		try {		
			Thread.sleep(3000);					
		} catch (Exception e) {
			System.err.println("Nao foi possivel aguardar.");
		}
	}
	
}
