Feature: DS Home page functionality

  Background:
    Given User is in the NumpyNinja page

  @getstarted
  Scenario: User verifies the home page title
    When User clicks the Get Started button for home page
    Then User is navigated to home page from NumpyNinja page