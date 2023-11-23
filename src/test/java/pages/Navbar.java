package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import services.Utils;

public class Navbar extends BasePage{
    protected By homeButton = By.cssSelector("navbarExample > ul > li.nav-item.active > a");
    protected By cartButton = By.id("cartur");
    protected By loginButton = By.id("login2");
    protected By signInButton = By.id("signin2");
    protected By username = By.id("sign-username");
    protected By password = By.id("sign-password");
    protected By register =By.cssSelector("[onclick=\"register()\"]");

    public Navbar (WebDriver driver){
        super(driver);
    }

    public void click(String toClick){
        WebElement button = null;
        switch (toClick) {
            case "cart":
                button = findElement(cartButton);
                break;
            case "log in":
                button = findElement(loginButton);
                break;
            case "sign up":
                button = findElement(signInButton);
                break;
            case "home":
                button = findElement(homeButton);
                break;
        }
        button.click();
    }

    public void completeUsername(){
        String user = Utils.generateRandomUsername();
        findElement(username).sendKeys(user);
    }

    public void completePassword(){
        String passw = Utils.generateRandomPassword();
        findElement(password).sendKeys(passw);
    }

    public void register(){
        findElement(register).click();
    }

}
