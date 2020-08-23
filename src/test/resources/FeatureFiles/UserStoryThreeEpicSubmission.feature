Feature: To fill in the details for other section for review and submit the application

#  As an Applicant, after filling up all mandatory fields in all form sections, I should be able to review
#  and then submit my Grant Application.
#  AC 1: Upon filling all mandatory inputs in all 6 form sections and clicking the ‘Review’ button in the
#  ‘Declare and Review’ section, the Applicant should be taken to a read-only summary page.
#  AC 2: If there are any mandatory inputs missing, a validation error should trigger and the form
#  should redirect to the section with the missing details. An error number should also be shown in the
#  sidebar next to the offending section.
#  AC 3: The read-only summary page should correctly contain all the details previously filled in each
#  form section.
#  AC 4: At the bottom of the read-only summary page is a final ‘Consent and Acknowledgement’
#  checkbox.
#  AC 5: Once checked, the Applicant can submit the entire Application and a Success message box
#  should be shown. The Success message box should contain an Application Ref ID and Agency details
#  should display the receiving Agency as ‘Enterprise Singapore’.
#  AC 6: Upon submission, the main ‘My Grants’ dashboard should show the Application under the
#  ‘Processing’ tab.

  #Author :Aniket Khandagale
#Created Date : 18th Aug,2020
#  Scenario Outline:To check User is able to navigate to Proposal submission section
#    When User navigates to the Business grant portal login page
#    Then User logins the application with valid username and password
#    Then User clicks on option Get New Grant
#    And User selects the section as <SectorName>
#    When User is navigated to select grant type page as <grantoption>
#    When User is navigated to apply for grant page <overseasoption>
#    Then User is navigated to Grant Actions Page and scroll down to click proceed
#    Then User default is on Eligibility section
#    And User fills in the Eligibity section questionone as <questionone>
#    And User fills in the Eligibity section questiontwo as <questiontwo>
#    And User fills in the Eligibity section questionthree as <questionthree>
#    And User fills in the Eligibity section questionfour as <question4>
#    And User fills in the Eligibity section questionfive as <question5>
#    Then User clicks on Next button on eligibility section
#    #And User fills in the contacts details as <Name>,<JobTitle>,<ContactNo>,<EmailAdress>,<AlternateEmailAdress>
#    And User fills in the postal code and verify the auto derived block and Street Details <Postal>,<BlockNo>,<StreetDetails>
#    And User fills in the Letter of Offer Addressee subsection as <SName>,<SJobTitle>,<SEmail>
#    And User clicks on Next button on contact Details
#    Then User verify the proposal page title as <Title>
#
#Examples:
#|SectorName|grantoption|overseasoption|questionone|questiontwo|questionthree|question4|question5|Name|JobTitle|ContactNo|EmailAdress|AlternateEmailAdress|Postal|BlockNo|StreetDetails|SName|SJobTitle|SEmail|Title|
#|IT|1|1|Yes|Yes|Yes|Yes|Yes|TestUser01|Consultant|91834399|test001@gmail.com|test002@gmail.com|520408|408|TAMPINES STREET 41|User02|Consultant|test012@gmail.com|SUBMIT YOUR PROPOSAL|

  # This scenario is basically testing the AC1 of Story 3
  Scenario Outline:To check User is able to navigate to Proposal submission section
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
    And User clicks on Next button on contact Details
    Then User verify the proposal page title as <Title>
    And User fills in project title start end date project description as <ProjectTitle>,<StartDate>,<EndDate>,<ProDesc>
#   Then User select the activity as <Activity> and target market as <TargetMarket>
#    Then User select the option for expanding market outside singapore as <ExpansionOption>
#    Then User performs file upload
#    Then User inputs the remarks <remarks> and click on Save button
    Examples:
      |SectorName|grantoption|overseasoption|questionone|questiontwo|questionthree|question4|question5|Name|JobTitle|ContactNo|EmailAdress|AlternateEmailAdress|Postal|BlockNo|StreetDetails|SName|SJobTitle|SEmail|Title|ProjectTitle|StartDate|EndDate|ProDesc|
      |IT|1|1|Yes|Yes|Yes|Yes|Yes|TestUser01|Consultant|91834399|test001@gmail.com|test002@gmail.com|520408|408|TAMPINES STREET 41|User02|Consultant|test012@gmail.com|SUBMIT YOUR PROPOSAL|TestTitle|28 Aug 2020|21 Dec 2020|Test Desc|