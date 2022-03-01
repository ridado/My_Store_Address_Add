Feature: My store user address add

  Scenario Outline: user can add address to account

    Given user is on main My store main page
    When  user clicks on sign in button, inputs "<email>" and "<password>"
    When user clicks on my first address button
    And inputs data to form: "<alias>", "<address>", "<postcode>", "<city>", "<country>", "<phone>"
    And clicks save button
    Then Address is successfully added and "<name>", "<alias>", "<address>", "<city>", "<postcode>", "<country>", "<phone>" are correct
    Then user clicks on delete button and checks if address is successfully deleted
    And user shut down browser


    Examples:
    |email                | password|alias   |address    |postcode|city   |country       |phone    |name      |
    |clark.kent@mail.com  | Super123|superman|Komiksowa 5|00-456  |Krypton|United Kingdom|690987654|Clark Kent|
