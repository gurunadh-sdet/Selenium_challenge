Feature: Verifying the login functionality

  Scenario: Login positvie privilege
    Given User is on landing page
    When Login with user name "guru" and password "2345" 
    Then home page should be displayed
    And cards displayed to be "true"
    
  Scenario: Login with negative privilege
		Given User is on landing page
		When Login with user name "raju" and password "4567" 
		Then home page should be displayed
		And cards displayed to be "false"
