Feature: All scenarios related to DECLINE loan

  @api
  Scenario: Creating a POST request with DECLINE response
    Given hit POST method with valid header key "b813b584-6932-4d0a-909f-43ae22df452a" and resource "/api/lde/v4/offer" to create a request with decline loan
    Then verify if the request successfully decline the loan