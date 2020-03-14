package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditDraftPage {
    private WebDriver driver;
    //
    private WebElement moveToTrash;

    public EditDraftPage(WebDriver driver){
        this.driver = driver;
        InitializeElements();
    }

    private void InitializeElements(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        moveToTrash = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Move to Trash']")));
    }

    //region MoveToTrash
    public WebElement getMoveToTrash(){
        return moveToTrash;
    }

    private void MoveToTrashClick(){
        getMoveToTrash().click();
    }
    //endregion

    public AllPostPage DeleteDraft(){
        MoveToTrashClick();
        return new AllPostPage(driver);
    }
}
