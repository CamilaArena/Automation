package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar extends BasePage{
    protected By homeButton = By.cssSelector("navbarExample > ul > li.nav-item.active > a");
    protected By cartButton = By.id("cartur");

    public Navbar (){
        super();
    }

    public void click(String toClick){
        WebElement button = null;
        switch (toClick) {
            case "cart":
                button = findElement(cartButton);
                break;
            case "home":
                button = findElement(homeButton);
                break;
        }
        button.click();
    }

}
