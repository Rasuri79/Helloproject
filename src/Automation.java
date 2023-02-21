import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selenium_training\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		int a = driver.findElements(By.tagName("a")).size();
		System.out.println(a);
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));

		int b = footerdriver.findElements(By.tagName("a")).size();
		System.out.println(b);
		WebElement columndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int c = columndriver.findElements(By.tagName("a")).size();
		System.out.println(c);
		for (int i=1; i<columndriver.findElements(By.tagName("a")).size(); i++) {

			String clickontab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickontab);
			Thread.sleep(6000L);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();
		while (it.hasNext())

		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}
	}

}
