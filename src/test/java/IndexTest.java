import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ArticlesPage;
import pages.Header;
import pages.IndexPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static pages.Header.HEADER_MENU.LOGO;

/**
 * Created by ViktorTyulikov on 5/5/2015.
 */
public class IndexTest extends TestBase {

    //test
    @Test
    public void checkMenuLinks() {
        for (Header.HEADER_MENU menu : Header.HEADER_MENU.values()) {
            switch (menu) {
                case LOGO:
                    Header.goToIndexPageByLogo(driver);
                    Assert.assertEquals(driver.getTitle(), "uZability", "wrong title Index page link by logo");
                    driver.navigate().back();
                    break;
                case INDEX:
                    Header.goToIndexPage(driver);
                    Assert.assertEquals(driver.getTitle(), "uZability", "wrong title Index page");
                    driver.navigate().back();
                    break;
                case ARTICLES:
                    Header.goToArticlesPage(driver);
                    Assert.assertEquals(driver.getTitle(), "Articles | uZability", "wrong title Articles page");
                    driver.navigate().back();
                    break;
                case BOOKS:
                    Header.goToBooksPage(driver);
                    Assert.assertEquals(driver.getTitle(), "Books | uZability", "wrong title Books page");
                    driver.navigate().back();
                    break;
                case GLOSSARY:
                    Header.goToGlossqryPage(driver);
                    Assert.assertEquals(driver.getTitle(), "Glossary | uZability", "wrong title Glossary page");
                    driver.navigate().back();
                    break;
                default:
                    Assert.assertTrue(false, "Wrong element in Header.HEADER_MENU");
            }
        }
    }

    @DataProvider
    public Object[][] getCreds() {
        return new Object[][]{
                {"invalidUser", "asd", false},
                {"ork", "1111", true},
                {"tom", "2222", true},
                {"tomhardi", "supersecref", false}
        };
    }

    @Test(dataProvider = "getCreds")
    public void loginTest(String login, String password, boolean isValid) {
        Header.login(driver,login,password);
        if(isValid) {
            Assert.assertEquals(driver.getCurrentUrl(), BASE_URL);
            Assert.assertEquals(login,driver.findElement(Header.HEADER_LOGIN_AUTHORIZED).getText(), "wrong user name displayed");
        } else {
            Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL+"loginFail") );
            Assert.assertEquals(driver.getTitle(), "Login fail page", "not login fail page");
        }
    }

}