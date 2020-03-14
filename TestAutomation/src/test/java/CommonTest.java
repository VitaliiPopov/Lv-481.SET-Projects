import Data.Instance;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CommonTest extends Instance {

    @Test(priority = 1)
    @Parameters({"login","password"})
    public void LoginTest(String login, String password) {
        getLoginPage().Login(login, password);
        //
        String actual = getDashboardPage().getHeaderText();
        //
        Assert.assertEquals(actual, "Dashboard");
    }

    @Test(priority = 2)
    @Parameters({ "title" , "content"})
    public void AddNewDraftTest(String title, String content) {
        getDashboardPage().AddNewDraft(title, content);
        //
        String actual = getDashboardPage().VerifyAddedDraft();
        //
        Assert.assertEquals(actual, "123");
    }

    @Test(priority = 3)
    public void DeleteDraftTest() {
        getDashboardPage().EditDraft();
        getEditDraftPage().DeleteDraft();
        //
        boolean actual = getAllPostPage().isMessageDisplayed();
        //
        Assert.assertTrue(actual);
    }

    @Test(priority = 4)
    public void LogoutTest() {
        getAllPostPage().getMenuBarComponent().LogoutClick();
        //
        boolean actual = getLoginPage().isLogoutMessageDisplayed();
        //
        Assert.assertTrue(actual);
    }
}


