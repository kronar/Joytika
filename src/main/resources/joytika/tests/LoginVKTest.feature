Feature: Joytika-login-vk
    Scenario: Visitor try login with VK
        Given Visitor is not logged in
        When Visitor login to the site with VK with username 89171090130 and password haumlium263
        Then Visitor should see that he logged in successfully
