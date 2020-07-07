Feature: RestAssured API Operations

Background: 
Given Initialize the API

Scenario: TC001_RestAssured_GET_Operation
When Perform GET operation for "/employees"
Then Verify the status code
Then Verify the status line
Then Verify the "Ashton Cox" element is present in the response body
Then Verify the "Content-Type" header value
Then Verify the "status" response value

Scenario: TC002_RestAssured_POST_Operation
When Perform POST operation for "/employees"
Then Verify the status code