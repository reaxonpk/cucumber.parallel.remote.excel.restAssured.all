Feature: Assert all buttons
@progress
  Scenario Outline: Successful find all buttons from Homepage

    Given browser "<browser>"
    When website loaded this address: "https://progressbg.net"
    Then I should verify all buttons
    And click on contacts
    And verify contact title is displayed
    And click on partners
    And  verify partners title is displayed
    Examples:
      | browser |
      | chrome  |
