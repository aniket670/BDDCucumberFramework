package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends CommonElements {
    public WebDriver driver ;
    Logger logger = LoggerFactory.getLogger(HomePage.class);
    PropLocation file = new PropLocation();
    ReadProperties loc = new ReadProperties(file.location());
    ReadProperties elementloc = new ReadProperties(file.elementlocation());

    // The constructor below instantiate the driver using the PageFactory feature of Page Object Model framework in Selenium
     public HomePage(){
         this.driver = DriverFactory.getInstance().getDriver();
         PageFactory.initElements(driver, this);
     }

    public HomePage clickOptionNewGrant() throws Exception {
        Thread.sleep(6000);
        // Here we will verify if user after login is navigated to Home Page
        WebElement lbl_titleMyGrant = getElementByXpath(elementloc.readProperty("lbl_myGrants"));
        String title = lbl_titleMyGrant.getText();
        if (title.equalsIgnoreCase("MY GRANTS")) {
            log.info("User is on the Home Page");
            // Here we will click on the get new grant link
            WebElement lnkGetNewGrant = getElementByXpath(elementloc.readProperty("lnk_getNewGrant"));
            click(lnkGetNewGrant);
        } else {
            log.error("User could not navigate to Home Page");
            Assert.fail();
        }
        return this;
     }
}

