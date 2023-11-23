package pages;

import okhttp3.internal.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.Utils;
public class SignupPage extends BasePage{
    protected By signInButton = By.id("signin2");
    protected By username = By.id("sign-username");
    protected By password = By.id("sign-password");
    protected By register =By.cssSelector("[onclick=\"register()\"]");
    protected String user = Utils.generateRandomUsername();
    protected String passw = Utils.generateRandomPassword();

    public SignupPage(WebDriver driver){
        super(driver);
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
