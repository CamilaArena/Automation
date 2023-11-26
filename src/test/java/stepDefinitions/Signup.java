package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.ro.Si;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.Navbar;
import pages.SignupPage;
import services.DriverManager;

public class Signup {
    public WebDriver driver;
    private SignupPage signup;

    @Before
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        signup = new SignupPage();
    }

    @Given("I'm in the home page")
    public void openHome(){
        driver.get("https://www.demoblaze.com/index.html");
   }

    @When("I select Sign up in the navbar")
    public void signUp(){
        signup.click();
    }

    @When("I create a new username and complete the username and password fields")
    public void register(){
        signup.completeUsername();
        signup.completePassword();
    }

    @Then("I get a success message")
    public void success(){
        signup.register();
        signup.switchToAlert().dismiss();
    }

    @After
    public void close() {
        driver.manage().deleteAllCookies();
    }
}
