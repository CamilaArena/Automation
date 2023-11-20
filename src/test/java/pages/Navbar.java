package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navbar extends BasePage{

    protected By homeButton = By.cssSelector("navbarExample > ul > li.nav-item.active > a");
    protected By cartButton = By.id("cartur");
    protected By loginButton = By.id("login2");
    protected By signInButton = By.id("signin2");

    public Navbar (WebDriver driver){
        super(driver);
    }

    public void click(By locator){
        WebElement button = findElement(locator);
        button.click();
    }

}
