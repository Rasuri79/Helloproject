import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Child_Tabs_Title {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		Thread.sleep(2000);
       
        String options = driver.findElement(By.cssSelector("label[for='benz']")).getText();
        System.out.println(options);
        driver.findElement(By.cssSelector("input[name='checkBoxOption2']")).click();
        WebElement Staticdropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(Staticdropdown);
        dropdown.selectByVisibleText(options);
        
        driver.findElement(By.name("enter-name")).sendKeys(options);
        driver.findElement(By.id("alertbtn")).click();
        String alertText =  driver.switchTo().alert().getText();
        if(alertText.contains(options)) {
        	driver.switchTo().alert().accept();
        	
        }
	    else
	    {
		System.out.println("'alert is fail");
	    }
	    driver.findElement(By.name("enter-name")).sendKeys(options);
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
       
        
      
        
	}

}
