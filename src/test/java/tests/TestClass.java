package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import pages.LoginPage;
import pages.SearchPage;
import utils.DriverUtils;
import org.openqa.selenium.WebDriver;

public class TestClass {
	private WebDriver driver;
	private RegistrationPage registrationPage;
	private LoginPage loginPage;
	private SearchPage searchPage;

	@BeforeMethod (groups= {"pre-requisite"})
	public void setup() {
		driver = DriverUtils.createDriver();
		driver.get("http://demowebshop.tricentis.com/");
		registrationPage = new RegistrationPage(driver);
		loginPage = new LoginPage(driver);
		searchPage = new SearchPage(driver);
	}

	@Test(priority = 1, groups = {"businesslogic"})

	public void registrationTest() {
		registrationPage.register();
		registrationPage.enterFirstName("John");
		registrationPage.enterLastName("Doe");
		registrationPage.enterEmail("john.doe@example.com");
		registrationPage.enterPassword("Password123");
		registrationPage.enterConfirmPassword("Password123");
		registrationPage.clickRegister();
	}

	@Test(priority = 2, dataProvider = "loginData", groups = {"businesslogic"})
	public void loginTest(String email, String password) {
		loginPage.login();
		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() {
		return new Object[][] {
			{"john.doe@example.com", "Password123"}
		};
	}

	@Test(priority = 3, invocationCount = 3, groups = {"businesslogic"})
	public void searchTest() {
		searchPage.searchProduct("Computing and Internet");
		searchPage.clickComputerBooks();
	}

	@AfterMethod (groups= {"tear down"})
	public void teardown() {
		DriverUtils.closeDriver();
	}
}