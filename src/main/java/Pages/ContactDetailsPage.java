package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ContactDetailsPage extends CommonElements {

    public WebDriver driver;
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    PropLocation file = new PropLocation();
    ReadProperties loc = new ReadProperties(file.location());
    ReadProperties elementloc = new ReadProperties(file.elementlocation());

    // The constructor below instantiate the driver using the PageFactory feature of Page Object Model framework in Selenium
    public ContactDetailsPage() {
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }

    // The Contact Page Elements are defined in the Page Class ContactDetailsPage
    @FindBy(how = How.XPATH, using = "//*[@id=\"react-contact_info-name\"]")
    private WebElement txt_Name;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-designation\"]")
    private WebElement txt_JobTitle;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-phone\"]")
    private WebElement txt_Contact;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-primary_email\"]")
    private WebElement txt_EmailAddress;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-secondary_email\"]")
    private WebElement txt_AlternateEmailAddress;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-copied\"]")
    private WebElement chkbox_MailingAdress;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-postal\"]")
    private WebElement txt_PostalCode;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-block\"]")
    private WebElement txt_BlockNo;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-street\"]")
    private WebElement txt_StreetName;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-level\"]")
    private WebElement txt_level;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-unit\"]")
    private WebElement txt_unit;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-correspondence_address-building_name\"]")
    private WebElement txt_BldgName;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-copied\"]")
    private WebElement chkbox_SameContact;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-offeree_name\"]")
    private WebElement txt_CopiedName;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-offeree_designation\"]")
    private WebElement txt_CopiedJobTitle;

    @FindBy(how = How.XPATH, using = "//*[@id =\"react-contact_info-offeree_email\"]")
    private WebElement txt_CopiedEmailAddress;

    @FindBy(how = How.XPATH, using = "//*[@id =\"save-btn\"]")
    private WebElement btn_Save;

    @FindBy(how = How.XPATH, using = "//*[@id =\"next-btn\"]")
    private WebElement btn_Next;


    public ContactDetailsPage inputContactDetails(String name, String jobTitle, int contct, String email, String secondEmail) throws InterruptedException {
        Thread.sleep(3000);
        // Entering the Name in the form
        try {
            if (txt_Name.isDisplayed()) {
                log.info("User fills in the Name");
                txt_Name.sendKeys(name);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        // Entering the Job Title in the form
        try {
            if (txt_JobTitle.isDisplayed()) {
                log.info("User fills in the Job Title");
                txt_JobTitle.sendKeys(jobTitle);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }
        Thread.sleep(2000);

        //Scrolling down near to the field to enter
        Actions actions = new Actions(driver);
        actions.moveToElement(txt_Contact).perform();

        // Entering the Contact in the form
        try {
            if (txt_Contact.isDisplayed()) {
                log.info("User fills in the Contact");
                txt_Contact.sendKeys(String.valueOf(contct));
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        // Entering the Primary Email Address in the form
        try {
            if (txt_EmailAddress.isDisplayed()) {
                log.info("User fills in the Primary Email Address");
                txt_EmailAddress.sendKeys(email);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        // Entering the Secondary Email Address in the form
        try {
            if (txt_AlternateEmailAddress.isDisplayed()) {
                log.info("User fills in the Secondary Email Address");
                txt_AlternateEmailAddress.sendKeys(secondEmail);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }
        return this;
    }

    public ContactDetailsPage selectCheckboxForAddress() throws InterruptedException {
        try {
            // Verifying the Checkbox mailing address is available for checking
            if (chkbox_MailingAdress.isEnabled()) {
                if (!chkbox_MailingAdress.isSelected()) {
                    log.info("User selecting the checkbox");
                    chkbox_MailingAdress.click();
                } else {
                    log.info("The checkbox is selected");
                }
            }
        } catch (NoSuchElementException ne) {
            log.error("The checkbox is not available for checking");
            Assert.fail();
        }
        Actions actions = new Actions(driver);
        actions.moveToElement(txt_PostalCode).perform();

        Thread.sleep(2000);
        // After checking the checkbox have to verify the address is defaulted to expectd value

        try {
            if (txt_PostalCode.getAttribute("value").equalsIgnoreCase(loc.readProperty("PostalCode"))) {
                log.info("The expected and actual Postal code are correct");
            } else {
                log.error("The expected and actual Postal code are incorrect");
                Assert.fail();
            }

            if (txt_BlockNo.getAttribute("value").equalsIgnoreCase(loc.readProperty("BlockNo"))) {
                log.info("The expected and actual Block No are correct :");
            } else {
                log.error("The expected and actual Block No is incorrect");
                Assert.fail();
            }

            if (txt_StreetName.getAttribute("value").equalsIgnoreCase(loc.readProperty("Street"))) {
                log.info("The expected and actual Street Name are correct :");
            } else {
                log.error("The expected and actual Street Name are incorrect");
                Assert.fail();
            }

            if (txt_level.getAttribute("value").equalsIgnoreCase(loc.readProperty("Level"))) {
                log.info("The expected and actual level are correct :");
            } else {
                log.error("The expected and actual level are incorrect");
                Assert.fail();
            }

            if (txt_unit.getAttribute("value").equalsIgnoreCase(loc.readProperty("Unit"))) {
                log.info("The expected and actual unit no. are correct :");
            } else {
                log.error("The expected and actual unit no. are incorrect");
                Assert.fail();
            }
            System.out.println("The default address is verified successfully on selecting the checkbox");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
        return this;
    }

    public ContactDetailsPage selectCheckboxForAddSameAsMainPerson() throws InterruptedException {

        try {
            // Verifying the Checkbox mailing address is available for checking
            if (chkbox_SameContact.isEnabled()) {
                if (!chkbox_SameContact.isSelected()) {
                    log.info("User selecting the checkbox");
                    chkbox_SameContact.click();
                } else {
                    log.info("The checkbox is already selected");
                }
            }
        } catch (NoSuchElementException ne) {
            log.error("The checkbox is not available for checking");
            Assert.fail();
        }

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();

        Thread.sleep(2000);
        // After checking the checkbox have to verify the address is defaulted to expectd value

        try {
            if (txt_CopiedName.getAttribute("value").equalsIgnoreCase(txt_Name.getAttribute("value"))) {
                log.info("The expected and actual Name are correct");
            } else {
                log.error("The expected and actual Name are incorrect");
                Assert.fail();
            }

            if (txt_CopiedJobTitle.getAttribute("value").trim().equalsIgnoreCase(txt_JobTitle.getAttribute("value").trim())) {
                log.info("The expected and Job Title are correct");
            } else {
                log.error("The expected and Job Title are incorrect");
                Assert.fail();
            }

            if (txt_CopiedEmailAddress.getAttribute("value").equalsIgnoreCase(txt_EmailAddress.getAttribute("value"))) {
                log.info("The expected and Email Address are correct");
            } else {
                log.error("The expected and Email Address are incorrect");
                Assert.fail();
            }

            System.out.println("The default contact details are verified on selecting checkbox");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Error encountered" + e.getMessage(), e);

        }
        return this;
    }

    public ContactDetailsPage inputPostalDetails(int postal, String blockno, String streetDetails) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(chkbox_SameContact).perform();

        try {
            if (txt_PostalCode.isDisplayed()) {
                log.info("User is giving the postal Details");
                txt_PostalCode.sendKeys(String.valueOf(postal));

                Thread.sleep(3000);

                //The Google API derives the corresponding Block No and Street Details based on postal code
                if (txt_BlockNo.getAttribute("value").equalsIgnoreCase(blockno)) {
                    log.info("The Derived Block No is as expected");
                } else {
                    log.error("The expected and Email Address are incorrect");
                    Assert.fail();
                }

                if (txt_StreetName.getAttribute("value").equalsIgnoreCase(streetDetails)) {
                    log.info("The Derived Street Details are as expected");
                } else {
                    log.error("The expected and actual street details are incorrect");
                    Assert.fail();
                }
                System.out.println("The Postal Code derived correct details for Block and Street");
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured:" + ne.getMessage(), ne);
            ne.printStackTrace();
            Assert.fail();
        }
        return this;
    }

    public ContactDetailsPage inputLetterOfAddSubSectionDetails(String sname, String jobTitle, String email) throws InterruptedException {

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();

        try {
            if (txt_CopiedName.isDisplayed()) {
                log.info("User fills subsection  Name");
                txt_CopiedName.sendKeys(sname);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        try {
            if (txt_CopiedJobTitle.isDisplayed()) {
                log.info("User fills subsection  JobTitle");
                txt_CopiedJobTitle.sendKeys(jobTitle);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        try {
            if (txt_CopiedEmailAddress.isDisplayed()) {
                log.info("User fills subsection  JobTitle");
                txt_CopiedEmailAddress.sendKeys(email);
            }
        } catch (NoSuchElementException ne) {
            log.error("The error occured :" + ne.getMessage());
            ne.printStackTrace();
            Assert.fail();
        }

        return this;
    }

    public ContactDetailsPage clickNxtBtnContactDetails() throws Exception {

        Thread.sleep(2000);
        try {
            click(btn_Next);
        } catch (NoSuchElementException ne) {
            ne.printStackTrace();
            Assert.fail();
            log.error("The button ws not clickable");
        }
        return this;
    }

    public ContactDetailsPage clickSaveAndRefreshToVerifyRecords(DataTable dt) throws Exception {

        // Here we are saving the details and also verifying the details are saved succesfully.
        //For that we are verifying the details against given input using Cucumber Datatables

        List<Map<String, String>> list = dt.asMaps(String.class, String.class);
        click(btn_Save);

        Thread.sleep(3000);

        // We observed an unexpected javascript alert popping so to handle that.
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.alert = function () { return true}");
        driver.navigate().refresh();

        String name = list.get(0).get("Name");
        String jobtitle = list.get(0).get("Designation");
        String contact = list.get(0).get("Contact");
        String emailadrress = list.get(0).get("EmailAdress");
        String alternateEmailAddress = list.get(0).get("AlternateEmailAdress");
        String postalCode = list.get(0).get("Postal");
        String blockNo = list.get(0).get("BlockNo");
        String streetDetails = list.get(0).get("StreetDetails");

        try {
            if (name.equalsIgnoreCase(txt_Name.getAttribute("value"))) {
                log.info("The Name details are saved successfully.");
            } else {
                log.error("The Name details are not saved correctly");
                Assert.fail();
            }

            if (jobtitle.equalsIgnoreCase(txt_JobTitle.getAttribute("value"))) {
                log.info("The Job Title details are saved successfully.");
            } else {
                log.error("The Job Title details are not saved correctly");
                Assert.fail();
            }

            if (contact.equalsIgnoreCase(txt_Contact.getAttribute("value"))) {
                log.info("The contact details are saved successfully.");
            } else {
                log.error("The contact details are not saved correctly");
                Assert.fail();
            }

            if (emailadrress.equalsIgnoreCase(txt_EmailAddress.getAttribute("value"))) {
                log.info("The primary email details are saved successfully.");
            } else {
                log.error("The  primary email details are not saved correctly");
                Assert.fail();
            }

            if (alternateEmailAddress.equalsIgnoreCase(txt_AlternateEmailAddress.getAttribute("value"))) {
                log.info("The alternate email details are saved successfully.");
            } else {
                log.error("The alternate email address are not saved correctly");
                Assert.fail();
            }

            if (postalCode.equalsIgnoreCase(txt_PostalCode.getAttribute("value"))) {
                log.info("The postal code details are saved successfully.");
            } else {
                log.error("The postal code details are not saved correctly");
                Assert.fail();
            }

            if (blockNo.equalsIgnoreCase(txt_BlockNo.getAttribute("value"))) {
                log.info("The block No. details are saved successfully.");
            } else {
                log.error("The block No. details are not saved correctly");
                Assert.fail();
            }

            if (streetDetails.equalsIgnoreCase(txt_StreetName.getAttribute("value"))) {
                log.info("The Street details are saved successfully.");
            } else {
                log.error("The Street details are not saved correctly");
                Assert.fail();
            }

            // We can similarly verify other fields as well as we have append the datatable with remaining fields
            System.out.println("The Contact Details are saved successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }
}
