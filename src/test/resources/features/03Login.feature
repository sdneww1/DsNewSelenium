Feature: SignIN page functionality

  Background:
    Given User is on the Signin page

  @login
  Scenario Outline: Verify login functionality with valid credentials using Excel
    When The user clicks login button with valid credentials from sheet "<sheet>" with "<testcase_id>"
    Then The user should navigate to Data Structure Home Page with message "<expected_message>"

    Examples:
      | sheet      | testcase_id | expected_message  |
      | loginSheet | TC001       | You are logged in |
