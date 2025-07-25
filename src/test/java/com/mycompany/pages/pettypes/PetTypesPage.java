package com.mycompany.pages.pettypes;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class PetTypesPage extends PageObject {

    @FindBy(css = "a[routerlink='/pettypes']")
    WebElementFacade petTypesOptionMenu;

    @FindBy(id = "pettypes")
    WebElementFacade petTypesTable;

    public void clickOnPetTypesMenu() {
        petTypesOptionMenu.waitUntilClickable().click();
    }

    public int getPetTypesTable() {
        return getTableRows().size();
    }

    private List<WebElementFacade> getTableRows() {
        waitFor(petTypesTable).shouldBeVisible();
        return petTypesTable.thenFindAll("tbody tr");
    }
}
