Feature: PUT SKILL API when User logged in as APIPROCESSING with Basic Auth


  Scenario Outline: Update record with valid skill ID and skill name  inputs
    Given  Set PUT request endpoint to url\skills\<skill Id>
    When user sends input <skill name> with existing skillId
    Then updates existing skillId record
    And receives 201 with valid JSON schema


## OK Created response

    Examples:

      | skill Id |   |     skill name     |
      |     2    |   |  Business Analyst  |
      |     5    |   |  ETL Developer     |




  Scenario Outline: Update record with non existing skill Id
    Given  Set PUT request endpoint to url\skills\<skill Id>
    When user sends input <skill name> with non existing skillId
    Then user receives 404 request status response
    And valid error message in JSON schema

## Not found

    Examples:

      |        skill Id    |   |     skill name     |
      |         222        |   |   Business Analyst |
      |         500        |   |   ETL Developer    |


  Scenario Outline: To update more than one skill name in skill Id
    Given  Set PUT request endpoint to url\skills\<skill Id>
    When user sends input <skill name> with existing skillId
    Then user receives 400 request status response


## Bad Request

    Examples:

      | skill Id | |     skill name         |
      |    1     | |  Storage, Mango DB     |


  Scenario Outline: To update skill name with invalid /NULL datatypes
    Given  Set PUT request endpoint to url\skills\<skill Id>
    When user sends invalid input <skill name> with existing skillId
    Then user receives 400 request status response


## Bad Request sent

    Examples:

      | skill Id |   |skill name    |
      |      1   |   |              | (Blank)
      |      2   |   |   False      | (Boolean)
      |      3   |   |    NULL      |
