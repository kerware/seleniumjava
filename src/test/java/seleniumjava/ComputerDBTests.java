package seleniumjava;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComputerDBTests {
	
	private static final String BASE_URL = "http://computer-database.gatling.io/computers";
	private PageRechercheComputerDB pageRecherche;
	private static WebDriver driver;
	
	@BeforeAll
	public static void preparation() {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		driver =  new ChromeDriver(  );	
		driver.get( BASE_URL );
	}
	
	public void copieEcran( String nomDeFichier ) throws IOException {
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./"+nomDeFichier+".png"));
	}
	
	
	@Test
	public void RechercheApple2Test() throws IOException {
		pageRecherche = new PageRechercheComputerDB(driver);
		pageRecherche.lancerRecherche("Apple");
		assertTrue(  pageRecherche.ordinateurPresentDansListe("Apple Lisa"));
		copieEcran("ApresRechercheApple");
	}
	
	@AfterAll
	public static void finalisation() {
		driver.quit();
	}
	
}
