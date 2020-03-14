package Pages;

import Pages.Components.DraftComponent;
import Pages.Components.MenuBarComponent;
import Pages.Components.ScreenComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {
    private WebDriver driver;
    private MenuBarComponent menuBarComponent;
    private ScreenComponent screenComponent;
    private DraftComponent draftComponent;
    //
    private WebElement header;
    private WebElement titleField;
    private WebElement contentField;
    private WebElement saveDraftButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        menuBarComponent = new MenuBarComponent(driver);
        screenComponent = new ScreenComponent(driver);
        InitializeElements();
    }

    public MenuBarComponent getMenuBarComponent(){
        return menuBarComponent;
    }

    public ScreenComponent getScreenComponent(){
        return screenComponent;
    }

    public DraftComponent getDraftComponent(){
        return draftComponent;
    }

    private void InitializeElements(){
        header = driver.findElement(By.cssSelector(".wrap h1"));
        if(getScreenComponent().isQuickDraftSelected()){
            titleField = driver.findElement(By.id("title"));
            contentField = driver.findElement(By.id("content"));
            saveDraftButton = driver.findElement(By.id("save-post"));
        }
        else{
            titleField = null;
            contentField = null;
            saveDraftButton = null;
        }
    }

    ///region AtomicOperations

    //region QuickDraft
    public WebElement getTitleField() {
        return titleField;
    }

    private void TitleFieldClear(){
        getTitleField().clear();
    }

    private void TitleFieldClick(){
        getTitleField().click();
    }

    private void setTitleFieldValue(String input){
        getTitleField().sendKeys(input);
    }
    //endregion

    //region Content
    public WebElement getContentField() {
        return contentField;
    }

    private void ContentFieldClear(){
        getContentField().clear();
    }

    private void ContentFieldClick(){
        getContentField().click();
    }

    private void setContentFieldValue(String input){
        getContentField().sendKeys(input);
    }
    //endregion

    //region SaveDraftButton
    public WebElement getSaveDraftButton() {
        return saveDraftButton;
    }

    private void SaveDraftButtonClick(){
        getSaveDraftButton().click();
    }
    //endregion

    //region Header
    public WebElement getHeader(){
        return header;
    }

    public String getHeaderText(){
        return getHeader().getText();
    }
    ///endregion

    ///region Functional

    //TitleField
    private DashboardPage TitleFieldInput(String title){
        TitleFieldClear();
        TitleFieldClick();
        setTitleFieldValue(title);
        return this;
    }

    //ContentField
    private DashboardPage ContentFieldInput(String content){
        ContentFieldClear();
        ContentFieldClick();
        setContentFieldValue(content);
        return this;
    }
    ///endregion

    ///region Logic

    public DraftComponent AddNewDraft(String title, String content){
        TitleFieldInput(title);
        ContentFieldInput(content);
        SaveDraftButtonClick();
        return new DraftComponent(driver);
    }

    public String VerifyAddedDraft(){
        draftComponent = new DraftComponent(driver);
        return getDraftComponent().getAddedDraftText();
    }

    public EditDraftPage EditDraft(){
        draftComponent = new DraftComponent(driver);
        getDraftComponent().AddedDraftClick();
        return new EditDraftPage(driver);
    }


}


