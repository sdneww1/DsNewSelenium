Feature: DS Lunch page functionality

  Background:
    Given User is in the NumpyNinja page

  @mainTitle
  Scenario: User verifies the home page title
    Then User Verify the heading "Preparing for the Interviews"

  @subTitle
  Scenario: User verifies the home page title
    Then User Verify the subheading "You are at the right place"

  @getstarted
  Scenario: User verifies the home page title
    When User clicks the Get Started button for home page
    Then User is navigated to home page from NumpyNinja page
