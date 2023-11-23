package pages;

import okhttp3.internal.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.Utils;
public class LoginPage extends BasePage{
    protected By loginNavBar = By.id("login2");
    protected By username = By.id("loginusername");
    protected By password = By.id("loginpassword");
    protected By login =By.cssSelector("[onclick=\"logIn()\"]");
    protected SignupPage signup = new SignupPage(driver);
    protected By welcomeSign = By.id("nameofuser");


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void click(){
        findElement(loginNavBar).click();
    }

    public void completeValidUsername(){
        findElement(username).sendKeys(signup.getUsername()); //puts an existing username
    }

    public void completeValidPassword(){
        findElement(password).sendKeys(signup.getPassword());
    }

    public void completeInValidUsername(){
        findElement(username).sendKeys(Utils.generateRandomUsername());
    }

    public void completeInValidPassword(){
        findElement(password).sendKeys(Utils.generateRandomPassword());
    }
    public void login(){
        findElement(login).click();
    }

    public String getWelcome(){
        return findElement(welcomeSign).getText();
    }

    public String getUsername(){
        return signup.getUsername();
    }

}