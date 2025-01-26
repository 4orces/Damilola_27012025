import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AlartTest {

    public AndroidDriver driver;

    @BeforeTest
    public void setup() throws MalformedURLException, InterruptedException {
        String appiumServerUrl = "http://127.0.0.1:4723";

        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName", "Android");
        dc.setCapability("appium:automationName", "uiautomator2");
        dc.setCapability("appium:app", System.getProperty("user.dir") + "\\app\\QAtestbuild22ndJan.apk");

        driver = new AndroidDriver(new URL(appiumServerUrl), dc);
        Thread.sleep(5000);
    }

    @Test
    public void getstarted() throws InterruptedException {
        //click get started
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/gettingStartedBtn")).click();
        Thread.sleep(5000);
        //select sign up as an affliate
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(4)")).click();
        Thread.sleep(5000);
        //click continue button
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/continueButton")).click();
        Thread.sleep(5000);

    }
    @Test(priority = 1)
    public void createaffiliateaccunt() throws InterruptedException {
        //click choose affiliate
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/item")).click();
        Thread.sleep(5000);
        //select WEMA
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WEMA\")")).click();
        Thread.sleep(5000);
        //input valid First Name
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/firstNameEditText")).sendKeys("Damilola");
        Thread.sleep(5000);
        //input valid Last Name
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/lastNameEditText")).sendKeys("Kadri");
        Thread.sleep(5000);
        //input valid email address
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/emailAddressEditText")).sendKeys("user@test1.com");
        Thread.sleep(5000);
        //input valid password
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/passwordTextInputEditText")).sendKeys("Password1.");
        Thread.sleep(5000);
        //re-enter password
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/repasswordTextInputEditText")).sendKeys("Password1.");
        Thread.sleep(5000);
        //click sign up
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/signUpButton")).click();
        Thread.sleep(5000);
        //switch to popup frame
        driver.switchTo().alert();
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/status_btn_text")).click();
        System.out.println("Onboarding Successful"); //print out success message to indicate successful registration
        Thread.sleep(5000);
        //click back arrow to nagivate to previous page
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(5000);
        //click sign up as an affiliate to deselect the previous selection
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(4)")).click();
        Thread.sleep(5000);
        //click sign up as an affiliate
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.LinearLayout\").instance(4)")).click();
        Thread.sleep(5000);
        //click continue button
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/continueButton")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 2)
    public void usercannotcreateaccountwithexistinginfo() throws InterruptedException {
        //click choose affiliate
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/item")).click();
        Thread.sleep(5000);
        //from the dropdown select WEMA
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"WEMA\")")).click();
        Thread.sleep(5000);
        //input valid firstname
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/firstNameEditText")).sendKeys("Damilola");
        Thread.sleep(5000);
        //input valid lastname
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/lastNameEditText")).sendKeys("Kadri");
        Thread.sleep(5000);
        //input valid email
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/emailAddressEditText")).sendKeys("test@user1.com");
        Thread.sleep(5000);
        //input valid password
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/passwordTextInputEditText")).sendKeys("Password1.");
        Thread.sleep(5000);
        //re-enter the password
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/repasswordTextInputEditText")).sendKeys("Password1.");
        Thread.sleep(5000);
        //click sign up
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/signUpButton")).click();
        Thread.sleep(5000);
        //switch to the popup frame
        driver.switchTo().alert();
        //select the test within the frame
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/status_text")).isDisplayed();
        Thread.sleep(2000);
        //click on the done button to go out of the popup frame
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/status_btn_text")).click();
        System.out.println("User cannot register with existing information"); //printout the information to indicate that user cannot register with existing information
        Thread.sleep(2000);
        //click the back arrow to nagivate to the previous page
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(5000);
        //click the back arrow to navigate to the previous page
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        Thread.sleep(2000);

    }
    @Test(priority = 3)
    public void login_success() throws InterruptedException {
        //click on the login button
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/loginBtn")).click();
        Thread.sleep(5000);
        //input valid email address into the text box
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/email_input")).sendKeys("user@test1.com");
        Thread.sleep(5000);
        //input valid email address
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/password_input")).sendKeys("Password1.");
        Thread.sleep(5000);
        //click on the login button
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/loginBtn")).click();
        Thread.sleep(5000);
        //switch to the alert popup frame
        driver.switchTo().alert();
        //click the text in the frame to confirm the login status
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/status_text")).isDisplayed();
        Thread.sleep(2000);
        //click on the done button to exit the alert frame
        driver.findElement(AppiumBy.id("com.wemabank.alat.office.alat_qa_test:id/status_btn_text")).click();
        System.out.println("Login Successful"); //print out the success message

    }


    @AfterTest
    public void close(){
        //quit the app
        driver.quit();
    }
}