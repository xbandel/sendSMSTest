import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class iosSetup {

    protected IOSDriver driver;

    protected void prepareIOSForAppium() throws MalformedURLException {

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        //mandatory capabilities
        capabilities.setCapability("deviceName", "iPhone 6");
        capabilities.setCapability("platformName", "11.1.2");
        capabilities.setCapability("deviceOrientation", "portrait");

        capabilities.setCapability("app", "SMSapp");

        driver = new IOSDriver(new URL(/*"http://127.0.0.1:4725/wd/hub"*/System.getProperty("iosGridUrl")), capabilities);


    }
}
