Feature: POST SKILL API when User logged in as APIPROCESSING with Basic Auth

  ## End point : http://localhost:8080/Skills/

  Scenario Outline: To create new User Record with Skill Name
    Given user sets POST request with endpoint \skills
    When User sends request with valid input from valid excel <row Id>
    Then User should receive 201
    And user receive valid JSON schema

    # OK Created status code
    Examples:
      | row Id  |
      | 1       |
      | 2       |
      | 3       |
      | 4       |
      | 5       |

  Scenario Outline: To create new User Record with Skill Name numeric
    Given user sets POST request with endpoint \skills
    When User sends request with valid input from numeric excel <row Id>
    Then User should receive 201
    And user receive valid JSON schema

    # OK Created status code
    Examples:
      | row Id  |
      | 1       |
      | 2       |

Scenario Outline: To create new User Record with invalid Skill Name

    Given user sets POST request with endpoint \skills
    When User sends request with valid input from invalid excel <row Id>
    Then User should receive 400

    # Bad Request

  Examples:
    | row Id  |
    | 1       |
    | 2       |
    | 3       |
       
