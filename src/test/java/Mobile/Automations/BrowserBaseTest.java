package Mobile.Automations;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		 // Android Driver, IOSDriver
	    // Appium code -> Appium server -> Mobile
		
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//lalit.pmloyal//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
		.withIPAddress("127.0.0.1").usingPort(4723).build();
		
		service.start();
				
	    UiAutomator2Options options = new UiAutomator2Options();
	    options.setDeviceName("Lalit09");

	    options.setChromedriverExecutable("C:\\Users\\lalit.pmloyal\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

	   options.setCapability("browserName", "Chrome");

	   
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options); // Use /wd/hub
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterClass
	public void tearDown() {
		
		//driver.quit();
	    service.stop();
	}
}
