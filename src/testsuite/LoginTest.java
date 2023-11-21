package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before

    public void setup(){
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Find email field and enter email id
        driver.findElement(By.linkText("Sign In")).click();
        // Verify 'Welcome Back!'
        String expectedText = "Welcome Back!";
        String actualText = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyTheErrorMessage() throws InterruptedException {
        // Find and click on Sign button
        driver.findElement(By.linkText("Sign In")).click();
        // Find username and enter credential
        driver.findElement(By.name("user[email]")).sendKeys("primetestabc@gmail.com");
        // Find password and enter password
        driver.findElement(By.id("user[password]")).sendKeys("Prime78910");
        // Find and click on submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        // Verify invalid email and password text
        String expectedText = "Invalid email or password.";
        String actualText = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
