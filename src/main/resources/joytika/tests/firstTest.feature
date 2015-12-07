Feature: Joytika-login-vk
    Scenario: Visitor try login with VK
        Given Visitor wants to login
        When Visitor login to the site with VK with username 89171090130 and password haumlium263
        Then Visitor should see that he logged in successfully
