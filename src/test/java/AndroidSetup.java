import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSetup {

    protected AndroidDriver driver;

    protected void prepareAndroidForAppium() throws MalformedURLException {

        final DesiredCapabilities capabilities = new DesiredCapabilities().android();
        capabilities.setCapability("device", "Android");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("fullReset", false);
        //mandatory capabilities
        capabilities.setCapability("deviceName", "a");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
        capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");

        driver = new AndroidDriver(new URL(/*"http://127.0.0.1:4723/wd/hub"*/System.getProperty("androidGridUrl")), capabilities);
    }
}
