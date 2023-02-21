package Academy;

import org.testng.Assert;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class Homepage extends base{
	
	@BeforeTest
	public void intialize() throws IOException {

		driver = BrowserInitializer();
		
	}
	
	@Test(dataProvider="getData")
	
	public void baseHomeNavigation(String Username,String Password,String text) throws IOException {
		driver.get("http://qaclickacademy.com");
		LandingPage l = new LandingPage(driver);
		
		
		l.getpopup().click();
		Assert.assertEquals(l.gettitle().getText(), "FEATURED COURSES");
		Assert.assertTrue(l.getNav().isDisplayed());
		
		l.getlogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.email().sendKeys(Username);
		lp.password().sendKeys(Password);
		lp.getLogin().click();
		System.out.println(text);
		
		
	}
	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		//Row stands for how many different data types test should run
		//column stands for  how many values for each test
		Object[][] data= new Object[1][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		//1st row
		//data[1][0] = "restricteduser@qw.com";
		//data[1][1] = "456788";
		//data[1][2] = "non restricted User";
		return data;
	}
	

}
