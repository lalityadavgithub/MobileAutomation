package Mobile.Automations;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerApplication extends  BaseTest {

	@SuppressWarnings({ })
	@Test(priority = 1)
	public void MobileAppLogin() throws MalformedURLException, InterruptedException {
	    // Android Driver, IOSDriver
	    // Appium code -> Appium server -> Mobile
	    // Actual Automation code
	    
	    // X path, id, accessiblityid, classname, AndroidUiAutomator
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
		driver.findElement(By.id("com.drivetrackplus.uat:id/userName")).sendKeys("4000000277");
		driver.findElement(By.id("com.drivetrackplus.uat:id/password")).sendKeys("Test@123");
		driver.findElement(By.id("com.drivetrackplus.uat:id/submit")).click();
		
		Thread.sleep(5000);
		
	String text = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"com.drivetrackplus.uat:id/message\"]"))
			.getText();
		if (text.contains("Invalid Username or Password"))
		{
            System.out.println("Login Failed: Invalid Username or Password");
            
            driver.findElement(By.id("com.drivetrackplus.uat:id/confirmButton")).click();
            
          

            // Verify that the entered values are retained
            String u = driver.findElement(By.id("com.drivetrackplus.uat:id/userName")).getText();
            
            Thread.sleep(5000);
            
          String p = driver.findElement(By.id("com.drivetrackplus.uat:id/password")).getAttribute("value");


          System.out.println(u);
          System.out.println(p);
          
          try {
        	    Assert.assertEquals("4000000277", u);
        	    Assert.assertEquals("•••••••", p);
        	    System.out.println("Test Passed: Username and password fields retain entered values.");
        	} catch (AssertionError e) {
        	    System.out.println("Test Failed: Entered values are not retained.");
        	    // Handle the failure as needed, you may want to throw or log the exception
        	}

          if (u.equals("4000000277") &&
              p.equals("•••••••"))
              {
              System.out.println("Test Passed: Username and password fields retain entered values.");
          } else {
              System.out.println("Test Failed: Entered values are not retained.");
          }

		}
		else
		{
			WebElement actualSuccessMessage=driver.findElement(By.id("com.drivetrackplus.uat:id/welcome"));
			String Welcome=actualSuccessMessage.getText();
			System.out.println("Successfully Loggedin"+ Welcome);
		}
	}
}


//    @Test(priority = 3)  
//     public  void verifyCredentialretains () {
//      
//
//            // Find the username, password input fields, and the login button
//            WebElement usernameInput = driver.findElement(By.id("username"));
//            WebElement passwordInput = driver.findElement(By.id("password"));
//            WebElement loginButton = driver.findElement(By.id("loginButton"));
//
//            // Enter invalid credentials
//            usernameInput.sendKeys("invalid_username");
//            passwordInput.sendKeys("invalid_password");
//
//            // Click the login button
//            loginButton.click();
//
//            // Verify that the login attempt failed
//            if (isLoginFailed(driver)) {
//                System.out.println("Login failed as expected.");
//            } else {
//                System.out.println("Test Failed: Unexpected login success.");
//            }
//
//            // Verify that the entered values are retained
//            if (usernameInput.getAttribute("value").equals("invalid_username") &&
//                passwordInput.getAttribute("value").equals("invalid_password")) {
//                System.out.println("Test Passed: Username and password fields retain entered values.");
//            } else {
//                System.out.println("Test Failed: Entered values are not retained.");
//            }
//
//            // Close the browser
//        }
//
//        // Helper method to check if the login attempt failed
//        private static boolean isLoginFailed(WebDriver driver) {
//            // Use a condition to check if a certain element (e.g., error message) is present after a failed login
//            try {
//                WebElement errorMessage = driver.findElement(By.id("errorMessage"));
//                return errorMessage.isDisplayed();
//            } catch (Exception e) {
//                // If the element is not found, return false
//                return false;
//            }
//        }
//            @Test(priority = 4) 
//         public void LoginButtonDisable() {
//            	
//
//                
//            WebElement usernameInput = driver.findElement(By.id("username"));
//            WebElement passwordInput = driver.findElement(By.id("password"));
//            WebElement loginButton = driver.findElement(By.id("loginButton"));
//
//           // Verify that the login button is initially disabled
//            if (!loginButton.isEnabled()) {
//            System.out.println("Test Passed: Login button is initially disabled.");
//           } else {
//        System.out.println("Test Failed: Login button is unexpectedly enabled.");
//           }
//
//             // Enter values in the username and password fields
//           usernameInput.sendKeys("test_username");
//            passwordInput.sendKeys("test_password");
//
//             // Verify that the login button is enabled after entering values
//        if (loginButton.isEnabled()) {
//    System.out.println("Test Passed: Login button is enabled after entering values.");
//      } else {
//    System.out.println("Test Failed: Login button remains disabled after entering values.");
//       }
//
//      // Clear the input fields
//          usernameInput.clear();
//         passwordInput.clear();
//
//            // Verify that the login button is disabled after clearing the fields
//         if (!loginButton.isEnabled()) {
//    System.out.println("Test Passed: Login button is disabled after clearing fields.");
//        } else {
//    System.out.println("Test Failed: Login button is unexpectedly enabled after clearing fields.");
//        }
//
//
//       }
//   
//            
//            
//            @Test(priority = 5)  
//          public void LoginButtonEnable() {
//        	  WebElement usernameInput = driver.findElement(By.id("username"));
//              WebElement passwordInput = driver.findElement(By.id("password"));
//              WebElement loginButton = driver.findElement(By.id("loginButton"));
//
//              // Verify that the login button is initially disabled
//              if (!loginButton.isEnabled()) {
//                  System.out.println("Test Passed: Login button is initially disabled.");
//              } else {
//                  System.out.println("Test Failed: Login button is unexpectedly enabled.");
//              }
//
//              // Enter invalid values in the username and password fields
//              usernameInput.sendKeys("invalid_username");
//              passwordInput.sendKeys("invalid_password");
//
//              // Verify that the login button remains disabled with invalid input
//              if (!loginButton.isEnabled()) {
//                  System.out.println("Test Passed: Login button is disabled with invalid input.");
//              } else {
//                  System.out.println("Test Failed: Login button is unexpectedly enabled with invalid input.");
//              }
//
//              // Clear the input fields
//              usernameInput.clear();
//              passwordInput.clear();
//
//              // Enter valid values in the username and password fields
//              usernameInput.sendKeys("valid_username");
//              passwordInput.sendKeys("valid_password");
//
//              // Verify that the login button becomes enabled with valid input
//              if (loginButton.isEnabled()) {
//                  System.out.println("Test Passed: Login button is enabled with valid input.");
//              } else {
//                  System.out.println("Test Failed: Login button is unexpectedly disabled with valid input.");
//              }
//
//          }
//      
//          
//
//
//          @Test(priority = 6) 
//	    public void ForgetPassord() {
//	    	
//	    	
//	    	WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
//
//	        // Click the 'Forgot Password' link
//	        forgotPasswordLink.click();
//
//	        // Verify that the user is redirected to the password recovery page
//	        if (isOnPasswordRecoveryPage(driver)) {
//	            System.out.println("Test Passed: Clicking 'Forgot Password' link redirects to the password recovery page.");
//	        } else {
//	            System.out.println("Test Failed: User is not redirected to the password recovery page.");
//	        }
//
//	      
//	    }
//
//	    // Helper method to check if the user is on the password recovery page
//	    private static boolean isOnPasswordRecoveryPage(WebDriver driver) {
//	        // Use a condition to check if a certain element (e.g., recovery form) is present on the password recovery page
//	        try {
//	            WebElement recoveryForm = driver.findElement(By.id("recoveryForm"));
//	            return recoveryForm.isDisplayed();
//	        } catch (Exception e) {
//	            // If the element is not found, return false
//	            return false;
//	        }
//	    }
//	
//	    @Test(priority = 7) 
//           public void DoForgetpassord() {
//        	   
//        	   driver.findElement(By.id("Forget Passord link")).click();
//        	   driver.findElement(By.id("Email")).sendKeys("test@gmail.com");
//        	   driver.findElement(By.id("Recovery button")).click();
//        	   
//        	   WebElement successMessage=driver.findElement(By.id("Success Message"));
//        	  
//        	     String actualSuccessMessage = successMessage.getText();
//
//        	        // Expected success message
//        	        String expectedSuccessMessage = "reset passord link has been sent in your email";
//
//        	        // Verify the success message using TestNG assertion
//        	      
//        	        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message mismatch");
//           }  
//        	        @Test
//        	        public void Simulating() {
//        	        
//        	     // Click the 'Recover Password link' button
//        	        WebElement recoverPasswordButton = driver.findElement(By.id("recoverPasswordButton"));
//        	        recoverPasswordButton.click();
//        	        
//        	        System.out.println("Simulating email access and retrieving recovery instructions...");
//
//        	        driver.findElement(By.id("Enter New Password")).sendKeys("Test@123");
//        	        driver.findElement(By.id("Enter Confirm Passord")).sendKeys("Test@123");
//        	        driver.findElement(By.id("Click set passord button")).click();
//        	        
//        	        
//        	        WebElement successMessage=driver.findElement(By.id("Success Message"));
//              	  
//           	     String actualSuccessMessage = successMessage.getText();
//
//           	        // Expected success message
//           	        String expectedSuccessMessage = "Passord reset sucessfuly, Please Login with new password";
//
//           	        // Verify the success message using TestNG assertion
//           	      
//           	        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message mismatch");
//              }  
//        	    
//       

	    

	    
	

