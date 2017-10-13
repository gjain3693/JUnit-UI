import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;



@RunWith(Suite.class)
@Suite.SuiteClasses({
	OpenBrowser.class,
	SearchAction.class
})
public class TestSuite {
	public static WebDriver webDriver;
	
	@BeforeClass
	public static void initalizeBrowser() {
		System.out.println("IN BEFORE CLASS");
		
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver
				.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
		String webDriverKey = "webdriver.ie.driver";
		String webDriverPath = "F:\\IEDriver\\IEDriverServer.exe";
		System.setProperty(webDriverKey,webDriverPath);

		webDriver = new InternetExplorerDriver(capabilities);
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		webDriver.findElement(
				By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		webDriver.manage().window().maximize();

		
	}
	
	@AfterClass
	public static void  closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		OpenBrowser.webDriver.quit();
	}

}
