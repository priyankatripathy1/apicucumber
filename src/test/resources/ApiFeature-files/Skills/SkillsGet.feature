Feature: Authorization is set to default:Inherit auth from Parent
 
 
 ## End point : http://localhost:8080/Skills/
  
Scenario:To get all the Skill details
  
  Given user set GET method with endpoint/url/Skills
  When User sends request 
  Then JSON schema is valid 
  And User receives status code 200
  And User should receive a list of skills

Scenario Outline: To get all the Skills detail for specific Skill ID 

  Given user set GET method with endpoint/url/Skills/ID
  When User sends the request with specific <skill Id>
  Then JSON schema is valid for Skill
  And User receives status code 200
  And User should receive a list of skills for specific skill ID <skill Id>.


Examples:
| skill Id |
|   1      |
|   2      |   



Scenario Outline: To get all the Skills detail for Invalid Skill ID 

  Given user set GET method with endpoint/url/Skills/ID
  When User sends the request with invalid <skill Id>
  Then User receives status code 400

## Receives status as 400 Bad request 
Examples:
| skill Id |
|   2.1    | (Decimal)
|  A123b   | (Alpha Numeric) 
|  null    | 


Scenario Outline: To get all the Skills detail for non existing Skill ID 

  Given user set GET method with endpoint/url/Skills/ID
  When User sends the request with non existing <skill Id>
  Then User receives status code 404

## Receives status as 404 NotFound
Examples:
| skill Id |
|    0     | 
|   200    | 


  
  