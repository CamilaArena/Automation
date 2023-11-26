package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {
    protected By addToCartButton =By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");

    public ProductPage() {
        super();
    }
    public void clickAdd(){
        WebElement add = findElement(addToCartButton);
        add.click();
    }

}
