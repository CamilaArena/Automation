package pages;

import org.openqa.selenium.By;
import services.Utils;

public class SignupPage extends BasePage{
    protected By signInButton = By.id("signin2");
    protected By username = By.id("sign-username");
    protected By password = By.id("sign-password");
    protected By register =By.cssSelector("[onclick=\"register()\"]");
    protected String user = Utils.generateRandomUsername();
    protected String passw = Utils.generateRandomPassword();

    public SignupPage(){
        super();
    }

    public void click(){
       findElement(signInButton).click();
    }

    public void completeUsername(){
        findElement(username).sendKeys(user);
    }

    public void completePassword(){
        findElement(password).sendKeys(passw);
    }

    public void register(){
        findElement(register).click();
    }

    public String getUsername(){
        return user;
    }

    public String getPassword(){
        return passw;
    }

}
