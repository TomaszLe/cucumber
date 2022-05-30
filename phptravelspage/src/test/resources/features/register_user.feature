

Feature: Register user
  Register user feature test for selenium demo app.


Scenario: Registering user with unique email address

  Given User with unique email address is on register page
  When User registers in application
  Then User should be redirected to logged user page


Scenario: Registering user with existent email address

  Given User with existent email address
  When User registers in application with existent email
  Then An Error will be displayed "Email Already Exists.", user remains on register page

