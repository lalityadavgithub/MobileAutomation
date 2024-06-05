package Mobile.Automations;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

	@Test
	public void BrowserTest() throws InterruptedException {
		
		driver.get("https://dtpapptestv1.mloyalcapture.com");
	System.out.println(driver.getTitle());
		
	driver.findElement(By.id("textsearch")).sendKeys("lalitadmin");
	driver.findElement(By.id("Password")).sendKeys("1234");
	
	Thread.sleep(15000);
	
//	String Captcha = driver.findElement(By.xpath("//img[@id='img-captcha']")).getText();
//	System.out.println(Captcha);
//	driver.findElement (By.xpath("//input[@id='CaptchaCode']")).sendKeys(Captcha);
	
	driver.findElement(By.id("btnSub")).click();
	driver.findElement(By.id("btnSub")).click();

	}
}
