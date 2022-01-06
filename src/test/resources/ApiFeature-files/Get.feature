    
  Feature: Testing LMS API 

Scenario: Checks authentication

Given User is on the Get Request
When User sends Request
Then User Recevies Response
 


Scenario Outline: User get record of existing skillID

Given User is on the Get Request
When User sends exsiting <skillID>
Then User retrives the skill Details

Examples:
| skillID|
| 1 |


Scenario Outline: User get record of Non existing skillID

Given User is on the Get Request
When User sends Non exsiting <skillID>
Then User receives an 404 status code

Examples:
| skillID|
| 99|
