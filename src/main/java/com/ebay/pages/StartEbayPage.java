package com.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * class describe start page of ebay.com.
 * Find tab and click it
 */
public class StartEbayPage {

    private final WebDriver driver;


    private final String TAB = "//ul[@class='hl-cat-nav__container']//a[contains(text(),'%s')]";
    private final String NAME_TAB = "Электроника";

    private final String CATEGORY =  "//*[contains(text(),'%s')]";
    private final String NAME_CATEGORY = "Смартфоны и аксессуары";

    private final String NAME_CATEGORY_Xpath = "//*[@id=\"mainContent\"]/div[1]/ul/li[3]/div[2]/div[1]/div[1]/ul/li[1]/a";
    public StartEbayPage(WebDriver driver) {
        this.driver = driver;
    }


    public void searchTab(WebDriver driver) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBe(By.xpath(String.format(TAB,NAME_TAB)), NAME_TAB));

        WebElement element = driver.findElement(By.xpath(String.format(TAB,NAME_TAB)));
        new Actions(driver).moveToElement(element).perform();

        System.out.println(String.format(TAB,NAME_TAB));

    }

    public SmartphoneAndAccessoriesPage clickCategory(WebDriver driver){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(NAME_CATEGORY_Xpath)));

        WebElement element = driver.findElement(By.xpath(String.format(CATEGORY,NAME_CATEGORY)));
        System.out.println(String.format(CATEGORY,NAME_CATEGORY));
        element.click();
        return new SmartphoneAndAccessoriesPage(driver);

    }
}
