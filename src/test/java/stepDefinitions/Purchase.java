package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.Navbar;
import pages.ProductPage;

import java.time.Duration;

public class Purchase {

    public WebDriver driver;
    private HomePage home = new HomePage(driver);
    private ProductPage productToBuy = new ProductPage(driver);
    private Navbar nav = new Navbar(driver);
    private CartPage cart = new CartPage(driver);

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "./Automation/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("I'm in the home page")
        public void openHome(){
         driver.get("/https://www.demoblaze.com/index");
    }

    @When("I select {string} category and add {string}")
        public void addProduct(String category, String product){
            home.clickCategory(category);
            home.clickProduct(product);
            productToBuy.clickAdd();
            productToBuy.switchToAlert();
            nav.click("cart");
            cart.clickOrder();
    }

    @When("I complete the purchase")
    public void purchase(){
        cart.completeData();
        cart.clickPurchase();
    }

    @Then("I get a confirmation message")
    public void result(){
        cart.accept();
    }


}
