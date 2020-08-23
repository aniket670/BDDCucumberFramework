package com.cucumber.StepDefinitions;

import Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepDefinitionProposalDetails {
    Logger logger = (Logger) LoggerFactory.getLogger(LoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SelectSector sectorpage = new SelectSector();
    EligiblityCheckPage eligiblityCheckPage = new EligiblityCheckPage();
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage();
    ProposalSubmitPage proposalSubmitPage = new ProposalSubmitPage();

    @Then("^User verify the proposal page title as (.+)$")
    public void userVerifyTheProposalPageTitleAsTitle(String title) throws Exception {
        try {
            proposalSubmitPage.verifyProposalTitle(title);
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }
    }

    @And("^User fills in project title start end date project description as (.+),(.+),(.+),(.+)$")
    public void userFillsProposalDetails(String title, String startDate, String endDate, String proDesc) throws Exception {

        try {
            proposalSubmitPage.inputProposalDetails(title,startDate,endDate,proDesc);
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }

    }

    @Then("^User verify the project duration$")
    public void userVerifyTheProjectDuration() throws Exception {

        try {
            proposalSubmitPage.verifyProjectDuration();
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }

    }

    @Then("^User select the activity as (.+) and target market as (.+)$")
    public void userSelectTheActivityAsActivityAndTargetMarketAsTargetMarket(String activity, String tarMarket) throws Exception {

        try {
            proposalSubmitPage.selectActivityTarget(activity,tarMarket);
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }
    }

    @Then("^User select the option for expanding market outside singapore as (.+)$")
    public void userSelectTheOptionForExpandingMarketOutsideSingaporeAsExpansionOption(String expansOption) throws Exception {

        try {
            proposalSubmitPage.selectOptionMarketExpand(expansOption);
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }
    }

    @Then("^User performs file upload$")
    public void userPerformsFileUpload() throws Exception {

        try {
            proposalSubmitPage.performFileUpload();
        } catch (Exception e) {
            proposalSubmitPage.takeScreenShotwithEx(Thread.currentThread().getStackTrace()[1].getMethodName(), e);
        }

    }

    @Then("^User inputs the remarks (.+) and click on Save button$")
    public void userInputsTheRemarksRemarksAndClickOnSaveButton(String remarks) {

        proposalSubmitPage.inputRemarksClickSave(remarks);
    }
}
