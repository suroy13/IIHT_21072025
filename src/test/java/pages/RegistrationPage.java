package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void register() {
    	driver.findElement(By.xpath("//a[text()=\"Register\"]")).click();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void enterFirstName(String firstName) {
    	String firstname= driver.findElement(By.xpath("//label[text()=\"First name:\"]")).getText();
    	Assert.assertEquals("First name:", firstname);
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
    	String lastname= driver.findElement(By.xpath("//label[text()=\"Last name:\"]")).getText();
    	Assert.assertEquals("Last name:", lastname);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
    }

    public void enterEmail(String email) {
    	String emailA= driver.findElement(By.xpath("//label[text()=\"Email:\"]")).getText();
    	Assert.assertEquals("Email:", emailA);
        driver.findElement(By.id("Email")).sendKeys(email);
    }

    public void enterPassword(String password) {
    	String passwordA= driver.findElement(By.xpath("//label[text()=\"Password:\"]")).getText();
    	Assert.assertEquals("Password:", passwordA);
        driver.findElement(By.id("Password")).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
    	String CpasswordA= driver.findElement(By.xpath("//label[text()=\"Confirm password:\"]")).getText();
    	Assert.assertEquals("Confirm password:", CpasswordA);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirmPassword);
    }

    public void clickRegister() {
        driver.findElement(By.id("register-button")).click();
    }
}