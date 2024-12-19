@gestionarTiposMascotas
Feature:  Gestionar tipos de mascotas

  @listarTiposMascotas
  Scenario: Listar tipos de mascotas
    When el cliente selecciona la opción listar de tipos de mascotas
    Then la página debe mostrar una lista de tipos de mascotas