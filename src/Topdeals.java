import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Topdeals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\selenium_training\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.xpath("//tr/th[1]")).click();
		   List<WebElement> elementlist =       driver.findElements(By.xpath("//tr/td[1]"));
		   
		List<String> originallist =  elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String>   newlist =  originallist.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originallist.equals(newlist));
		
		System.out.println("pass");
	}

}
