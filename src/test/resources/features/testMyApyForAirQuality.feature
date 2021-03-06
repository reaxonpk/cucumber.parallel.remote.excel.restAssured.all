#Feature: Get info from APIs
#
#
#  @positive @api @air
#  Scenario Outline: Get air pollution for P1 and P2
#    Given base url: "https://airtube.info/api/get_data_current.php?location_id="
#    And endpoint: "<sensor>"
#    When I made a call
#    Then I should receive data
#
#    Examples:
#      | sensor |
#      | 3129   |
#
#  @api
#  Scenario: Get information for my Repositories
#    Given base url: "https://api.github.com/users/adchaos/"
#    And endpoint: "repos"
#    When I made a call
#    Then I should receive data for my repos
#
#
#  @api @test
#  Scenario: Get users
#  Given url "https://reqres.in/api/"
#  And with endpoint "users?page=2"
#  When i submit get request
#  Then i should get status 200
#
# @api @test
#  Scenario : Post crate
#  Given url "https://reqres.in/api/"
#  And with endpoint "users"
#  When i submit post request
#  Then i should get status 200
#
#
#
#
#






    #      | 10350  |
#  https://airtube.info/api/get_data_current.php?location_id=3129