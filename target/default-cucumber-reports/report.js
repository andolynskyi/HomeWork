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
});