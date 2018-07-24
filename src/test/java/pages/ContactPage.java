package pages;


import glue.steps.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class ContactPage extends Browser {

    public void verifyButtons() {


        WebElement verifyContactTitle = driver.findElement(By.cssSelector("#page-title > span"));
        boolean isDisp = verifyContactTitle.isDisplayed();

        Assert.assertTrue(isDisp);

    }

    public void clickOnContacts() {

        WebElement clickOnContact = driver.findElement(By.cssSelector("#menu-item-2868 > a"));
        clickOnContact.click();
    }
public void clickOnPartners() {
    WebElement clickOnPartner = driver.findElement(By.cssSelector("#menu-item-8581 > a"));
    clickOnPartner.click();
}
public void verifyPartnersTitleIsDisplayed() {
        WebElement verifyPartnersTitleIsDisplayed = driver.findElement(By.cssSelector("#page-title > span"));
        boolean contDislp = verifyPartnersTitleIsDisplayed.isDisplayed();

}

}

