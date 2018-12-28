package com.ebay.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * class describe start page of ebay.com.
 * Find tab and click it
 */
public class StartEbayPage {

    private final WebDriver driver;


    private final String TAB = "//ul[@class='hl-cat-nav__container']//a[contains(text(),'%s')]";
    private final String nameTab = "Электроника";


    public StartEbayPage(WebDriver driver) {
        this.driver = driver;
    }


    public ElectronicsEbayPage searchTab(WebDriver driver) {
        WebElement element = driver.findElement(By.xpath(String.format(TAB,nameTab)));
        new Actions(driver).moveToElement(element).perform();
        element.click();
        return new ElectronicsEbayPage(driver);

    }
}
