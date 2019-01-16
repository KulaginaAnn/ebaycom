package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class BrowserSelection {
    public static WebDriver selectBrowser() throws Exception {

        FileInputStream fis = null;

        File configfile = new File("..\\ebay\\src\\main\\resources\\config.properties");

        fis = new FileInputStream(configfile);

        Properties prop = new Properties();

        prop.load(fis);

        WebDriver driver = null;

        String browser = prop.getProperty("browser");


        while (browser == null) {

            System.out.println("Browser is not specified in Configuration file. Terminating process !!!");
            System.exit(0);

        }

        if (browser.equalsIgnoreCase("firefox")) {
             System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");

            driver = new FirefoxDriver();

            System.out.println("Browser selected for testing is :  Mozilla Firefox");

        } else if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

            System.out.println("Browser selected for testing is :  Google Chrome");


        } else {

            System.out.println("Selected browser value should be either firefox or chrome or ie --> Update in Configuration file is required");

            System.exit(0);

        }

        return driver;
    }
}
