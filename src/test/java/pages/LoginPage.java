package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
    	driver.findElement(By.xpath("//a[text()=\"Log in\"]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void enterEmail(String email) {
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    public void clickLogin() {
    	 driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
    }
}