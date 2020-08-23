Feature: To test the Eligibility criteria section for the Grant Application process

#  User Story 1 – Eligibility Section
#  As an Applicant, I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.
#  AC 1: The section should contain 4 questions:
#  1) Is the applicant registered in Singapore?
#  2) Is the applicant's group sales turnover less than or equal to S$100m or is the applicant's
#  group employment size less than or equal to 200?
#  3) Does the applicant have at least 30% local equity?
#  4) Are all the following statements true for this project? *
#   The applicant has not started work on this project
#   The applicant has not made any payment to any supplier, vendor, or third party prior to
#  applying for this grant
#   The applicant has not signed any contractual agreement with any supplier, vendor, or
#  third party prior to applying for this grant
#  AC 2: Each question can be answered Yes or No through radio buttons.
#  AC 3: Answering No for any of the questions should display a warning message ‘Visit Smart Advisor
#  on the SME Portal for more information on other government assistance.’
#  AC 4: Clicking the link in the warning message in AC 3 will launch a website in another window tab to
#  the url: https://www.smeportal.sg/content/smeportal/en/moneymatters.html#saText
#  AC 5: Clicking ‘Save’ will save the Applicant’s inputs and refreshing the page should reload the saved

    #Author :Aniket Khandagale
    #Created Date : 15th Aug,2020

    Scenario Outline: To check the user is navigated to the Eligibility section of the application
     When User navigates to the Business grant portal login page
     Then User logins the application with valid username and password
     Then User clicks on option Get New Grant
     And User selects the section as <SectorName>
     When User is navigated to select grant type page as <grantoption>
     When User is navigated to apply for grant page <overseasoption>
     Then User selects the functional area as <Functional Area>
     And User clicks on the apply button
     Then User is navigated to Grant Actions Page and scroll down to click proceed
     Then User default is on Eligibility section
     Examples:
     |SectorName|grantoption|overseasoption|
     |IT|1|1|

    Scenario Outline: To check User is able to fill in the Eligibility section with all value as Yes
        When User navigates to the Business grant portal login page
        Then User logins the application with valid username and password
        Then User clicks on option Get New Grant
        And User selects the section as <SectorName>
        When User is navigated to select grant type page as <grantoption>
        When User is navigated to apply for grant page <overseasoption>
        Then User selects the functional area as <Functional Area>
        And User clicks on the apply button
        Then User is navigated to Grant Actions Page and scroll down to click proceed
        Then User default is on Eligibility section
        And User fills in the Eligibity section questionone as <questionone>
        And User fills in the Eligibity section questiontwo as <questiontwo>
        And User fills in the Eligibity section questionthree as <questionthree>
        And User fills in the Eligibity section questionfour as <question4>
        And User fills in the Eligibity section questionfive as <question5>
        Then User clicks on Next button on eligibility section
        Examples:
          |SectorName|grantoption|overseasoption|questionone|questiontwo|questionthree|question4|question5|
          |IT|1|1|Yes|Yes|Yes|Yes|Yes|


