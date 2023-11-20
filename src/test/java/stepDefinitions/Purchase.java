package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

public class Purchase {

    public WebDriver driver;
    private HomePage home = new HomePage(driver);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./Automation/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I'm on the home page")
        public void openHome(){
         driver.get("/https://www.demoblaze.com/index");
    }

    @When("I select {string} category and add {string}")
        public void addProduct(String category, String product){
            home.clickCategory(category);
            home.clickProduct(product);
            //falta implementar cart
    }
}
