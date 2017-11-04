//package com.example.conghau.appdemoappium;

/**
 * Created by CongHau on 11/4/2017.
 */
/*import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
    private AndroidDriver driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.7.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0.1");// Bạn phải điền lại version của máy Android bạn đang dùng, máy mình là Android 5.0.1
        capabilities.setCapability("deviceName", "emulator-5554"); // 0217da38 là deviceName mình đã lấy lúc trước

        capabilities.setCapability("app", ""); // Mục đích của đoạn code này là tìm đường dẫn đến file apk của bạn, ở đây file cài của mình  là "flipkart.apk"
        capabilities.setCapability("appPackage", "com.example.conghau.appdemoappium"); //Bạn điền Package name của app đã lấy được ở trên vào đây
        capabilities.setCapability("login", "com.example.conghau.appdemoappium.Login"); //Bạn điền Activity name của app đã lấy được ở trên vào đây
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);//Các bạn điền server address và port đã note lại ở bước trước
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Là dòng lệnh để set timeout
    }
    @Test
    public void Login_TC01() throws IOException {
        System.out.println("Run Test Case 01 ");

        By userId = By.id("textInputEditTextEmail");
        By password = By.id("textInputEditTextPassword");
        By login_Button = By.id("appCompatButtonLogin");


        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.findElement(userId).clear();
        driver.findElement(userId).sendKeys("admin@gmail.com");
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(login_Button).click();
        Assert.assertTrue(driver.findElement(By.id("pageLevelError")).getText().equalsIgnoreCase("Account does not exist")); // verify rằng với case login failed sẽ hiện thông báo "Account does not exist"
    }
    @AfterTest
    public void tearDown() {
        driver.quit(); // đóng webdriver sau khi đã chạy xong
    }
}
*/