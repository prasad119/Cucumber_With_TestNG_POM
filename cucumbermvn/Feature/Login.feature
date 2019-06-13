Feature: Login verification check

  @test
  Scenario Outline: Login test1
    Given user launch and enter the "<userName>" and "<password>"
    When user select location "<location>" and do login
    Then verify Msg
    Then Close Window

    Examples: 
      | userName | password | location       |
      | Admin    | Admin123 | Inpatient Ward |

  @test
  Scenario Outline: Login test2
    Given user launch and enter the "<userName>" and "<password>"
    When user select location "<location>" and do login
    Then verify Msg
    Then Close Window

    Examples: 
      | userName | password | location       |
      | Admin    | Admin123 | Inpatient Ward |
