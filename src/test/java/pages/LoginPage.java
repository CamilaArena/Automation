package pages;

import org.openqa.selenium.By;
import services.Utils;

public class LoginPage extends BasePage{
    protected By loginNavBar = By.id("login2");
    protected By username = By.id("loginusername");
    protected By password = By.id("loginpassword");
    protected By login =By.cssSelector("[onclick=\"logIn()\"]");
    protected By welcomeSign = By.id("nameofuser");


    public LoginPage(){
        super();
    }

    public void click(){
        findElement(loginNavBar).click();
    }

    public void completeValidUsername(){ //puts an existing username
        System.out.println(SignupPage.getUsername());
        findElement(username).sendKeys(Utils.getService().getUsername());
    }

    public void completeValidPassword(){
        findElement(password).sendKeys(Utils.getService().getPassword());
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
        return SignupPage.getUsername();
    }

    public String getPassword(){
        return SignupPage.getPassword();
    }

}
