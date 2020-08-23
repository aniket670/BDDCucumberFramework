Feature: To test the Eligibility criteria section for the Grant Application process
#  User Story 2 – Contact Details Section
#  As an Applicant, I should be able to input values for the Main Contact Person and Letter of Offeree in
#  the Contact Details page.
#  AC 1: The page contains a ‘Main Contact Person’ subsection with the following inputs:
#   Name
#   Job Title
#   Contact No
#   Email
#   Alternate Contact Person’s Email
#   Mailing Address
#  AC 2: The Mailing Address input should be able to take in a valid postal code which auto-populates
#  the ‘Blk/Hse No.’ and ‘Street details’ from an external API (One-map).
#  AC 3: Alternatively, there should be a checkbox ‘Same as registered address in Company Profile’
#  which will auto-populate Mailing Address details from the Applicant’s Company Profile.
#  AC 4: The page also contains a ‘Letter of Offer Addressee’ subsection with the following inputs:
#   Name
#   Job Title
#   Email
#  AC 5: There should be an option ‘ Same as main contact person’ which will populate the subsection
#  in AC 4 with details from the ‘Main Contact Person’ in AC 1.
#  AC 6: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved
#  values.
#
#Author :Aniket Khandagale
#Created Date : 18th Aug,2020

#Below Scenario covers the AC 1, AC 3, AC 5
  Scenario Outline:To check User is able to fill in the contact details and mailing address checkbox for registered company address selected
    When User navigates to the Business grant portal login page
    Then User logins the application with valid username and password
    Then User clicks on option Get New Grant
    And User selects the section as <SectorName>
    When User is navigated to select grant type page as <grantoption>
    When User is navigated to apply for grant page <overseasoption>
    Then User is navigated to Grant Actions Page and scroll down to click proceed
    Then User default is on Eligibility section
    And User fills in the Eligibity section questionone as <questionone>
    And User fills in the Eligibity section questiontwo as <questiontwo>
    And User fills in the Eligibity section questionthree as <questionthree>
    And User fills in the Eligibity section questionfour as <question4>
    And User fills in the Eligibity section questionfive as <question5>
    Then User clicks on Next button on eligibility section
    And User fills in the contacts details as <Name>,<JobTitle>,<ContactNo>,<EmailAdress>,<AlternateEmailAdress>
    And User clicks on checkbox for mailing address
    Then User clicks on the checkbox for letter of offer address same as main contact person

   Examples:
   |SectorName|grantoption|overseasoption|questionone|questiontwo|questionthree|question4|question5|Name|JobTitle|ContactNo|EmailAdress|AlternateEmailAdress|
     |IT|1|1|Yes|Yes|Yes|Yes|Yes|TestUser01|Consultant|91834399|test001@gmail.com|test002@gmail.com|

    #Below Scenario covers the AC 1, AC 2, AC 4 and AC6
  Scenario Outline:To check User is able to fill in the contact details and letter of Offer Address is same as Main Person
    When User navigates to the Business grant portal login page
    Then User logins the application with valid username and password
    Then User clicks on option Get New Grant
    And User selects the section as <SectorName>
    When User is navigated to select grant type page as <grantoption>
    When User is navigated to apply for grant page <overseasoption>
    Then User is navigated to Grant Actions Page and scroll down to click proceed
    Then User default is on Eligibility section
    And User fills in the Eligibity section questionone as <questionone>
    And User fills in the Eligibity section questiontwo as <questiontwo>
    And User fills in the Eligibity section questionthree as <questionthree>
    And User fills in the Eligibity section questionfour as <question4>
    And User fills in the Eligibity section questionfive as <question5>
    Then User clicks on Next button on eligibility section
    And User fills in the contacts details as <Name>,<JobTitle>,<ContactNo>,<EmailAdress>,<AlternateEmailAdress>
    And User fills in the postal code and verify the auto derived block and Street Details <Postal>,<BlockNo>,<StreetDetails>
    And User fills in the Letter of Offer Addressee subsection as <SName>,<SJobTitle>,<SEmail>
    And User clicks on save button and refresh to verify the details are saved
    |Name|Designation|Contact|EmailAdress|AlternateEmailAdress|Postal|BlockNo|StreetDetails|
    |TestUser01|Consultant|91834399|test001@gmail.com|test002@gmail.com|520408|408|TAMPINES STREET 41|
    And User clicks on Next button on contact Details

    Examples:
      |SectorName|grantoption|overseasoption|questionone|questiontwo|questionthree|question4|question5|Name|JobTitle|ContactNo|EmailAdress|AlternateEmailAdress|Postal|BlockNo|StreetDetails|SName|SJobTitle|SEmail|
      |IT|1|1|Yes|Yes|Yes|Yes|Yes|TestUser01|Consultant|91834399|test001@gmail.com|test002@gmail.com|520408|408|TAMPINES STREET 41|User02|Consultant|test012@gmail.com|