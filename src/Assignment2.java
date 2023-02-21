import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("RAHUL");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("contact@rahulshettyacademy.com");
		driver.findElement(By.cssSelector("input[id='exampleInputPassword1']")).sendKeys("rahulshetty");
		driver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
		WebElement staticdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(staticdropdown);
		Thread.sleep(1000);
		// dropdown.selectByValue("Male");
		dropdown.selectByVisibleText("Male");

		driver.findElement(By.id("inlineRadio1")).click();
		driver.findElement(By.name("bday")).sendKeys("17/12/1992");
		driver.findElement(By.cssSelector(".btn-success")).click();
		System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
		String arr1 = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		String[] arr2 = arr1.split("\n");
		String alert = arr2[1];
		System.out.println(alert);
	}

}
