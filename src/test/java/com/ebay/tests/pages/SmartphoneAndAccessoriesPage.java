package com.ebay.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Class of Smartphone And Accessories page
 */
public class SmartphoneAndAccessoriesPage {


    private final WebDriver driver;

    private static final String MENU_MUSIC_ITEM_LOCATOR = "Музыка";
    private static final String INPUT_TEXT = "Скрипка";
    private  static  final String TITLE_PAGE = "Сотовые телефоны, смарт-часы и аксессуары | eBay";
    private static final String URL = "https://by.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441";





    @FindBy(id = "gh-cat") private WebElement menuSelect;
    @FindBy(id = "gh-ac") private WebElement input;
    @FindBy(id = "gh-btn") private WebElement buttonSearch;

    public SmartphoneAndAccessoriesPage(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.urlToBe(URL));

        this.driver = driver;
        PageFactory.initElements(driver, this);


    }


    /**compare two link for check what page was open */
    public void compareLink( WebDriver driver) {
        Assert.assertEquals((driver.findElement(By.xpath("//meta[@content='Сотовые телефоны, смарт-часы и аксессуары | eBay']")).getAttribute("content")), TITLE_PAGE);


    }


    /**find menu on page and select menu item */
    public void searchMenuAndCheckItem(WebDriver driver) {


        Select select = new Select(menuSelect);

        select.selectByVisibleText(MENU_MUSIC_ITEM_LOCATOR);

    }

    /**find input and enter text into it */
    public void sendTextToInput() {
        input.sendKeys(INPUT_TEXT);
    }

    /**search button "search" and click it, go to the page with @inputText*/
    public ResultPage clickButtonSearch() {
        buttonSearch.click();
        return new ResultPage(this.driver);
    }
}
