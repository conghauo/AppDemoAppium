package GroupTest.AppiumTut01;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import io.appium.java_client.android.AndroidDriver;


public class AppTestTest {
	 static SimpleExcelReader reader = new SimpleExcelReader();
	    static String excelFilePath = "F:/appium/data.xlsx";
	    static List<data> listdata;
	private AndroidDriver driver; // khai báo biến hỗ trợ test
	 @BeforeTest
	  public void setUp() throws MalformedURLException {
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      // keyword
	      capabilities.setCapability("deviceName", "emulator-5554"); //emulator-5554 là tên thiết bị bạn sẽ run test
	      capabilities.setCapability("platformversion", "6.0.0"); // 6.0 phiên bản Android của thiết bị
	      capabilities.setCapability("browserName", "Android");  // Loại test Android / IOS/...
	      capabilities.setCapability("platformName", "Android");  // tên SDK Android
	      capabilities.setCapability("app", "F:/appium/app-debug.apk");  // chọn đường dẫn fie APK của bạn 
	      capabilities.setCapability("appPackage", "com.example.tranquoc.calculator");
	     //gói Package của file apk
	   
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
				listdata = reader.readBooksFromExcelFile(excelFilePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	Object[][] a = new Object[5][2];
	    	for (int i=0; i< listdata.size();i++)
	    	{
	    		System.out.print(listdata.get(i).getPheptinh());
	    		a[i][0]=listdata.get(i).getPheptinh();
	    		a[i][1]=listdata.get(i).getKetqua();
	    	}
	    		
	          return a;
	   
	    }
		
	  @Test(dataProvider="TestDemo")
	  public void AppTest(String pheptinh,String Ketqua) {
	      System.out.println("Run Test");
	      driver.findElement(By.id("btndel")).click();;
	      driver.findElement(By.id("txt2")).clear();
	    for (int i=0 ; i<pheptinh.length();i++)
	    	
	    switch (pheptinh.charAt(i))
	    { case '0':
	    	driver.findElement(By.id("btn0")).click();
	    	break;
	      case '1':
	    	  driver.findElement(By.id("btn1")).click();
	    	  break;
	      case '2':
	      driver.findElement(By.id("btn2")).click();
	    	  break;
	      case '3':
		    	driver.findElement(By.id("btn3")).click();
		    	break;
		  case '4':
		    	  driver.findElement(By.id("btn4")).click();
		    	  break;
		  case '5':
	        driver.findElement(By.id("btn5")).click();
		    	  break;
		  case '6':
		    	driver.findElement(By.id("btn6")).click();
		    	break;
		  case '7':
		    	  driver.findElement(By.id("btn7")).click();
		    	  break;
		  case '8':
		      driver.findElement(By.id("btn8")).click();
		    	  break;   
		  case '9':
		    	driver.findElement(By.id("btn9")).click();
		    	break;
		  case '+':
		   	  driver.findElement(By.id("btncong")).click();
		    	  break;
		  case '-':
		     driver.findElement(By.id("btntru")).click();
		    	  break;
		  case '*':
		    	driver.findElement(By.id("btnnhan")).click();
		    	break;
		  case '/':
		   	  driver.findElement(By.id("btnchia")).click();
		  break;
		  case '.':
		      driver.findElement(By.id("btncham")).click();
		    	  break;  	  
		  case '=':  
		     driver.findElement(By.id("btnbang")).click();
		     break;
		  default:
			break;  
	    }
		  // Kiểm tra kết quả hiển thị
		  Assert.assertEquals(Ketqua+".0", driver.findElement(By.id("txt2")).getText());
	      // đây là checkpoint
	    }

	  @AfterTest
	  public void afterTest() {
	      // thoát sau khi chạy hết test case
	      // tạm thời mình sẽ không cho chạy dòng này để show cái màn hình sau khi đăng nhập thành công :D
	      //driver.quit();
	  }
}
