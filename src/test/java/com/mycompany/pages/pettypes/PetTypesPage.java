package com.mycompany.pages.pettypes;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PetTypesPage extends PageObject {

    @FindBy(css = "a[routerlink='/pettypes']")
    WebElementFacade petTypesOptionMenu;

    @FindBy(id = "pettypes")
//    @FindBy(css = "#pettypes tbody")
    WebElementFacade petTypesTable;

    public void clickOnPetTypesMenu() {
        petTypesOptionMenu.waitUntilClickable().click();
    }

    public int getPetTypesTable() {
        waitFor(petTypesTable).shouldBeVisible();
        return petTypesTable.thenFindAll("tbody tr").size();
//        return petTypesTable.waitUntilVisible().thenFindAll("tr").size();
    }
}
