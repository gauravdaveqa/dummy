package SF.sf1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParabankTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();

            // Create explicit wait with 10 seconds timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("https://parabank.parasoft.com/parabank/index.htm");

            // Wait until "Register" link is clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Register"))).click();

            // Wait for each element before sending keys
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.firstName"))).sendKeys("gaurav");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.lastName"))).sendKeys("dave");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.address.street"))).sendKeys("Moti Chowk,, brahampuri");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.phoneNumber"))).sendKeys("9024930543");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.username"))).sendKeys("gaurav");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.password"))).sendKeys("Test@123");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("repeatedPassword"))).sendKeys("Test@123");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer.ssn"))).sendKeys("9024930543");

            // Wait until Register button is clickable and click
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Register']"))).click();

            // Optionally, wait until a confirmation message or next page element is visible
            // Example:
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("some-confirmation-element")));

            // No Thread.sleep needed now!
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
