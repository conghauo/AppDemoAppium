package GroupTest.AppiumTut01;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class AppTestTest {
	
	private AndroidDriver driver; // khai báo biến hỗ trợ test
	// các ID sẽ sử dụng trong test
    By userId = By.id("textInputEditTextEmail");
    By MessUserID = By.id("textInputLayoutEmail");
    By password = By.id("textInputEditTextPassword");
    By Messpassword = By.id("textInputLayoutPassword");  
    By login_Button = By.id("appCompatButtonLogin");
    By wrong = By.id("nestedScrollView");
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554"); //emulator-5554 là tên thiết bị bạn sẽ run test
        capabilities.setCapability("platformversion", "8.1.0"); // 8.1.0 phiên bản Android của thiết bị
        capabilities.setCapability("browserName", "Android");  // Loại test Android / IOS/...
        capabilities.setCapability("platformName", "Android");  // tên SDK Android
       capabilities.setCapability("app", "C:/Users/MyPC/Desktop/AppDemoAppium/app/build/outputs/apk/debug/app-debug.apk"); 
       // chọn đường dẫn fie APK của bạn 
       capabilities.setCapability("appPackage", "com.example.conghau.appdemoappium"); 
       //gói Package của file apk
       capabilities.setCapability("appActivity", "com.example.conghau.appdemoappium.Login"); 
       // màn hình bạn sẽ test
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // host của Appium và thiết bị 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
        // thời gian appium sẽ chờ để gửi vafb nhận lệnh cho thiết bị tối đa
    }
    @Test(priority=1)//priority=1 thứ tự test mà bạn sẽ run
    public void Login_TC03() {
  	  System.out.println("Run Test Case 03 ");
      
      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      // các step của test case
      driver.findElement(userId).clear();// xóa các dữ liệu trên ID 
      driver.findElement(userId).sendKeys("admin@gmail.com");// gửi dữ liệu vào
      driver.findElement(password).clear();
      driver.findElement(password).sendKeys("123456");
      driver.findElement(login_Button).click();
      Assert.assertEquals(driver.findElement(wrong).getText(), "Wrong Email or Password");// so sánh kết quả trả về của test case
      // kết quả mong đợi so sánh với kết quả thực tế 
      // verify rằng với case login failed sẽ hiện thông báo "Wrong Email or Password"
    }
    @Test(priority=0)//priority=0 sẽ run trước priority=1
    public void Login_TC01() throws IOException {
    
    	System.out.println("Run Test Case 01 ");	
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("");
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(login_Button).click();
        Assert.assertTrue(true);      
        // verify rằng với case login failed sẽ hiện thông báo "Enter Valid Email"
        }
    @AfterTest
    public void tearDown() {
        driver.quit(); // đóng webdriver sau khi đã chạy xong
    }

  @Test(priority=2)
  public void Login_TC02() throws IOException  {
	  System.out.println("Run Test Case 02 ");

      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      driver.findElement(userId).clear();
      driver.findElement(userId).sendKeys("admin@gmail.com");
      driver.findElement(password).clear();
      driver.findElement(password).sendKeys("");
      driver.findElement(login_Button).click();
      Assert.assertTrue(true); 
    
  }
}
