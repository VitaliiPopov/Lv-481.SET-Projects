package Pages.Components;

import Pages.DashboardPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MenuBarComponent {

    private WebDriver driver;
    //
    private WebElement myAccountButton;
    private WebElement logout;

    public MenuBarComponent(WebDriver driver){
        this.driver = driver;
        Initialize();
    }

    private void Initialize(){
        myAccountButton = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a[contains(@href, 'profile')]"));
        logout = driver.findElement(By.xpath("//li[@id='wp-admin-bar-logout']/a[contains(@href, 'logout')]"));
    }

    ///AtomicOperations

    //region MyAccount
    public WebElement getMyAccountButton(){
        return myAccountButton;
    }

    public LoginPage LogoutClick(){
        Actions action = new Actions(driver);
        action.moveToElement(getMyAccountButton()).perform();
        logout.click();
        return new LoginPage(driver);
    }
    //endregion
}
