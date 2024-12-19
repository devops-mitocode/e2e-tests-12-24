package com.mycompany.steps;

import com.mycompany.pages.pettypes.PetTypesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTypesDefinitions {

    PetTypesPage petTypesPage;

    @When("el cliente selecciona la opción listar de tipos de mascotas")
    public void el_cliente_selecciona_la_opcion_listar_de_tipos_de_mascotas() {
        petTypesPage.open();
        petTypesPage.clickOnPetTypesMenu();
    }
    @Then("la página debe mostrar una lista de tipos de mascotas")
    public void la_pagina_debe_mostrar_una_lista_de_tipos_de_mascotas() {
//        assertEquals(6, petTypesPage.getPetTypesTable());
        assertThat(petTypesPage.getPetTypesTable()).isPositive();
    }
}
