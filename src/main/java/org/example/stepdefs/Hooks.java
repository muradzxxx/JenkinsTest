package org.example.stepdefs;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.example.models.Capability;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {

    public static WebDriver driver;


    public static Capability capability ;

    @Before
    public void openBrowser() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

//       Capability capabilities =  mapper.readValue(new File("src/test/resources/capabilities.json"), Capability.class);
//        System.out.println(capabilities);

        JsonNode rootNode = mapper.readTree(new File("src/test/resources/capabilities.json"));
        capability = Capability.builder().platformName(rootNode.get("platformName").asText()).build();


        if(capability.getPlatformName().equalsIgnoreCase("web")) {

            initializeWebDriver();

        }

//        if (rootNode.get("platformName").asText().toLowerCase().equals("android")) {
//            capability = Capability.builder().platformName(rootNode.get("platformName").asText()).noReset(rootNode.has("noReset") ? rootNode.get("noReset").asBoolean() : false).fullReset(rootNode.has("fullReset") ? rootNode.get("fullReset").asBoolean() : true).unicodeKeyboard(rootNode.has("unicodeKeyboard") ? rootNode.get("unicodeKeyboard").asBoolean() : false).resetKeyboard(rootNode.has("resetKeyboard") ? rootNode.get("resetKeyboard").asBoolean() : false).appPackage(rootNode.has("appPackage") ? rootNode.get("appPackage").asText() : null).appActivity(rootNode.has("appActivity") ? rootNode.get("appActivity").asText() : "*").newCommandTimeout(rootNode.has("newCommandTimeout") ? rootNode.get("newCommandTimeout").asInt() : 600).app(isLocal ? CapabilityFinder.findAppPath(rootNode.get("platformName").asText().toLowerCase()) : null).deviceName(isLocal ? (rootNode.has("deviceName") ? rootNode.get("deviceName").asText() : (String)CapabilityFinder.searchForAndroidDevices().get("name")) : null).automationName(rootNode.has("automationName") ? rootNode.get("automationName").asText() : "Appium").capCloudTakeSS(rootNode.has("capCloudTakeSS") ? rootNode.get("capCloudTakeSS").asText() : "only_failure").capCloudRecordVideo(rootNode.has("capCloudRecordVideo") ? rootNode.get("capCloudRecordVideo").asBoolean() : true).sendKeyStrategy(rootNode.has("sendKeyStrategy") ? rootNode.get("sendKeyStrategy").asText() : "setValue").localUrl(rootNode.has("localUrl") ? new URL(rootNode.get("localUrl").asText()) : new URL("http://127.0.0.1:4723/wd/hub")).hubUrl(rootNode.has("hubUrl") ? new URL(rootNode.get("hubUrl").asText()) : new URL("http://hub.testinium.io/wd/hub")).waitForAppScript(rootNode.has("waitForAppScript") ? rootNode.get("waitForAppScript").asInt() : 1000).usePrebuiltWda(rootNode.has("usePrebuiltWda") ? rootNode.get("usePrebuiltWda").asBoolean() : true).useNewWda(rootNode.has("useNewWda") ? rootNode.get("useNewWda").asBoolean() : true).build();
//        } else if (rootNode.get("platformName").asText().toLowerCase().equals("ios")) {
//            capability = Capability.builder().platformName(rootNode.get("platformName").asText()).noReset(rootNode.has("noReset") ? rootNode.get("noReset").asBoolean() : false).fullReset(rootNode.has("fullReset") ? rootNode.get("fullReset").asBoolean() : true).unicodeKeyboard(rootNode.has("unicodeKeyboard") ? rootNode.get("unicodeKeyboard").asBoolean() : false).resetKeyboard(rootNode.has("resetKeyboard") ? rootNode.get("resetKeyboard").asBoolean() : false).appPackage(rootNode.has("appPackage") ? rootNode.get("appPackage").asText() : null).appActivity(rootNode.has("appActivity") ? rootNode.get("appActivity").asText() : "*").newCommandTimeout(rootNode.has("newCommandTimeout") ? rootNode.get("newCommandTimeout").asInt() : 600).app(isLocal ? CapabilityFinder.findAppPath(rootNode.get("platformName").asText().toLowerCase()) : null).deviceName(isLocal ? (rootNode.has("deviceName") ? rootNode.get("deviceName").asText() : (String)CapabilityFinder.searchForIOSDevices().get("name")) : null).automationName(rootNode.has("automationName") ? rootNode.get("automationName").asText() : "Appium").capCloudTakeSS(rootNode.has("capCloudTakeSS") ? rootNode.get("capCloudTakeSS").asText() : "only_failure").capCloudRecordVideo(rootNode.has("capCloudRecordVideo") ? rootNode.get("capCloudRecordVideo").asBoolean() : true).platformVersion(isLocal ? (rootNode.has("platformVersion") ? rootNode.get("platformVersion").asText() : (String)CapabilityFinder.searchForIOSDevices().get("platform")) : null).UDID(isLocal ? (rootNode.has("UDID") ? rootNode.get("UDID").asText() : (String)CapabilityFinder.searchForIOSDevices().get("udid")) : null).sendKeyStrategy(rootNode.has("sendKeyStrategy") ? rootNode.get("sendKeyStrategy").asText() : "setValue").localUrl(rootNode.has("localUrl") ? new URL(rootNode.get("localUrl").asText()) : new URL("http://127.0.0.1:4723/wd/hub")).hubUrl(rootNode.has("hubUrl") ? new URL(rootNode.get("hubUrl").asText()) : new URL("http://hub.testinium.io/wd/hub")).waitForAppScript(rootNode.has("waitForAppScript") ? rootNode.get("waitForAppScript").asInt() : 1000).usePrebuiltWda(rootNode.has("usePrebuiltWda") ? rootNode.get("usePrebuiltWda").asBoolean() : true).useNewWda(rootNode.has("useNewWda") ? rootNode.get("useNewWda").asBoolean() : true).build();
//        } else {
//            capability = Capability.builder().platformName(rootNode.get("platformName").asText()).unicodeKeyboard(rootNode.has("unicodeKeyboard") ? rootNode.get("unicodeKeyboard").asBoolean() : false).newCommandTimeout(rootNode.has("newCommandTimeout") ? rootNode.get("newCommandTimeout").asInt() : 600).browser(rootNode.has("browser") ? rootNode.get("browser").asText() : null).automationName(rootNode.has("automationName") ? rootNode.get("automationName").asText() : "Appium").capCloudTakeSS(rootNode.has("capCloudTakeSS") ? rootNode.get("capCloudTakeSS").asText() : "only_failure").capCloudRecordVideo(rootNode.has("capCloudRecordVideo") ? rootNode.get("capCloudRecordVideo").asBoolean() : true).sendKeyStrategy(rootNode.has("sendKeyStrategy") ? rootNode.get("sendKeyStrategy").asText() : "setValue").waitForAppScript(rootNode.has("waitForAppScript") ? rootNode.get("waitForAppScript").asInt() : 1000).usePrebuiltWda(rootNode.has("usePrebuiltWda") ? rootNode.get("usePrebuiltWda").asBoolean() : true).useNewWda(rootNode.has("useNewWda") ? rootNode.get("useNewWda").asBoolean() : true).build();
//        }
//    } catch (
//    IOException var4) {
//        var4.printStackTrace();
//    }

    }

    private void initializeWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--window-size=1024,768");

        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://demowebshop.tricentis.com/");

    }

}
