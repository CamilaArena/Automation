package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.LoginPage;
import pages.Navbar;
import pages.SignupPage;

public class Login {
    public WebDriver driver;
    private LoginPage login;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        login = new LoginPage(driver);
    }

    //  Scenario: I log in with valid credentials
    @Given("I open home page")
    public void openHome(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    @When("I select Log In in the navbar")
    public void login(){
        login.click();
    }

    @When("I complete the username and password with valid ones")
    public void completeData(){
        login.completeInValidUsername();
        login.completeValidPassword();
    }

    @Then("I get logged in")
    public void success(){
        login.login();
       // Assert.assertEquals("Welcome "+login.getUsername() , login.getWelcome());
    }

    //  Scenario: I try to log in with invalid credentials
    @When("I complete the username with an invalid one")
    public void completeInvalidUsername(){
        login.completeInValidUsername();
        login.completeValidPassword();
    }

    @Then("I get a message indicating that User does not exist")
    public void wrongUser(){
        login.login();
        Assert.assertTrue(login.switchToAlert().getText().contains("User does not exist."));
        login.switchToAlert().dismiss();
    }

    //Scenario: I try to log in with invalid username
    @When("I complete the username field with a valid username, and the password with an invalid one")
    public void completeInvalidPassword(){
        login.completeValidUsername();
        login.completeInValidPassword();
    }

    @Then("I get a message indicating that the password is incorrect")
    public void wrongPassword(){
        login.login();
        Assert.assertTrue(login.switchToAlert().getText().contains("Wrong password."));
        login.switchToAlert().dismiss();
    }

    @After
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
