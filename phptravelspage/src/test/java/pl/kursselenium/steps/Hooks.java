package pl.kursselenium.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pl.kursselenium.utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void browserSetup(){
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("http://www.kurs-selenium.pl/demo/");
    }


    @After
    public void browserTearDown(){
        DriverFactory.quitDriver();
    }

}
