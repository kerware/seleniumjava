package seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageRechercheComputerDB {
	
	private WebDriver _driver;
	
	public PageRechercheComputerDB( WebDriver driver ) {
		_driver = driver;
	}
	
	
	public void lancerRecherche( String filtre ) {
		WebElement champFiltre = _driver.findElement( By.xpath("//input[ @id='searchbox']"));
		champFiltre.sendKeys(filtre);
		WebElement boutonRecherche = _driver.findElement( By.xpath("//input[ @id='searchsubmit']"));
		boutonRecherche.click();
	}
	
	public PageAjoutOrdinateur ajouterUnOrdinateur() {
		return new PageAjoutOrdinateur();
	}

	public void cliquerBoutonNext() {
		WebElement boutonNext = _driver.findElement( By.xpath("//a[ contains( . ,'Next']"));
		boutonNext.click();
	}
	
	
	public boolean ordinateurPresentDansListe( String ordinateur ) {
	    boolean present = true;
	    _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		present = _driver.findElements(By.xpath("//a[ contains( . , '"+ ordinateur + "')]")).size() > 0;
		 _driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		return present;
	}
}
