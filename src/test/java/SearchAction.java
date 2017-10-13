import org.junit.Test;
import org.openqa.selenium.By;


public class SearchAction {
	
	
	@Test
	public void performSearch() {

		TestSuite.webDriver.findElement(By.xpath("//*[@id='lst-ib']")).sendKeys("Honey");
	}

}
