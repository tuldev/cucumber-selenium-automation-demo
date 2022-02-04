Feature: Localhut AdminPanel Website

  Scenario Outline: As a user, I can log into the secure area

    Given I am on the login page
    When I login with email as <email> and password as <password>
    Then I should see a flash message saying <message>

    Examples:
      | email                 | password   | message                             |
      | admin@localhut.co.uk  | Admin@123! | You logged into a secure area!      |