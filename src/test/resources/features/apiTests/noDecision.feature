Feature: All test cases related when the system doesn't make decision

  @api
  Scenario: Creating POST request with missing request data
    Given hit POST method with valid header key "b813b584-6932-4d0a-909f-43ae22df452a" and resource "/api/lde/v4/offer" to create a request with missing data
    Then verify if the request successfully decline the loan and empty fields empty