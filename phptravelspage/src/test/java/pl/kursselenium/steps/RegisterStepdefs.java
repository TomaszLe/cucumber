package pl.kursselenium.steps;

import io.cucumber.java.en.Given;

public class RegisterStepdefs {
    protected String email;


    @Given("User with unique email address is on register page")
    public void userWithUniqueEmailAddress() {
        int random = (int) (Math.random() * 1000);
        email = "test" + random + "@select.com";
    }

    @Given("User with existent email address {string}")
    public void userWithExistentEmailAddress(String email) {
    }


}
