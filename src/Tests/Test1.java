package Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/yavuzaydin/Desktop/selenium/chromedriver 2");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 6);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @BeforeMethod
    void loginThePage() {
        driver.get(" https://app.hubspot.com/login");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#username")));
        //WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement username = driver.findElement(By.cssSelector("input#username"));
        username.sendKeys("haliterdogdu@hotmail.com");
        WebElement password = driver.findElement(By.cssSelector("input[id='password']"));
        password.sendKeys("GAAtl12@");
        //Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-test-id='password-login-button']"));
        loginButton.click();

    }

    @Test
    void createContact() {
        // click on the contacts on the menu tab

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//a[@id='nav-primary-contacts-branch'])[1]")));
        WebElement contact = driver.findElement(By.xpath(" (//a[@id='nav-primary-contacts-branch'])[1]"));
        contact.click();
        // click on contacts that inside the contacts
        WebElement contacts = driver.findElement(By.xpath("(//div[contains(text(),'Contacts')])[1]"));
        contacts.click();

        // click on the 'Create Contact' tab

        WebElement createContactButton = driver.findElement(By.xpath("//button[@data-onboarding='new-object-button']"));
        createContactButton.click();

        // Sending email

        WebElement email = driver.findElement(By.cssSelector("input[data-selenium-test='property-input-email']"));
        String mail = "atlanta@gmail.com";
        email.sendKeys(mail);

        // Sending firstName

        String name = "Atlanta";
        WebElement firstNAme = driver.findElement(By.cssSelector("input[data-selenium-test='property-input-firstname']"));
        firstNAme.sendKeys(name);

        // Sending the lastname

        WebElement lastNAme = driver.findElement(By.cssSelector("input[data-selenium-test='property-input-lastname']"));
        lastNAme.sendKeys("is the best");

        // click on create contact
        WebElement creation = driver.findElement(By.xpath("(//span[text()='Create contact'])[2]"));
        creation.click();

        // verify the email

        




    /*

        https://app.hubspot.com/login

        Enter username and password
        Click on login button
        Click on contacts dropdown (on left top)
        Click on contacts button
        Click on create contact button
        Enter email
        Enter First name
        Enter Last name
        Click on Create Contact button


        Verify email and first name as entered
        Click on actions dropdown
        Click on delete button
        Click on Delete contact button

     */

    }
}
