package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    protected By phoneCategory =By.cssSelector("[onclick=\"byCat('phone')\"]");
    protected By laptopCategory =By.cssSelector("[onclick=\"byCat('notebook')\"]");
    protected By monitorCategory =By.cssSelector("[onclick=\"byCat('monitors')\"]");
    public HomePage (WebDriver driver){
        super(driver);
    }

    public void clickCategory(String category){
        WebElement button = null;
        switch (category) {
            case "phone":
               button = findElement(phoneCategory);
                break;
            case "laptop":
                button = findElement(laptopCategory);
                break;
            case "monitor":
                button = findElement(monitorCategory);
                break;
        }
        button.click();
    }

    public void clickProduct(String product) {
        By productLocator = By.xpath("//a[contains(text(),'" + product + "')]");
        findElement(productLocator).click();
    }

}
