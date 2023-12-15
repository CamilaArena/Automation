package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import services.DriverManager;

public class Login {
    public WebDriver driver;
    private LoginPage login;

    @Before
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        login = new LoginPage();
    }

    // Scenario: I log in with valid credentials
    @Given("I open home page")
    public void openHome(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    @When("I select Log In in the navbar")
    public void login(){
        login.click();
    }

    @When("I complete the {string} and {string} with valid ones")
    public void iCompleteTheAndWithValidOnes(String arg0, String arg1) {
        login.completeUsername(arg0);
        login.completePassword(arg1);
    }

    @Then("I get logged in")
    public void success(){
        login.login();
        Assert.assertEquals("Welcome "+login.getUsername() , login.getWelcome());
    }

    // I try to log in with invalid username
    @When("I complete the {string} with an invalid one")
    public void iCompleteTheWithAnInvalidOne(String arg0) {
        login.completeUsername(arg0);
        login.completePassword(arg0);
    }

    @Then("I get a message indicating that User does not exist")
    public void wrongUser(){
        login.login();
        Assert.assertTrue(login.switchToAlert().getText().contains("User does not exist."));
        login.switchToAlert().dismiss();
    }

    // Scenario: I try to log in with invalid password
    @When("I complete the {string} field with a valid username, and the {string} with an invalid one")
    public void iCompleteTheFieldWithAValidUsernameAndTheWithAnInvalidOne(String arg0, String arg1) {
        login.completeUsername(arg0);
        login.completePassword(arg1);
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
    }

    @When("I don't complete username field and complete the {string}")
    public void iDonTCompleteUsernameFieldAndCompleteThe(String arg0) {
        login.completePassword(arg0);
        login.completeUsername("");
    }

    @Then("I get a message indicating that I should fill out Username and Password")
    public void iGetAMessageIndicatingThatIShouldFillOutUsernameAndPassword() {
        login.login();
        Assert.assertTrue(login.switchToAlert().getText().contains("Please fill out Username and Password."));
        login.switchToAlert().dismiss();
    }


    @When("I complete the {string} field with a valid username, and empty password")
    public void iCompleteTheFieldWithAValidUsernameAndEmptyPassword(String arg0) {
        login.completePassword("");
        login.completeUsername(arg0);
    }
}
