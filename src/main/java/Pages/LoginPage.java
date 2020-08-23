package Pages;

import Implementation.CommonElements;
import Utilities.DriverFactory;
import Utilities.PropLocation;
import Utilities.ReadProperties;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends CommonElements {

      PropLocation file = new PropLocation();
      ReadProperties loc = new ReadProperties(file.location());
      ReadProperties elementloc = new ReadProperties(file.elementlocation());
     Logger logger = (Logger) LoggerFactory.getLogger(LoginPage.class);
      public WebDriver driver;

      public  LoginPage(){
        this.driver = DriverFactory.getInstance().getDriver();
            PageFactory.initElements(driver, this);
      }

      public LoginPage navigateLoginPage() throws InterruptedException {
            System.out.println("Driver is " +driver);
            driver.get(loc.readProperty("WebUrl"));
            Thread.sleep(5000);
            driver.manage().window().maximize();
            return this;
      }

      public LoginPage loginApplication() throws Exception {

           //User clicks on login button on the home page
           WebElement btnLogin = getElementByXpath(elementloc.readProperty("btnLogin"));
          try {
              click(btnLogin);
          } catch (Exception e) {
              e.printStackTrace();
              Assert.fail();
          }
          //verifying User is navigated to the Login page by locating the page title
            WebElement loginPageTitle = getElementByXpath(elementloc.readProperty("loginPageTitle"));
            if (isElementDisplayed(loginPageTitle)){
                  log.info("User is navigated to login page");
                 WebElement txt_NRIC = getElementByXpath(elementloc.readProperty("txt_NRIC"));
                 //setText(txt_NRIC,loc.readProperty("Username"));
                 txt_NRIC.clear();
                 String nric = loc.readProperty("Username");
                 txt_NRIC.sendKeys(nric);

                  WebElement txt_Name = getElementByXpath(elementloc.readProperty("txt_Name"));
                 // setText(txt_Name, loc.readProperty("Name"));
                txt_Name.clear();
                txt_Name.sendKeys(loc.readProperty("Name"));

                  WebElement txt_UEN = getElementByXpath(elementloc.readProperty("txt_UEN"));
                  //setText(txt_UEN, loc.readProperty("UEN"));
                txt_UEN.clear();
                    txt_UEN.sendKeys(loc.readProperty("UEN"));

                  Select role = new Select(getElementByXpath(elementloc.readProperty("sel_CPRole")));
                  role.selectByVisibleText(loc.readProperty("Role"));

                  WebElement btnLoginUser = getElementByXpath(elementloc.readProperty("btn_login"));
                  click(btnLoginUser);
                  }else {
                  log.error("User is not navigated to login page for technical reasons");
                Assert.fail();
            }
      return this;
      }
}
