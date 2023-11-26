package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CartPage;
import pages.HomePage;
import pages.Navbar;
import pages.ProductPage;

public class Purchase {
    public WebDriver driver;
    private HomePage home;
    private ProductPage productToBuy;
    private Navbar nav;
    private CartPage cart;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        productToBuy = new ProductPage(driver);
        nav = new Navbar(driver);
        cart = new CartPage(driver);
    }


    @When("I select {string} category and add {string}")
        public void addProduct(String category, String product){
            home.clickCategory(category);
            home.clickProduct(product);
            productToBuy.clickAdd();
            cart.switchToAlert().dismiss();
    }

    @When("I complete the purchase")
    public void purchase(){
        nav.click("cart");
        cart.clickOrder();
        cart.completeData();
        cart.clickPurchase();
    }

    @Then("I get a confirmation message")
    public void result(){
        cart.accept();
    }

    @After
    public void close() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

}
