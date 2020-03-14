package Pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftComponent {
    private WebDriver driver;
    //
    private WebElement addedDraft;

    public DraftComponent(WebDriver driver){
        this.driver = driver;
        InitializeElements();
    }

    private void InitializeElements(){
        WebDriverWait wait = new WebDriverWait(driver, 3);
        addedDraft = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='123']")));
    }

    ///region AtomicOperations

    //region Added Draft
    public WebElement getAddedDraft(){
        return addedDraft;
    }

    public String getAddedDraftText(){
        return getAddedDraft().getText();
    }

    public void AddedDraftClick(){
        getAddedDraft().click();
    }
    //endregion

}
