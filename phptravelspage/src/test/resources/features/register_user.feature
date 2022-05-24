

Feature: Register user
  Register user feature test for selenium demo app.


Scenario: Registering user with unique email address

  Given User with unique email address is on register page
  When User registers in application
  Then User should be redirected to logged user page


Scenario: Registering user with existent email address

  Given User with existent email address "test1@select.com"
  When User registers in application
  Then An Error will be displayed " An account is already registered with your email address", user remains on register page

