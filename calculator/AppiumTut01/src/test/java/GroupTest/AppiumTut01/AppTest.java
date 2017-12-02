package GroupTest.AppiumTut01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	private AndroidDriver driver;

	  @Before
	  public void setUp() throws MalformedURLException {
	    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("platformversion", "6.0");
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("appPackage", "com.example.tranquoc.calculator");
	    desiredCapabilities.setCapability("app", "F:\\appium\\app-debug.apk");
	    desiredCapabilities.setCapability("appActivity", "com.example.tranquoc.calculator.MainActivity");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	  }

	  @Test
	  public void sampleTest() {
	    MobileElement el1 = (MobileElement) driver.findElementById("com.example.tranquoc.calculator:id/btn9");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementById("com.example.tranquoc.calculator:id/btncong");
	    el2.click();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    MobileElement el3 = (MobileElement) driver.findElementById("com.example.tranquoc.calculator:id/btn6");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementById("com.example.tranquoc.calculator:id/btnbang");
	    el4.click();
	    try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.navigate().back();
	    MobileElement el5 = (MobileElement) driver.findElementByAccessibilityId("Apps");
	    el5.click();
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
}
