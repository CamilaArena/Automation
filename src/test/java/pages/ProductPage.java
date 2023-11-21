package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    protected By addToCartButton =By.cssSelector("[onclick=\"addToCart('1')\"]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public void clickAdd(){
        WebElement add = findElement(addToCartButton);
        add.click();
    }

}
