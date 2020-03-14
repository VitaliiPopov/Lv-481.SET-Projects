package Data;

import Pages.AllPostPage;
import Pages.DashboardPage;
import Pages.EditDraftPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public abstract class Instance {
    protected WebDriver driver;
    private final String URL = "http://localhost/wordpress/wp-login.php?";

    @BeforeClass
    public void Init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @AfterClass(alwaysRun = true)
    public void TearDown(){
        driver.quit();
    }

    protected DashboardPage getDashboardPage(){
        return new DashboardPage(driver);
    }

    protected LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    protected AllPostPage getAllPostPage(){
        return new AllPostPage(driver);
    }

    protected EditDraftPage getEditDraftPage() {
        return new EditDraftPage(driver);
    }
}
