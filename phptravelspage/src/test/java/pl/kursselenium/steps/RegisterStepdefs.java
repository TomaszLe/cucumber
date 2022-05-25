package pl.kursselenium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pl.kursselenium.models.Customer;
import pl.kursselenium.pages.HomePage;
import pl.kursselenium.pages.SignUpPage;
import pl.kursselenium.utils.DriverFactory;

public class RegisterStepdefs {
    protected String email;


    @Given("User with unique email address is on register page")
    public void userWithUniqueEmailAddress() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@gmx.de";
        Customer customer = new Customer();
        customer.setEmail(email);

        new HomePage(DriverFactory.getDriver()).openSignupForm();
    }

    @Given("User with existent email address")
    public void userWithExistentEmailAddress() {
        new HomePage(DriverFactory.getDriver()).openSignupForm();

    }


    @When("User registers in application")
    public void userRegistersInApplication() {
        Customer customer = new Customer();
        new SignUpPage(DriverFactory.getDriver()).fillTheForm(customer);
    }

    @Then("User should be redirected to logged user page")
    public void userShouldBeRedirectedToLoggedUserPage() {
        System.out.println("Logged User");
    }

    @Then("An Error will be displayed {string}, user remains on register page")
    public void anErrorWillBeDisplayedUserRemainsOnRegisterPage(String arg0) {
        System.out.println("Error occurred");
    }
}
