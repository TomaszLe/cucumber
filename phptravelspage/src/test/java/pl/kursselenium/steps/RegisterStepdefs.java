package pl.kursselenium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pl.kursselenium.models.BaseTest;
import pl.kursselenium.models.Customer;
import pl.kursselenium.pages.HomePage;
import pl.kursselenium.pages.SignUpPage;

public class RegisterStepdefs extends BaseTest {
    protected String email;


    @Given("User with unique email address is on register page")
    public void userWithUniqueEmailAddress() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@gmx.de";
        Customer customer = new Customer();
        customer.setEmail(email);

        new HomePage(driver).openSignupForm();
    }

    @Given("User with existent email address")
    public void userWithExistentEmailAddress() {
        new HomePage(driver).openSignupForm();

    }


    @When("User registers in application")
    public void userRegistersInApplication() {
        Customer customer = new Customer();
        new SignUpPage(driver).fillTheForm(customer);
    }
}
