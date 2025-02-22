package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.Set;

public class ShopifyAppsPage {
    WebDriver driver;

    public ShopifyAppsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[normalize-space()='Get started for free']")
    WebElement GetStartBtn_Loc;
    @FindBy(xpath = "//button[normalize-space()='Open store free']")
    WebElement OpenstoreBtn_loc;

    public void ClickGetStartBtn()  {
        String oldWindow = driver.getWindowHandle();
        GetStartBtn_Loc.click();
        Set<String> Handles = driver.getWindowHandles();
        for (String newWindow:Handles){
            driver.switchTo().window(newWindow);

        }
        driver.close();
        driver.switchTo().window(oldWindow);
    }
    public void ClickOpenStoreBtn() {
        String oldWindow = driver.getWindowHandle();
        OpenstoreBtn_loc.click();
        Set<String> Handles = driver.getWindowHandles();
        for (String newWindow:Handles){
            driver.switchTo().window(newWindow);
        }
        driver.close();
        driver.switchTo().window(oldWindow);


    }


    }



