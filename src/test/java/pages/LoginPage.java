package pages;

import org.openqa.selenium.By;
import services.Utils;

public class LoginPage extends BasePage{
    protected By loginNavBar = By.id("login2");
    protected By username = By.id("loginusername");
    protected By password = By.id("loginpassword");
    protected By login =By.cssSelector("[onclick=\"logIn()\"]");
    protected SignupPage signup = new SignupPage();
    protected By welcomeSign = By.id("nameofuser");


    public LoginPage(){
        super();
    }

    public void click(){
        findElement(loginNavBar).click();
    }

    public void completeValidUsername(){ //puts an existing username
        findElement(username).sendKeys(Utils.getUsername());
    }

    public void completeValidPassword(){
        findElement(password).sendKeys(Utils.getPassword());
    }

    public void completeInvalidUsername(){ //creates a new username
        findElement(username).sendKeys(Utils.generateRandomUsername());
    }

    public void completeInvalidPassword(){ //creates a new password
        findElement(password).sendKeys(Utils.generateRandomPassword());
    }

    public void login(){
        findElement(login).click();
    }

    public String getWelcome(){
        System.out.println(findElement(welcomeSign).getText());
        return findElement(welcomeSign).getText();
    }

    public String getUsername(){
        return signup.getUsername();
    }

    public String getPassword(){
        return signup.getPassword();
    }

}
