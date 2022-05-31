package pl.kursselenium.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pl.kursselenium.models.Customer;
import pl.kursselenium.pages.HomePage;
import pl.kursselenium.pages.LoggedUserPage;
import pl.kursselenium.pages.SignUpPage;
import pl.kursselenium.utils.DriverFactory;

public class RegisterStepdefs {
    protected String email;
    Customer customer = new Customer();

    @Given("User with unique email address is on register page")
    public void userWithUniqueEmailAddress() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@gmx.de";
        customer.setEmail(email);
        System.out.println(email);

        new HomePage(DriverFactory.getDriver()).openSignupForm();
    }

    @When("User registers in application")
    public void userRegistersInApplication() {
        new SignUpPage(DriverFactory.getDriver()).fillTheForm(customer);

    }

    @Then("User should be redirected to logged user page")
    public void userShouldBeRedirectedToLoggedUserPage() {
        WebElement loggedUserHeading = new LoggedUserPage(DriverFactory.getDriver()).getLoggedUserHeading();

        Assert.assertEquals(loggedUserHeading.getText(), "Hi, " + customer.getFirstName() + " " + customer.getLastName());
    }


    @Given("User with existent email address")
    public void userWithExistentEmailAddress() {
        new HomePage(DriverFactory.getDriver()).openSignupForm();


    }

    @When("User registers in application with existent email")
    public void userRegistersInApplicationWithExistentEmail() {

        new HomePage(DriverFactory.getDriver())
                .openSignupForm()
                .fillTheFormWithExistentEmail(customer);


    }

    @Then("An Error will be displayed {string}")
    public void anErrorWillBeDisplayedUserRemainsOnRegisterPage(String message) {
        WebElement signUpError = new SignUpPage(DriverFactory.getDriver()).getSignupErrors();
        Assert.assertEquals(signUpError.getText(), message);

    }


}
