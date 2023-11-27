package pages;

import org.openqa.selenium.By;
import services.Utils;

public class SignupPage extends BasePage{
    protected By signInButton = By.id("signin2");
    protected By username = By.id("sign-username");
    protected By password = By.id("sign-password");
    protected By register =By.cssSelector("[onclick=\"register()\"]");
    protected static String user;
    protected static String passw;

    public SignupPage(){
        super();
        user = Utils.getService().getUsername();
        passw = Utils.getService().getPassword();
    }

    public void click(){
       findElement(signInButton).click();
    }

    public void completeUsername(){
        findElement(username).sendKeys(user);
        System.out.println(user);
    }

    public void completePassword(){
        findElement(password).sendKeys(passw);
    }

    public void register(){
        findElement(register).click();
    }

    public static String getUsername(){
        return user;
    }

    public static String getPassword(){
        System.out.println(passw);
        return passw;
    }

}
