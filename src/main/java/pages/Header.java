package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static helpers.Locators.get;

/**
 * Created by ViktorTyulikov on 5/5/2015.
 */
public class Header {

    public static enum HEADER_MENU {
        LOGO, INDEX, ARTICLES, BOOKS, GLOSSARY
    }

    public static final By HEADER_MENU_LOGO = get("Header.HeaderLogo");
    public static final By HEADER_MENU_INDEX = get("Header.HeaderMenuIndex");
    public static final By HEADER_MENU_ARTICLES = get("Header.HeaderMenuArticles");
    public static final By HEADER_MENU_BOOKS = get("Header.HeaderMenuBooks");
    public static final By HEADER_MENU_GLOSSARY = get("Header.HeaderMenuGlossary");
    public static final By HEADER_LOGIN_FIELD = get("Header.HeaderLogin");
    public static final By HEADER_PASSWORD_FIELD = get("Header.HeaderPassword");
    public static final By HEADER_SUBMIT_BUTTON = get("Header.HeaderButton");
    public static final By HEADER_LOGIN_AUTHORIZED = get("Header.HeaderLoginAuthorized");

    public static void goToIndexPageByLogo(WebDriver driver){
        driver.findElement(HEADER_MENU_LOGO).click();
    }
    public static void goToIndexPage(WebDriver driver){
        driver.findElement(HEADER_MENU_INDEX).click();
    }
    public static void goToArticlesPage(WebDriver driver){
        driver.findElement(HEADER_MENU_ARTICLES).click();
    }
    public static void goToBooksPage(WebDriver driver){
        driver.findElement(HEADER_MENU_BOOKS).click();
    }
    public static void goToGlossqryPage(WebDriver driver) {
        driver.findElement(HEADER_MENU_GLOSSARY).click();
    }

    public static void login(WebDriver driver, String login, String password) {
        driver.findElement(HEADER_LOGIN_FIELD).sendKeys(login);
        driver.findElement(HEADER_PASSWORD_FIELD).sendKeys(password);
        driver.findElement(HEADER_SUBMIT_BUTTON).click();
    }

}
