Feature: All scenarios related to APPROVED loan


  @api
  Scenario: Creating a POST request with APPROVED response
    Given hit POST method with valid header key "b813b584-6932-4d0a-909f-43ae22df452a" and resource "/api/lde/v4/offer" to create a request with approved loan
    Then verify if the request successfully approved the loan
