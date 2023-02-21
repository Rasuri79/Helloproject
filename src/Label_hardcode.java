import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Label_hardcode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\selenium_training\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption2")).click();
		String choices = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();
        //System.out.println("Hello");

		System.out.println(choices);
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(dropdown);
		
		s.selectByVisibleText(choices);
		driver.findElement(By.id("name")).sendKeys(choices);
		driver.findElement(By.id("alertbtn")).click();
		Thread.sleep(5000);
		String alertText = driver.switchTo().alert().getText();
		if(alertText.contains(choices))
		{
			driver.switchTo().alert().accept();
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.findElement(By.id("name")).sendKeys(choices);
		driver.findElement(By.id("confirmbtn")).click();
		String confirmText = driver.switchTo().alert().getText();
		if(confirmText.contains(choices))
		{
			driver.switchTo().alert().dismiss();
			System.out.println("conform");
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
		
        
	}

}
