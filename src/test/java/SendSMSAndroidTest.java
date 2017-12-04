import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SendSMSAndroidTest extends AndroidSetup {

    private static String startNewMessageButton = "//android.widget.ImageView[@resource-id='com.google.android.apps.messaging:id/start_new_conversation_button']";
    private static String fieldTo = "//android.widget.MultiAutoCompleteTextView[@text='To']";
    private static String fieldMessage = "//android.widget.EditText[@text='Send message']";
    private static String sendMessageButton = "//android.widget.ImageView[@resource-id='com.google.android.apps.messaging:id/self_send_icon']";
    private static String message = "//android.widget.TextView[@resource-id='com.google.android.apps.messaging:id/message_text']";
    private static String testMessage = "Test message";
    private static String phoneNumber = "+971529961453";


    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
        wait = new WebDriverWait(driver, 20);

    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


    @Test
    public void SendNewSMSTest() {

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(startNewMessageButton)));
        AndroidElement newSMSBtn = (AndroidElement) driver.findElement(By.xpath(startNewMessageButton));
        newSMSBtn.click();


        wait.until(ExpectedConditions.elementToBeClickable((By.xpath(fieldTo))));
        AndroidElement toField = (AndroidElement) driver.findElement(By.xpath(fieldTo));
        toField.sendKeys(phoneNumber);
        driver.sendKeyEvent(AndroidKeyCode.KEYCODE_ENTER);


        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(fieldMessage)));
        AndroidElement messageField = (AndroidElement) driver.findElement(By.xpath(fieldMessage));
        messageField.sendKeys(testMessage);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(sendMessageButton)));
        AndroidElement sendMsgBtn = (AndroidElement) driver.findElement(By.xpath(sendMessageButton));
        sendMsgBtn.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(message)));
        AndroidElement messageText = (AndroidElement) driver.findElement(By.xpath(message));
        messageText.getText();
        Assert.assertEquals(messageText.getText(), testMessage);

    }

}

