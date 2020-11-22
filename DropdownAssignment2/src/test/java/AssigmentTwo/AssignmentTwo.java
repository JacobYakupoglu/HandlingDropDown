package AssigmentTwo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AssignmentTwo
{
    WebDriver driver;

    @BeforeTest
    public void driverFirefox()
    {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.cleartrip.com/");
    }

    @Test(priority = 1)
    public void scrollBotton()
    {
        ((JavascriptExecutor) driver).executeScript("scroll(0, 1300);");

    }

    @Test(priority = 2)
    public void selectCurrentDate()
    {
        driver.findElement(By.id("DepartDate")).click();
        driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active ")).click();
    }

    @Test(priority = 3)
    public void chooseAdultNumberFromDropdown()
    {
        Select s = new Select(driver.findElement(By.cssSelector("select#Adults")));
        s.selectByValue("2");
    }

    @Test(priority = 4)
    public void chooseChildNumberFromDropdown()
    {
        Select s = new Select(driver.findElement(By.cssSelector("select#Childrens")));
        s.selectByIndex(4);
    }

    @Test(priority = 5)
    public void chooseInfantdNumberFromDropdown()
    {
        Select s = new Select(driver.findElement(By.cssSelector("select#Infants")));
        s.selectByIndex(0);
    }

    @Test(priority = 6)
    public void moreOptions()
    {
        driver.findElement(By.cssSelector("a#MoreOptionsLink")).click();
    }

    @Test(priority = 7)
    public void chooseClassOfTravel()
    {
        Select s = new Select(driver.findElement(By.cssSelector("select#Class")));
        s.selectByValue("Business");
    }

    @Test(priority = 8)
    public void preferAirline()
    {
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Turkish Airlines");
    }

    @Test(priority = 9)
    public void searchFlight()
    {
        driver.findElement(By.xpath("//input[@id='SearchBtn']")).click();
    }

    @Test(priority = 10)
    public void getErrorMessage()
    {
        System.out.println(driver.findElement(By.xpath("//div[@id='homeErrorMessage']")).getText());
    }

    @Test(priority = 11)
    public void closeBrowser()
    {
        driver.close();
    }
}
