$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/apiTests/acceptedOffer.feature");
formatter.feature({
  "name": "All scenarios related to APPROVED loan",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating a POST request with APPROVED response",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "hit POST method with valid header key \"b813b584-6932-4d0a-909f-43ae22df452a\" and resource \"/api/lde/v4/offer\" to create a request with approved loan",
  "keyword": "Given "
});
formatter.match({
  "location": "CreatingRequestWithAcceptedLoan_stepDefs.hit_POST_method_with_valid_header_key_and_resource_to_create_a_request_with_approved_loan(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if the request successfully approved the loan",
  "keyword": "Then "
});
formatter.match({
  "location": "CreatingRequestWithAcceptedLoan_stepDefs.verify_if_the_request_successfully_approved_the_loan()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/features/apiTests/declineOffer.feature");
formatter.feature({
  "name": "All scenarios related to DECLINE loan",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating a POST request with DECLINE response",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "hit POST method with valid header key \"b813b584-6932-4d0a-909f-43ae22df452a\" and resource \"/api/lde/v4/offer\" to create a request with decline loan",
  "keyword": "Given "
});
formatter.match({
  "location": "CreatingRequestWithDeclineLoan_stepDefs.hit_POST_method_with_valid_header_key_and_resource_to_create_a_request_with_decline_loan(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if the request successfully decline the loan",
  "keyword": "Then "
});
formatter.match({
  "location": "CreatingRequestWithDeclineLoan_stepDefs.verify_if_the_request_successfully_decline_the_loan()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/features/apiTests/noDecision.feature");
formatter.feature({
  "name": "All test cases related when the system doesn\u0027t make decision",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Creating POST request with missing request data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@api"
    }
  ]
});
formatter.step({
  "name": "hit POST method with valid header key \"b813b584-6932-4d0a-909f-43ae22df452a\" and resource \"/api/lde/v4/offer\" to create a request with missing data",
  "keyword": "Given "
});
formatter.match({
  "location": "CreatingPOSTRequestWithMissingData.hit_POST_method_with_valid_header_key_and_resource_to_create_a_request_with_missing_data(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "verify if the request successfully decline the loan and empty fields empty",
  "keyword": "Then "
});
formatter.match({
  "location": "CreatingPOSTRequestWithMissingData.verify_if_the_request_successfully_decline_the_loan_and_empty_fields_empty()"
});
formatter.result({
  "status": "passed"
});
});