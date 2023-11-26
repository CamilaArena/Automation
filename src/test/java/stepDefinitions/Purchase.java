package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import services.DriverManager;

public class Purchase {
    public WebDriver driver;
    private HomePage home;
    private ProductPage productToBuy;
    private Navbar nav;
    private CartPage cart;

    @Before
    public void setUp(){
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        nav = new Navbar();
        cart = new CartPage();
        home = new HomePage();
        productToBuy = new ProductPage();
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
    }

}
