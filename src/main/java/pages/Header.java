package pages;

import base.PageBase;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static helpers.Locators.get;

/**
 * Created by ViktorTyulikov on 5/5/2015.
 */
public class Header {
    public static final By HEADER_MENU_LOGO = get("Header.HeaderLogo");
    public static final By HEADER_MENU_INDEX = get("Header.HeaderMenuIndex");
    public static final By HEADER_MENU_ARTICLES = get("Header.HeaderMenuArticles");
    public static final By HEADER_MENU_BOOKS = get("Header.HeaderMenuBooks");
    public static final By HEADER_MENU_GLOSSARY = get("Header.HeaderMenuGlossary");

    public static void goToIndexPageByLogo(){
        $(HEADER_MENU_LOGO).click();
    }

    public static void goToIndexPage(){
        $(HEADER_MENU_INDEX).click();
    }
    public static void goToArticlesPage(){
        $(HEADER_MENU_ARTICLES).click();
    }
    public static void goToBooksPage(){
        $(HEADER_MENU_BOOKS).click();
    }
    public static void goToGlossqryPage() {
        $(HEADER_MENU_GLOSSARY).click();
    }

}
