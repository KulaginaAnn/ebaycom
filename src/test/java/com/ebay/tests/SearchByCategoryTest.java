package com.ebay.tests;


import com.ebay.pages.ResultPage;
import com.ebay.pages.SmartphoneAndAccessoriesPage;
import com.ebay.pages.StartEbayPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BrowserSelection;

import java.util.logging.Logger;

public class SearchByCategoryTest {

    private static Logger log ;
    private static WebDriver driver;


    /**initialization driver */
    @BeforeTest
    public static void setUp() throws Exception {
        driver = BrowserSelection.selectBrowser();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        log = Logger.getLogger("new logger");


    }


    @Test
    @Parameters("browser")
    public void searchViolin() {

        //Start page
        log.info("search tab “Электроника” click it and open new page ");

        StartEbayPage startEbayPage = new StartEbayPage(driver);
        startEbayPage.searchTab(driver);
        log.info("search “smartphone and accessories”, click it and open new page ");
        startEbayPage.clickCategory(driver);


        log.info("check whats page was open ");
        SmartphoneAndAccessoriesPage smartphoneAndAccessoriesPage =  new SmartphoneAndAccessoriesPage(driver);
        smartphoneAndAccessoriesPage.compareLink(driver);
        log.info("search menu with category and click it ");
        log.info("choose “music” category");
        smartphoneAndAccessoriesPage.searchMenuAndCheckItem(driver);

        log.info("search input and add text “Скрипка”");
        smartphoneAndAccessoriesPage.sendTextToInput();
        log.info("find button and add click it, open new page ");
        smartphoneAndAccessoriesPage.clickButtonSearch();

        ResultPage resultPage = new ResultPage(driver);
        log.info("check result ");

        resultPage.checkResult();

    }

    /**close*/
    @AfterTest
    public static void teardown() {
        driver.quit();
    }


}
