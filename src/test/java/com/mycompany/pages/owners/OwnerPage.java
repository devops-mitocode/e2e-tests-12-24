package com.mycompany.pages.owners;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class OwnerPage extends PageObject {

    // List owners
//    @FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/a")
    @FindBy(xpath = "//a[contains(text(), 'Owners')]")
    WebElementFacade ownerMenu;

//    @FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[1]/a")
    @FindBy(css = "a[routerlink='/owners']")
    WebElementFacade ownerSearchOptionMenu;

    @FindBy(id = "ownersTable")
    WebElementFacade ownersTable;

    // Add owner
    @FindBy(xpath = "/html/body/app-root/div[1]/nav/div/ul/li[2]/ul/li[2]/a")
    WebElementFacade addOwnerButtonOption;

    @FindBy(id = "firstName")
    WebElementFacade firstNameField;

    @FindBy(id = "lastName")
    WebElementFacade lastNameField;

    @FindBy(id = "address")
    WebElementFacade addressField;

    @FindBy(id = "city")
    WebElementFacade cityField;

    @FindBy(id = "telephone")
    WebElementFacade telephoneField;

    @FindBy(xpath = "/html/body/app-root/div[2]/app-owner-add/div/div/form/div[7]/div/button[2]")
    WebElementFacade addOwnerButton;

    public void clickOnOwnerMenu() {
        ownerMenu.waitUntilVisible().waitUntilClickable().click();
    }

    public void clickOnOwnerSearchOptionMenu() {
        ownerSearchOptionMenu.waitUntilClickable().click();
    }

    public int getOwnersTable() {
//        waitFor(ownersTable).shouldBeVisible();
        return ownersTable.thenFindAll("tbody tr").size();
    }

    // Add Owner
    public void clickAddOwnerButtonOption() {
        addOwnerButtonOption.waitUntilClickable().click();
    }

    public void enterFirstName(String firstName) {
        firstNameField.waitUntilVisible().type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.waitUntilVisible().type(lastName);
    }

    public void enterAddress(String address) {
        addressField.waitUntilVisible().type(address);
    }

    public void enterCity(String city) {
        cityField.waitUntilVisible().type(city);
    }

    public void enterTelephone(String telephone) {
        telephoneField.waitUntilVisible().type(telephone);
    }

    public void enterOwnerData() {
        String firstName = Serenity.sessionVariableCalled("firstName");
        String lastName = Serenity.sessionVariableCalled("lastName");
        String address = Serenity.sessionVariableCalled("address");
        String city = Serenity.sessionVariableCalled("city");
        String telephone = Serenity.sessionVariableCalled("telephone");
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        enterCity(city);
        enterTelephone(telephone);
    }

    public void clickAddOwnerButton() {
        addOwnerButton.waitUntilClickable().click();
    }

    public void scrollToBottom() {
        Actions actions = new Actions(getDriver());
        actions.sendKeys(Keys.END).perform();
    }

    public String getFullName() {
        List<WebElementFacade> rows = ownersTable.thenFindAll(By.xpath("./tr"));
        WebElementFacade lastRow = rows.get(rows.size()-1);
        return lastRow.findElement(By.cssSelector("td a")).getText();
    }
}
