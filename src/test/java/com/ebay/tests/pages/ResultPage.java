package com.ebay.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

/**
 *Class with search results
 */
public class ResultPage {

    private final WebDriver driver;

    @FindBy(id = "//ul[@class='srp-results srp-list clearfix']") private List<WebElement> listOfResults;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /**find block with text "violin" and check result by Assert*/
    public void checkResult() {
        System.out.println(listOfResults.size());
        Assert.assertTrue(listOfResults.size()>0,"Results are not founded");

    }
}
