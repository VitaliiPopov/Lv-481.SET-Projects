package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    //
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement loginButton;
    private List<WebElement> logoutMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        InitializeElements();
    }

    private void InitializeElements(){
        loginField = driver.findElement(By.id("user_login"));
        passwordField = driver.findElement(By.id("user_pass"));
        loginButton = driver.findElement(By.id("wp-submit"));
        logoutMessage = driver.findElements(By.cssSelector(".message"));
    }

    ///region AtomicOperations

    //region LoginField
    public WebElement getLoginField(){
        return loginField;
    }

    public void LoginFieldClear(){
        getLoginField().clear();
    }

    public void LoginFieldClick(){
        getLoginField().click();
    }

    public void setLoginFieldValue(String login){
        getLoginField().sendKeys(login);
    }
    //endregion

    //region PasswordField
    public WebElement getPasswordField(){
        return passwordField;
    }

    public void PasswordFieldClear(){
        getPasswordField().clear();
    }

    public void PasswordFieldClick(){
        getPasswordField().click();
    }

    public void setPasswordFieldValue(String password){
        getPasswordField().sendKeys(password);
    }
    //endregion

    //region LoginButton
    public WebElement getLoginButton(){
        return loginButton;
    }

    public void LoginButtonClick(){
        getLoginButton().click();
    }
    //endregion

    //region LogoutMessage
    public List<WebElement> getLogoutMessage(){
        return logoutMessage;
    }

    public boolean isLogoutMessageDisplayed(){
        return !getLogoutMessage().isEmpty();
    }
    //endregion

    ///endregion

    ///region Functional

    //LoginField
    public LoginPage LoginInput(String login){
        LoginFieldClear();
        LoginFieldClick();
        setLoginFieldValue(login);
        return this;
    }

    //PasswordField
    public LoginPage PasswordInput(String password){
        PasswordFieldClear();
        PasswordFieldClick();
        setPasswordFieldValue(password);
        return this;
    }

    ///region Logic
    public DashboardPage Login(String login, String password){
        LoginInput(login);
        PasswordInput(password);
        LoginButtonClick();
        return new DashboardPage(driver);
    }
}