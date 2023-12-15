package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    protected By loginNavBar = By.id("login2");
    protected By username = By.id("loginusername");
    protected By password = By.id("loginpassword");
    protected By login =By.cssSelector("[onclick=\"logIn()\"]");
    protected By welcomeSign = By.id("nameofuser");
    protected String user;


    public LoginPage(){
        super();
    }

    public void click(){
        findElement(loginNavBar).click();
    }

    public void completeUsername(String user){ //puts an existing username
        findElement(username).sendKeys(user);
        this.user = user;
    }

    public void completePassword(String pass){
        findElement(password).sendKeys(pass);
    }

    public void login(){
        findElement(login).click();
    }

    public String getWelcome(){
        System.out.println(findElement(welcomeSign).getText());
        return findElement(welcomeSign).getText();
    }

    public String getUsername(){
        return user;
    }

}
