package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EligiblityCheckPage extends CommonElements {
    public WebDriver driver ;
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    PropLocation file = new PropLocation();
    ReadProperties loc = new ReadProperties(file.location());
    ReadProperties elementloc = new ReadProperties(file.elementlocation());

    // The constructor below instantiate the driver using the PageFactory feature of Page Object Model framework in Selenium
    public  EligiblityCheckPage(){
       this.driver= DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }

    // The Contact Page Elements are defined in the Page Class ContactDetailsPage
    @FindBy(how= How.XPATH , using ="//div[4]//div[1]//div[2]//label[1]//span[1]")
    private WebElement radiobtn_question1_Yes ;

    @FindBy(how= How.XPATH , using ="//div[4]//div[1]//div[2]//label[2]//span[1]")
    private  WebElement radiobtn_question1_No ;

    @FindBy(how= How.XPATH , using ="//div[5]//div[1]//div[2]//label[1]//span[1]")
    private  WebElement radiobtn_question2_Yes;

    @FindBy(how= How.XPATH , using ="//div[5]//div[1]//div[2]//label[2]//span[1]")
    private  WebElement radiobtn_question2_No;

    @FindBy(how= How.XPATH , using ="//div[6]//div[1]//div[2]//label[1]//span[1]")
    private WebElement radiobtn_question3_Yes;

    @FindBy(how= How.XPATH , using ="//div[6]//div[1]//div[2]//label[2]//span[1]")
    private WebElement radiobtn_question3_No;

    @FindBy(how= How.XPATH , using ="//div[7]//div[1]//div[2]//label[1]//span[1]")
    private  WebElement radiobtn_question4_Yes;

    @FindBy(how= How.XPATH , using ="//div[7]//div[1]//div[2]//label[2]//span[1]")
    private  WebElement radiobtn_question4_No;

    @FindBy(how= How.XPATH , using ="//div[8]//div[1]//div[2]//label[1]//span[1]")
    private  WebElement radiobtn_question5_Yes;

    @FindBy(how= How.XPATH , using ="//div[8]//div[1]//div[2]//label[2]//span[1]")
    private  WebElement radiobtn_question5_No;

    @FindBy(how= How.XPATH , using ="//label[contains(text(),\"Is the applicant's group sales turnover less than\")]")
    private  WebElement questionTwo;

    @FindBy(how= How.XPATH , using ="//*[@id=\"next-btn\"]")
    private WebElement btnNxtEligibility;

    public EligiblityCheckPage selectEligbilityCheckOptionQuestionOne(String option) throws Exception {
        try {
            if (option.equalsIgnoreCase("Yes")){
                radiobtn_question1_Yes.click();
            } else {
                radiobtn_question1_No.click();
                Thread.sleep(2000);
                //WebElement lnkFAQ = getElementByXpath(elementloc.readProperty("lnk_faq"));
                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get(loc.readProperty("FAQ"));

                Thread.sleep(8000);
                driver.switchTo().window(tabs.get(0)); // switch back to main screen

            }
        } catch (Exception e) {
            log.error("Error is :" +e.getMessage(),e);
            e.printStackTrace();
        }
        return  this;
    }

    public EligiblityCheckPage selectEligbilityCheckOptionQuestionTwo(String option) throws InterruptedException {

        // Scrolling the page to the height where the question is located
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", questionTwo);
        Actions actions = new Actions(driver);
        actions.moveToElement(questionTwo).perform();

        Thread.sleep(3000);
        try {
            if (option.equalsIgnoreCase("Yes")){
                radiobtn_question2_Yes.click();
            } else {
                radiobtn_question2_No.click();
                Thread.sleep(2000);

                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get(loc.readProperty("FAQ"));
                Thread.sleep(8000);
                driver.switchTo().window(tabs.get(0)); // switch back to main screen
            }
        } catch (InterruptedException e) {
            log.error("Error is :" +e.getMessage(),e);
            e.printStackTrace();
        }
        return  this ;
    }

    public EligiblityCheckPage selectEligbilityCheckOptionQuestionThree(String option) {
        try {
            if (option.equalsIgnoreCase("Yes")){
                radiobtn_question3_Yes.click();
                Thread.sleep(2000);
            } else {
                radiobtn_question3_No.click();
                Thread.sleep(2000);

                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get(loc.readProperty("FAQ"));

                Thread.sleep(8000);
                driver.switchTo().window(tabs.get(0)); // switch back to main screen

            }
        } catch (InterruptedException e) {
            log.error("Error is :" +e.getMessage(),e);
            e.printStackTrace();
        }
        return  this ;
    }


    public EligiblityCheckPage selectEligbilityCheckOptionQuestionFour(String option) {

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        try {
            if (option.equalsIgnoreCase("Yes")){
                radiobtn_question4_Yes.click();
            } else {
                radiobtn_question4_No.click();
                Thread.sleep(2000);

                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get(loc.readProperty("FAQ"));

                Thread.sleep(8000);
                driver.switchTo().window(tabs.get(0)); // switch back to main screen

            }
        } catch (InterruptedException e) {
            log.error("Error is :" +e.getMessage(),e);
            e.printStackTrace();
        }

            return  this;
    }

    public EligiblityCheckPage selectEligbilityCheckOptionQuestionFive(String option) throws InterruptedException {

        try {
            if (option.equalsIgnoreCase("Yes")){
                radiobtn_question5_Yes.click();

            } else {
                radiobtn_question5_No.click();
                Thread.sleep(2000);

                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1)); //switches to new tab
                driver.get(loc.readProperty("FAQ"));

                Thread.sleep(8000);
                driver.switchTo().window(tabs.get(0)); // switch back to main screen

            }
        } catch (ElementNotSelectableException e) {
            log.error("Error is :" +e.getMessage(),e);
            e.printStackTrace();
        }
        return  this;
    }

    public void clickNxteligibility() throws InterruptedException {

        Thread.sleep(3000);
        try {
            if(btnNxtEligibility.isEnabled()){
                click(btnNxtEligibility);
                log.info("User clicked on Next button");
                System.out.println("Eligibility section is filled successfully");
            }
        } catch (Exception e) {
            log.error("The error is :"+e.getMessage(),e);
            e.printStackTrace();

        }

    }
}
