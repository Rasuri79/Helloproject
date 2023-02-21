import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar_dates {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\selenium_training\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("travel_date")).click();
		String month = driver
				.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']")).getText();
		System.out.println(month);
		while (!driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='datepicker-switch']"))
				.getText().contains("June")) {

			driver.findElement(By.cssSelector("table[class= ' table-condensed'] th[class='next']")).click();
		}
		Thread.sleep(5000);
		// System.out.println(month);

		int daySize = driver.findElements(By.cssSelector("td[class='day']")).size();
		System.out.println(daySize);

		for (int i = 0; i < daySize; i++)
		{
			String day = (driver.findElements(By.className("day")).get(i).getText());

			if (day.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}

		}
		 System.out.println(month);

	}

}
