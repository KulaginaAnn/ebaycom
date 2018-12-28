package com.ebay.tests;

import com.ebay.tests.pages.ElectronicsEbayPage;
import com.ebay.tests.pages.ResultPage;
import com.ebay.tests.pages.SmartphoneAndAccessoriesPage;
import com.ebay.tests.pages.StartEbayPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class SearchByCategoryTest {

    private static final String URL_PAGE_OF_ELECTRONIC = "https://by.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441";

    private static Logger log ;
    private static WebDriver driver;


    /**initialization driver */
    @BeforeTest
    public static void setUp() {
        driver = new ChromeDriver();//initialization driver
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        log = Logger.getLogger("new logger");
    }


    @Test
    public void searchViolin() {

        //Start page
        log.info("search tab “Электроника” click it and open new page ");

        StartEbayPage startEbayPage = new StartEbayPage(driver);
        startEbayPage.searchTab(driver);


        log.info("search “smartphone and accessories”, click it and open new page ");
        ElectronicsEbayPage electronicsEbayPage =  new ElectronicsEbayPage(driver);
        electronicsEbayPage.clickSmartphoneAndAccesories();

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
