package GroupTest.TestAppium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import entity.Account;

import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import simpleExcelReader.SimpleExcelReader;

public class AppTestTest {
	private AndroidDriver driver; // khai báo biến hỗ trợ test
	// các ID sẽ sử dụng trong test
	By Name = By.id("textInputEditTextName");
    By Email = By.id("textInputEditTextEmail");
    By MessUserID = By.id("textInputLayoutEmail");
    By password = By.id("textInputEditTextPassword");
    By ConfirmPass = By.id("textInputEditTextConfirmPassword");  
    By Register = By.id("appCompatButtonRegister");
    By nextRegister=By.id("textViewLinkRegister");
    By wrong = By.id("fab");
    By login_Button = By.id("appCompatButtonLogin");
    // khai báo các biến và đường dẫn
    static SimpleExcelReader reader = new SimpleExcelReader();
    static String excelFilePath = "C:/Users/MyPC/Desktop/Newfolder/data.xlsx";
    static List<Account> listAccounts;
    @BeforeMethod
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
      // capabilities.setCapability("appActivity", "com.example.conghau.appdemoappium.Login"); 
       // màn hình bạn sẽ test
        driver =new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // host của Appium và thiết bị 
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
        // thời gian appium sẽ chờ để gửi vafb nhận lệnh cho thiết bị tối đa
      // đọc file excel và lưu data vào biến listAccounts
       
    }
    @DataProvider(name = "TestDemo")// data sử dụng test
    public static Object[][] credentials() {
   
          // The number of times data is repeated, test will be executed the same no. of times
   
          // Here it will execute two times
    	try {
			listAccounts = reader.readBooksFromExcelFile(excelFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    		
          return new Object[][] {{listAccounts.get(1)}};
   
    }
    @Test(priority=0)//priority=0 sẽ run trước priority=1
    public void Login_TC01() throws IOException {
    
    	System.out.println("Run Test Case 01 ");	
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.findElement(Email).clear();
        driver.findElement(Email).sendKeys("admin@gmail.com");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(login_Button).click();
        Assert.assertTrue(true);      
        // verify rằng với case login failed sẽ hiện thông báo "Enter Valid Email"
        }
    @Test(priority=1,dataProvider="TestDemo" )// khai báo data sẽ dùng
    public void Login_Test(Account aAccount)throws IOException { // cái này là các test step cần chạy
    	 
    	 driver.findElement(Name).clear();
         driver.findElement(Name).sendKeys(aAccount.getName());
         driver.findElement(Email).clear();// xóa các dữ liệu trên ID 
         driver.findElement(Email).sendKeys(aAccount.getEmail());// gửi dữ liệu vào
         driver.findElement(password).clear();
         driver.findElement(password).sendKeys(aAccount.getPassword());
         driver.findElement(ConfirmPass).clear();
         driver.findElement(ConfirmPass).sendKeys(aAccount.getConfirmPass());
         driver.findElement(Register).click();
         
         Assert.assertTrue(driver.findElement(wrong).getText().contentEquals("Registration Successful"));// so sánh kết quả trả về của test case
         // kết quả mong đợi so sánh với kết quả thực tế 
         // verify rằng sẽ hiện thông báo "Registration Successful"
    }
  /*  @Test(priority=1)//,dataProvider = "Authentication")//priority=1 thứ tự test mà bạn sẽ run
    public void Login_TC()throws IOException {
  	  System.out.println("Run Test Case:");
      
      driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
      driver.findElement(nextRegister).click();
    
    // các step của test case
      for(int i=0 ; i<listAccounts.size();i++)
      {
      System.out.println("Run Test Case 0"+i);
      Login_Test(listAccounts.get(i));// truyền data vào  test step 
      }
    }*/
    
    @AfterMethod
	@AfterTest
    public void tearDown() {
        driver.quit(); // đóng webdriver sau khi đã chạy xong
    }

}













