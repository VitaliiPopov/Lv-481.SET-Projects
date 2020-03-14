package Pages;

import Pages.Components.MenuBarComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllPostPage {
    private WebDriver driver;
    private MenuBarComponent component;
    //
    private WebElement message;

    public AllPostPage(WebDriver driver){
        this.driver = driver;
        component = new MenuBarComponent(driver);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        message = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("message")));
    }

    public MenuBarComponent getMenuBarComponent(){
        return component;
    }

    public WebElement getMessage(){
        return message;
    }

    public boolean isMessageDisplayed(){
        return getMessage().isDisplayed();
    }


}
