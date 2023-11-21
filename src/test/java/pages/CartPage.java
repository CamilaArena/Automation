package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

public class CartPage extends BasePage{
    Faker faker = new Faker();
    protected By order =By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
    protected By message =By.xpath("/html/body/div[10]/div[7]/div/button");
    protected By name = By.id("name");
    protected By country = By.id("country");
    protected By city = By.id("city");
    protected By card = By.id("card");
    protected By month = By.id("month");
    protected By year = By.id("year");

    protected By purchase =By.cssSelector("[onclick=\"purchaseOrder()\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickOrder() {
        findElement(order).click();
    }

    public void completeData(){
        findElement(name).sendKeys(faker.name().firstName());
        findElement(country).sendKeys("Argentina");
        findElement(city).sendKeys(faker.address().cityName());
        findElement(card).sendKeys(faker.business().creditCardNumber());
        findElement(month).sendKeys("September");
        findElement(year).sendKeys("2023");
    }

    public void clickPurchase(){
        findElement(purchase).click();
    }

    public void accept(){
        findElement(message).click();
    }

}
