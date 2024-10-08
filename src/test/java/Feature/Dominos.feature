Feature: Dominos POC Scenario

  Scenario: Launch Browser and URL and Enter Pincode
    Given Launch "Chrome" Browser and URL "https://www.dominos.co.in/"
    When User Clicks on Order Online now Button
    And User Enter Pincode "600102"
    And User Selects the First Suggestion Area
    Then User Should Navigate to Product Page
    When User Adds Two Quantity of Margherita Pizza
    And User Adds Two Quantity of Peppy Panner Pizza
    And User Adds Two Quantity of Farmhouse Pizza
    And User Verifies Subtotal Value and Sum of all Pizza Value are same
    And User Adds Twelve Quantities of Pepsi
    And User Verifies Subtotal Value and Sum of all Product Value are same
    And User Removes One Quantity of Margherita Pizza
    And User Removes Six Quantities of Pepsi
    And User Verifies Subtotal Value and Sum of all Product Value are same
    When User Clicks on Checkout
    And User Verifies The Checkout Subtotal and Place order Subtotal are same
    Then User Quit Browser




