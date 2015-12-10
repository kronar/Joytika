Feature: Global Analytics Test

  Scenario: Test send action  "tutor_click"  for greeting when Visitor press to play button
    Given Visitor come and see greeting
    When Visitor press to play button
    Then Send action tutor_click with type = first, place = button, page = 1, group = site

  Scenario: Test send action "tab_click" when Visitor press to the PAST tap
    Given Visitor came to the site already
    When Visitor press to the PAST tap
    Then Send action tab_click with place = past, group = site

