package com.ebay.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Class of Electronics page
 */
public class ElectronicsEbayPage {

    private final WebDriver driver;


    @FindBy(className = "b-visualnav__title") private WebElement searchSmartphoneAndAccesories;

    public ElectronicsEbayPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**click on the link Smartphone And Accessories and go to page with it  */
    public SmartphoneAndAccessoriesPage clickSmartphoneAndAccesories() {
        searchSmartphoneAndAccesories.click();
        return new SmartphoneAndAccessoriesPage(this.driver);
    }

}
