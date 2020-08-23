package com.cucumber.StepDefinitions;

import Pages.*;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class StepDefinitionContactDetails {
    Logger logger = (Logger) LoggerFactory.getLogger(LoginPage.class);
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    SelectSector sectorpage = new SelectSector();
    EligiblityCheckPage eligiblityCheckPage = new EligiblityCheckPage();
    ContactDetailsPage contactDetailsPage = new ContactDetailsPage();

    @And("^User fills in the contacts details as (.+),(.+),(.+),(.+),(.+)$")
    public void userFillContactsDetails(String name, String jobTitle,int contct,String email, String secondEmail) {
        try {
            contactDetailsPage.inputContactDetails(name,jobTitle,contct,email,secondEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User clicks on checkbox for mailing address$")
    public void userClicksOnCheckboxForMailingAddress() {
        try {
            contactDetailsPage.selectCheckboxForAddress();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^User clicks on the checkbox for letter of offer address same as main contact person$")
    public void userClicksOnTheCheckboxForLetterOfOfferAddressSameAsMainContactPerson() {

        try {
            contactDetailsPage.selectCheckboxForAddSameAsMainPerson();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^User fills in the postal code and verify the auto derived block and Street Details (.+),(.+),(.+)$")
    public void InputPostalVerifyBlckStreetDetails(int postal,String blockno, String streetDetails) {

        try {
            contactDetailsPage.inputPostalDetails(postal,blockno,streetDetails);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^User fills in the Letter of Offer Addressee subsection as (.+),(.+),(.+)$")
    public void userFillLetterOfOfferAddresseeSubsectionDetails(String name, String jobTitle, String email) {

        try {
            contactDetailsPage.inputLetterOfAddSubSectionDetails(name,jobTitle,email);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @And("^User clicks on Next button on contact Details$")
    public void userClicksOnNextButtonOnContactDetails() {
        try {
            contactDetailsPage.clickNxtBtnContactDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @And("^User clicks on save button and refresh to verify the details are saved$")
    public void userClicksOnSaveButtonAndRefreshToVerifyTheDetailsAreSaved(DataTable records) throws Exception {
        try {
            for (Map<String,String> data :records.asMaps(String.class,String.class)) {
                contactDetailsPage.clickSaveAndRefreshToVerifyRecords(records);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
