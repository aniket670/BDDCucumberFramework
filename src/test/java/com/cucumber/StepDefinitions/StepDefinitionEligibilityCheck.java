package com.cucumber.StepDefinitions;

import Cucumber_Listener.Reporter;
import Pages.EligiblityCheckPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SelectSector;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitionEligibilityCheck  {

   Logger logger = (Logger) LoggerFactory.getLogger(LoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SelectSector sectorpage = new SelectSector();
    EligiblityCheckPage eligiblityCheckPage = new EligiblityCheckPage();

    @When("^User navigates to the Business grant portal login page$")
    public void userNavigatesToTheBusinessGrantPortalLoginPage() throws Exception {
        try {
            loginPage.navigateLoginPage();
            Reporter.addStepLog("The User navigates to the portal");
            Reporter.addScenarioLog("The User navigation is completed");
        } catch (InterruptedException e) {
            loginPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
            //loginPage.addScreenCaptureFromPath
        }
    }

    @Then("^User logins the application with valid username and password$")
    public void userLoginsTheApplicationWithValidUsernameAndPassword() throws Exception {
        try {
            loginPage.loginApplication();
        } catch (Exception e) {
            loginPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @Then("^User clicks on option Get New Grant$")
    public void userClicksOnOptionGetNewGrant() throws Exception {
        try {
            homePage.clickOptionNewGrant();
        } catch (Exception e) {
            homePage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @And("^User selects the section as (.+)$")
    public void userSelectsTheSectionAsSectorName(String sector) throws Exception {
        try {
            sectorpage.selectSectorName(sector);
        } catch (Exception e) {
            sectorpage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @When("^User is navigated to select grant type page as (.+)$")
    public void userIsNavigatedToSelectGrantTypePage(int option) throws Exception {
        try {
            sectorpage.verifyUserNavigationToSelectGrantType(option);
        } catch (Exception e) {
            sectorpage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @Then("^User selects the Development area as (.+)$")
    public void userSelectsTheDevelopmentAreaAsDevelopmentType(int area) {
        try {
            sectorpage.selectDevlopArea(area);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^User is navigated to apply for grant page (.+)$")
    public void userIsNavigatedToApplyForGrantPage(int option) throws Exception {
        try {
            sectorpage.applyGrant(option);
        } catch (Exception e) {
            sectorpage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }

    }

    @Then("^User is navigated to Grant Actions Page and scroll down to click proceed$")
    public void userIsNavigatedToGrantActionsPageAndScrollDownToClickProceed() throws Exception {
        try {
            sectorpage.scrollAndClicksProceed();
        } catch (Exception e) {
            sectorpage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @Then("^User selects the functional area as <Functional Area>$")
    public void userSelectsTheFunctionalAreaAsFunctionalArea() {
        
    }

    @And("^User clicks on the apply button$")
    public void userClicksOnTheApplyButton() {
        
    }

    @When("^User clicks on Proceed is navigated to application stages\\.$")
    public void userClicksOnProceedIsNavigatedToApplicationStages() {
    }

    @Then("^User default is on Eligibility section$")
    public void userDefaultIsOnEligibilitySection() throws Exception {
        try {
            sectorpage.userCheckDefaultOnEligibilityCheck();
        } catch (Exception e) {
            sectorpage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @And("^User fills in the Eligibity section questionone as (.+)$")
    public void userFillsInTheEligibitySectionQuestionAsQuestion(String option) throws Exception {
        try {
            eligiblityCheckPage.selectEligbilityCheckOptionQuestionOne(option);
        } catch (Exception e) {
            eligiblityCheckPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }
    }

    @And("^User fills in the Eligibity section questiontwo as (.+)$")
    public void userFillsInTheEligibitySectionQuestiontwoAsQuestion(String option) throws Exception {

        try {
            eligiblityCheckPage.selectEligbilityCheckOptionQuestionTwo(option);
        } catch (Exception e) {
            eligiblityCheckPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(),e);
        }

    }

    @And("^User fills in the Eligibity section questionthree as (.+)$")
    public void userFillsInTheEligibitySectionQuestionthreeAsQuestion(String option) {

        try {
            eligiblityCheckPage.selectEligbilityCheckOptionQuestionThree(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User fills in the Eligibity section questionfour as (.+)$")
    public void userFillsInTheEligibitySectionQuestionfourAsQuestion(String option) {

        try {
            eligiblityCheckPage.selectEligbilityCheckOptionQuestionFour(option);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User fills in the Eligibity section questionfive as (.+)$")
    public void userFillsInTheEligibitySectionQuestionfiveAsQuestion(String option) {
        try {
            eligiblityCheckPage.selectEligbilityCheckOptionQuestionFive(option);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^User clicks on Next button on eligibility section$")
    public void userClicksOnNextButtonOnEligibilitySection() {
        try {
            eligiblityCheckPage.clickNxteligibility();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



}


