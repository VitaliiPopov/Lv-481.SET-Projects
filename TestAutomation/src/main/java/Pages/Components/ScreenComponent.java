package Pages.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScreenComponent {
    private WebDriver driver;
    //
    private WebElement screenOptionsButton;
    private WebElement quickDraftCheckBox;

    public ScreenComponent(WebDriver driver){
        this.driver = driver;
        InitializeComponent();
    }

    private void InitializeComponent(){
        screenOptionsButton = driver.findElement(By.id("show-settings-link"));
        if (!isScreenOptionsOpened()) {
            ScreenOptionsButtonClick();
        }
        InitializeItems();
        ScreenOptionsButtonClick();
    }

    public boolean isScreenOptionsOpened(){
        String status = getScreenOptionsButton().getAttribute("aria-expanded");
        return status.toLowerCase().equals("true");
    }

    private void InitializeItems(){
        quickDraftCheckBox = driver.findElement(By.id("dashboard_quick_press-hide"));
    }

    //region ScreenOptions
    public WebElement getScreenOptionsButton() {
        return screenOptionsButton;
    }

    public void ScreenOptionsButtonClick(){
        getScreenOptionsButton().click();
    }
    //endregion

    //region QuickDraft
    public WebElement getQuickDraftCheckBox() {
        return quickDraftCheckBox;
    }

    public boolean isQuickDraftSelected(){
        return getQuickDraftCheckBox().isSelected();
    }

    public void QuickDraftCheckBoxClick(){
        getQuickDraftCheckBox().click();
    }
    //endregion
}
