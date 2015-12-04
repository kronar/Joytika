Feature: Joytika
    Scenario: Visitor Try Login
        Given Visitor wants to login
        When Visitor login to the site with VK with username 89171090130 and password haumlium263
        Then Visitor should see that I logged in successfully
