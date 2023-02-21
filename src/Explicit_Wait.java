import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("learning");
        
        driver.findElement(By.cssSelector("input[value='user']")).click();  
       //Thread.sleep(2000);
       WebDriverWait w =new WebDriverWait(driver,5);
       w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
       
        driver.findElement(By.id("okayBtn")).click();
        //driver.switchTo().alert().accept();
        WebElement staticdropdwon = driver.findElement(By.cssSelector("select[data-style='btn-info']"));
        Select dropdown = new Select(staticdropdwon);
        
        dropdown.selectByVisibleText("Consultant");
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();
       // Thread.sleep(1000);
        List<WebElement> products = driver.findElements(By.cssSelector("button[class='btn btn-info']"));
        for(int i=0;i<products.size();i++)
        {
        	
        	//driver.findElement(By.cssSelector("button[class='btn btn-info']")).click();
        	products.get(i).click();
        }
        driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();
        
	}

}
