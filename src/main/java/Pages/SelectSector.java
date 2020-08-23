package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class SelectSector extends CommonElements {

    public WebDriver driver ;
    Logger logger = LoggerFactory.getLogger(SelectSector.class);
    PropLocation file = new PropLocation();
    ReadProperties loc = new ReadProperties(file.location());
    ReadProperties elementloc = new ReadProperties(file.elementlocation());

    // The constructor below instantiate the driver using the PageFactory feature of Page Object Model framework in Selenium
    public SelectSector(){
        this.driver = DriverFactory.getInstance().getDriver();
        PageFactory.initElements(driver, this);
    }
    public SelectSector selectSectorName(String sector) throws Exception {

        // Here we will aso verify user cannot proceeed to next step without selecting sector
        Thread.sleep(7000);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebElement btnNxt =  getElementByXpath(elementloc.readProperty("btnn_nxtSector"));
        if (!btnNxt.isEnabled()){
            log.info("User cannot click on Next button as the sector is not selected");

                List<WebElement> links = driver.findElements(By.xpath("//*[@class=\"itemname\"]"));
                System.out.println("Size of the list is:"+ links.size());
                for (WebElement opt:links){
                    if (opt.getText().equalsIgnoreCase(sector)){
                        click(opt);
                     }
                }

        } else {
           Assert.fail("The next button is enabled without selecting sector");
        }
     return this;
    }

    public SelectSector verifyUserNavigationToSelectGrantType(int option) throws Exception {
        Thread.sleep(5000);
        WebElement title_iNeedGrant = getElementByXpath(elementloc.readProperty("title_iNeedGrant"));

        if (title_iNeedGrant.getText().equalsIgnoreCase("I need this grant to")){
            log.info("User is on select Grant Type Page");
            List<WebElement> grantType = getElementsByXpath(elementloc.readProperty("sel_sector"));

            boolean click = false;
            for(int i=1;i<=grantType.size(); i++){
                if (option == i) {
                    grantType.get(i - 1).click();
                    click = true;
                }
            }
             if(!click)
                Assert.fail("Could not click the given option");
            }
        return this ;
    }

    public SelectSector selectDevlopArea(int option) throws Exception {
        Thread.sleep(5000);
            log.info("User is on select Development Type Page");
        try {
            List<WebElement> developType = getElementsByXpath(elementloc.readProperty("sel_devlopType"));
            for(int i=1;i<=developType.size(); i++){
                if (option == i )
                    developType.get(i-1).click();
            }
            WebElement btnApply = getElementByXpath(elementloc.readProperty("btn_apply"));
            click(btnApply);

        } catch (NoSuchElementException ne) {
            log.error("could find the option to select is :" +ne.getMessage(),ne);
            ne.printStackTrace();
        }
        return this;
    }

    public SelectSector applyGrant(int option) throws Exception {
        Thread.sleep(4000);
        log.info("User is on select Apply grant Page");
        try {
            List<WebElement> applyGrantType = getElementsByXpath(elementloc.readProperty("lnk_reasonOverseaPlan"));
            for(int i=1;i<=applyGrantType.size(); i++){
                if (option == i)
                    applyGrantType.get(i-1).click();
            }
        } catch (NoSuchElementException ne) {
            log.error(ne.getMessage(),ne);
            ne.printStackTrace();
        }
        try {
            Thread.sleep(4000);
            WebElement btnApply = getElementByXpath(elementloc.readProperty("btn_apply"));
            click(btnApply);
        } catch (NoSuchElementException ne) {
            log.error(ne.getMessage(),ne);
            ne.printStackTrace();
        }
        return  this;
    }

    public SelectSector scrollAndClicksProceed() throws Exception {
        Wait wait = new WebDriverWait(driver,5);
       // WebElement lblMyGrants = getElementByXpath(elementloc.readProperty("lbl_grantActions"));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"js-app\"]/div/div[2]/div/div/div/div[1]")));

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

        Thread.sleep(4000);
        WebElement btnProceed = getElementByXpath(elementloc.readProperty("btn_proceed"));
        if(btnProceed.isDisplayed()){
            try {
                click(btnProceed);
                log.info("User is navigated to Application");
            } catch (ElementClickInterceptedException e) {
                e.printStackTrace();
            }
        } else {
            log.error("The proceed button is not present");
            Assert.fail();
        }
     return this;
    }

    public SelectSector userCheckDefaultOnEligibilityCheck() throws Exception {

        WebElement CheckYourEligiblity = getElementByXpath(elementloc.readProperty("title_chkYourEligibty"));
        if(CheckYourEligiblity.isDisplayed()){
            log.info("User is on Elgibility Check section by");
        } else {
            log.error("The title is not present and user is not on eligibility section");
            Assert.fail();
        }
     return  this;
    }
}
