package pl.kursselenium.steps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.kursselenium.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @BeforeMethod
    public void browserSetup(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("http://www.kurs-selenium.pl/demo/");
    }


    @AfterMethod
    public void browserTearDown(){
        DriverFactory.getDriver().quit();
    }

}
