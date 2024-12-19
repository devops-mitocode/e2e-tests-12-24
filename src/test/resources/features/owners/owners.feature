# language: en
@gestionarPropietarios
Feature: Gestionar propietarios

  @listarPropietarios
  Scenario: Listar propietarios
    Given el cliente navega al menú propietarios
    When el cliente selecciona la opción listar de propietarios
    Then la página debe mostrar una lista de propietarios

  @registrarPropietario
  Scenario Outline: Registrar un propietario
    Given el cliente tiene los siguientes datos del propietario:
      | firstName   | lastName   | address   | city   | telephone   |
      | <firstName> | <lastName> | <address> | <city> | <telephone> |
    And el cliente navega al menú propietarios
    When el cliente selecciona la opción agregar nuevo
    And el cliente ingresa los datos del propietario
    And el cliente guarda el propietario
    Then la página debe mostrar la información del propietario registrado
    Examples:
      | firstName | lastName | address      | city | telephone |
      | John      | Doe      | 1234 Main St | NY   | 123456789 |
      | Jane      | Smith    | 5678 Elm St  | LA   | 987654321 |
      | Alice     | Johnson  | 9101 Oak St  | SF   | 555555555 |
