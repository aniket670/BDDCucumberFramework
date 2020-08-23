package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class ProposalSubmitPage extends CommonElements {
    public WebDriver driver ;
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    PropLocation file = new PropLocation();
    ReadProperties loc = new ReadProperties(file.location());
    ReadProperties elementloc = new ReadProperties(file.elementlocation());
    public  ProposalSubmitPage(){

         this.driver=DriverFactory.getInstance().getDriver();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.XPATH, using ="//h2[contains(text(),'Submit Your Proposal')]")
    private WebElement titleProposalPage;

    @FindBy(how = How.XPATH, using ="//*[@id=\"react-project-title\"]")
    private  WebElement txt_projectTitle;

    @FindBy(how = How.XPATH, using ="//*[@id=\"react-project-start_date\"]")
    private  WebElement input_startDate;

    @FindBy(how = How.XPATH, using ="//*[@id=\"react-project-end_date\"]")
    private WebElement input_EndDate;

    @FindBy(how = How.XPATH, using ="//div[@class='bgp-readonly']")
    private WebElement projectDuration ;

    @FindBy(how = How.XPATH, using ="//*[@id=\"react-project-description\"]")
    private WebElement input_projectDescription ;

    @FindBy(how = How.CSS, using ="div.base-container:nth-child(3) div._2nhBPjgwBzEAq_Q4AkjQz9 div._2fwYxZEoTAa2o7rHUPuhRo div._1lL64NI9hS4wNQ_IwC0kEf div.main div.margin-top-lg:nth-child(10) div.form-horizontal div.form-group div.col-sm-6:nth-child(2) div.Select.Select--single.is-searchable > div.Select-control")
    private WebElement selectActivity ;

    @FindBy(how = How.XPATH, using ="//span[@id='react-select-project-primary_market--value']//div[@class='Select-placeholder'][contains(text(),'Select...')]")
    private WebElement selectTargetMarket ;

    @FindBy(how = How.XPATH, using ="//*[@class=\"bgp-radio\"]")
    private WebElement radiobtn_optionTargetMarket ;

    @FindBy(how = How.XPATH, using ="//*[@class=\"bgp-radio\"]")
    private WebElement btn_selectFile ;

    public ProposalSubmitPage verifyProposalTitle(String title) throws InterruptedException {
        Thread.sleep(3000);
        if(titleProposalPage.getAttribute("value").equalsIgnoreCase(title)){
            log.info("User is navigated to Proposal Page Details");
        } else {
            log.error("User could not navigate to proposal page");
            Assert.fail();
        }
     return this;
    }

    public ProposalSubmitPage inputProposalDetails(String title, String startDate, String endDate, String proDesc) {

       if (txt_projectTitle.isDisplayed()){
            if (txt_projectTitle.isEnabled()) {
                txt_projectTitle.sendKeys(title);
            } else {
                log.error("User cannot input Title");
                Assert.fail();
            }
        } else {
            log.error("The Title input is not on proposal page");
            Assert.fail();
        }

        if (input_startDate.isDisplayed()){
            if (input_startDate.isEnabled()) {
                input_startDate.sendKeys(startDate);
            } else {
                log.error("User cannot input Start Date");
                Assert.fail();
            }
        } else {
            log.error("The Start Date input is not on proposal page");
            Assert.fail();
        }

        if (input_EndDate.isDisplayed()){
            if (input_EndDate.isEnabled()) {
                input_EndDate.sendKeys(endDate);
            } else {
                log.error("User cannot input End Date");
                Assert.fail();
            }
        } else {
            log.error("The End Date input is not on proposal page");
            Assert.fail();
        }

        if (input_projectDescription.isDisplayed()){
            if (input_projectDescription.isEnabled()) {
                input_projectDescription.sendKeys(proDesc);
            } else {
                log.error("User cannot project Description");
                Assert.fail();
            }
        } else {
            log.error("The Project Description input is not on proposal page");
            Assert.fail();
        }
     return  this ;

    }
    public ProposalSubmitPage verifyProjectDuration() throws ParseException {

        Date date1 = new SimpleDateFormat("MM dd, yyyy").parse(input_startDate.getText()) ;
        Date date2 = new SimpleDateFormat("MM dd, yyyy").parse(input_EndDate.getText());

        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate12 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Period period = Period.between(localDate1,localDate12);

        if (String.valueOf(period.getMonths()).equalsIgnoreCase(projectDuration.getText()) ){
            log.info("The Month Duration is verified successfully");
        } else {
            log.error("The month duration is not as expected");
            Assert.fail();
        }
     return  this;

    }

    public ProposalSubmitPage selectActivityTarget(String activity, String tarMarket) {


        return  this;

    }

    public ProposalSubmitPage selectOptionMarketExpand(String expansOption) {

     return  this;

    }

    public ProposalSubmitPage performFileUpload() {

     return  this;

    }

    public ProposalSubmitPage inputRemarksClickSave(String remarks) {

     return  this;

    }
}
