package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Navbar;
public class Signup {
    public WebDriver driver;
    private Navbar nav;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        nav = new Navbar(driver);
    }

    @Given("I open home page")
    public void openHome(){
        driver.get("https://www.demoblaze.com/index.html");
    }

    @When("I select Sign up in the navbar")
    public void signUp(){
        nav.click("sign up");
    }

    @When("I create a new username and complete the username and password fields")
    public void register(){
        nav.completeUsername();
        nav.completePassword();
    }

    @Then("I get a success message")
    public void success(){
        nav.register();
        nav.switchToAlert().dismiss();
    }

    @After
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
