import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendSMSIOSTest extends iosSetup {
    private static String startNewMessageButton = "//UIAButton[1]";
    private static String fieldTo = "//UIATextField[1]";
    private static String fieldMessage = "//UIATextFieldMessage";
    private static String sendMessageButton = "//UIAButtonSend";
    private static String message = "//UIATextSMS";
    private static String testMessage = "Test message";
    private static String phoneNumber = "+971529961453";

    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        prepareIOSForAppium();
        wait = new WebDriverWait(driver, 20);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void sendNewSMS() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(startNewMessageButton)));
        IOSElement newSMSBtn = (IOSElement) driver.findElement(By.xpath(startNewMessageButton));
        newSMSBtn.click();


        wait.until(ExpectedConditions.elementToBeClickable((By.xpath(fieldTo))));
        IOSElement toField = (IOSElement) driver.findElement(By.xpath(fieldTo));
        toField.sendKeys(phoneNumber);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldMessage)));
        IOSElement messageField = (IOSElement) driver.findElement(By.xpath(fieldMessage));
        messageField.sendKeys(testMessage);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sendMessageButton)));
        IOSElement sendMsgBtn = (IOSElement) driver.findElement(By.xpath(sendMessageButton));
        sendMsgBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(message)));
        IOSElement messageText = (IOSElement) driver.findElement(By.xpath(message));
        messageText.getText();
        Assert.assertEquals(messageText.getText(), testMessage);

    }
}
