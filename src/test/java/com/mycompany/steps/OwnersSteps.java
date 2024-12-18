package com.mycompany.steps;

import com.mycompany.pages.owners.OwnerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.Serenity;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class OwnersSteps {

    @Steps
    OwnerPage ownerPage;

    @Given("el cliente abre el navegador")
    public void elClienteAbreElNavegador() throws InterruptedException {
        TimeUnit.MINUTES.sleep(10);
        ownerPage.open();
    }

    @Given("el cliente navega al menú propietarios")
    public void elClienteNavegaAlMenuPropietarios() {
        ownerPage.clickOnOwnerMenu();
    }

    @When("el cliente selecciona la opción buscar")
    public void elClienteSeleccionaLaOpcionBuscar() {
        ownerPage.clickOnOwnerSearchOptionMenu();
    }

    @Then("la página debe mostrar una lista de propietarios")
    public void laPaginaDebeMostrarUnaListaDePropietarios() {
        ownerPage.scrollToBottom();
        int rows = ownerPage.getOwnersTable();
//        assertEquals(10, rows);
        assertThat(ownerPage.getOwnersTable()).isPositive();
    }

    @Given("el cliente tiene los siguientes datos del propietario:")
    public void elClienteTieneLosSiguientesDatosDelPropietario(DataTable dataTable) {
        dataTable.asMaps(String.class, String.class)
                .forEach(row -> row.forEach((header, cell) -> Serenity.setSessionVariable(header).to(cell)));
    }

    @And("el cliente selecciona la opción agregar nuevo")
    public void elClienteSeleccionaLaOpciónAgregarNuevo() {
        ownerPage.clickAddOwnerButtonOption();
    }

    @And("el cliente ingresa los datos del propietario")
    public void elClienteIngresaLosDatosDelPropietario() {
        ownerPage.enterOwnerData();
    }

    @And("el cliente guarda el propietario")
    public void elClienteGuardaElPropietario() {
        ownerPage.clickAddOwnerButton();
    }

    @Then("la página debe mostrar la información del propietario registrado")
    public void laPaginaDebeMostrarLaInformacionDelPropietarioRegistrado() {
        ownerPage.scrollToBottom();
        String firstName = Serenity.sessionVariableCalled("firstName");
        String lastName = Serenity.sessionVariableCalled("lastName");
        String fullName = firstName + " " + lastName;
        assertEquals(fullName, ownerPage.getFullName());
    }
}
