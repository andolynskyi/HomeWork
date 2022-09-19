package step_definitions.api_StepDefs;

import apiModel.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.AdditionToolsInTests;
import utilities.Config;

public class CreatingPOSTRequestWithMissingData {

    ObjectMapper objectMapper = new ObjectMapper();
    Response response;
    ResponseBody responseBody;

    @Given("hit POST method with valid header key {string} and resource {string} to create a request with missing data")
    public void hit_POST_method_with_valid_header_key_and_resource_to_create_a_request_with_missing_data(String headerKey, String resource) throws Exception {

        //Creating a Java Object with missing firstName and lastName
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName("");
        personalInfo.setLastName("");
        personalInfo.setDateOfBirth("19451009");
        personalInfo.setMobilePhone("3224340098");
        personalInfo.setHomePhone("4523452232");

        Address address = new Address();
        address.setStreetAddress("123 Main Street");
        address.setCity("Miami");
        address.setZip("33125");
        address.setCountryCode("US");

        personalInfo.setAddress(address);

        BankInfo bankInfo = new BankInfo();
        bankInfo.setBankName("Chase");
        bankInfo.setAbaRoutingNumber("123456789");
        bankInfo.setAccountNumber("012345789");
        bankInfo.setAccountType(1);
        bankInfo.setAccountLength(6);

        IncomeInfo incomeInfo = new IncomeInfo();
        incomeInfo.setIncomeType("Employment");
        incomeInfo.setPayrollType("DirectDeposit");
        incomeInfo.setPayrollFrequency(1);
        incomeInfo.setLastPayrollDate("20160915");

        EmploymentInfo employmentInfo = new EmploymentInfo();
        employmentInfo.setEmployerName("ToysRUs");
        employmentInfo.setHireDate("20110516");

        Request request = new Request();
        request.setProduction(false);
        request.setLanguage("en");
        request.setCurrency("USD");
        request.setCampaignId("11-50-newhope");
        request.setSocialSecurityNumber("123456780");
        request.setLeadOfferId("20160912-21EC2020-3AEA-4069-A2DD-08002B30309D");
        request.setEmail("test_customer@gmail.com");
        request.setStateCode("FL");
        request.setGrossMonthlyIncome(2800);
        request.setRequestedLoanAmount(1500);

        request.setPersonalInfo(personalInfo);
        request.setBankInfo(bankInfo);
        request.setIncomeInfo(incomeInfo);
        request.setEmploymentInfo(employmentInfo);

        String jsBody = objectMapper.writeValueAsString(request);

        response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("x-api-key", headerKey)
                .and()
                .body(jsBody)
                .post(Config.getProperty("baseURL") + resource);

        Assert.assertEquals("Status code NOT 200", 200, response.statusCode());
    }

    @Then("verify if the request successfully decline the loan and empty fields empty")
    public void verify_if_the_request_successfully_decline_the_loan_and_empty_fields_empty() throws Exception {


        responseBody = objectMapper.readValue(response.asString(), ResponseBody.class);

        //Checking status of response
        Assert.assertFalse("Accepted", responseBody.isAccepted());
        Assert.assertFalse("Partner id EMPTY", String.valueOf(responseBody.getPartnerId()).isEmpty());
        Assert.assertFalse("Reference id", responseBody.getReference_id().isEmpty());
        Assert.assertEquals("Code NOT 201", 341, responseBody.getCode());
        Assert.assertEquals("Code NOT 201", "DECLINED", responseBody.getStatus());
        Assert.assertEquals("Code NOT 201", "4.8", responseBody.getApiVersion());

        //Checking personal info of the client
        /*
        firstName
        lastName
        dateOfBirth
        mobilePhoneNumber
        homePhoneNumber
         */

        // Checking missing data
        Assert.assertTrue("First name NOT EMPTY", responseBody.getRequest().getPersonalInfo().getFirstName().isEmpty());
        Assert.assertTrue("Last name NOT EMPTY", responseBody.getRequest().getPersonalInfo().getLastName().isEmpty());

        Assert.assertEquals("Date of birth NOT equal", "19451009", responseBody.getRequest().getPersonalInfo().getDateOfBirth());
        Assert.assertEquals("Mobile phone number NOT equal", "3224340098", responseBody.getRequest().getPersonalInfo().getMobilePhone());
        Assert.assertEquals("Home phone number NOT equal", "4523452232", responseBody.getRequest().getPersonalInfo().getHomePhone());

        //Checking offer. Not any offers displayed

        Assert.assertEquals("List of offers NOT EMPTY", null, responseBody.getOffers());
        Assert.assertEquals("Social number NOT a String", "String", responseBody.getRequest().getSocialSecurityNumber().getClass().getSimpleName());

        String socialSecurityNumber = responseBody.getRequest().getSocialSecurityNumber();

        boolean checkingSocialNumber = true;

        Assert.assertEquals("Length of social security number NOT 9", 9, socialSecurityNumber.length());

        for (int i = 0; i < socialSecurityNumber.length(); i++) {
            if (!Character.isDigit(socialSecurityNumber.charAt(i))) {
                checkingSocialNumber = false;
                break;
            }
        }
        Assert.assertTrue("Wrong Social Security Number", checkingSocialNumber);

//        leadOfferId
        Assert.assertFalse("Lead offer id EMPTY", responseBody.getRequest().getLeadOfferId().isEmpty());
        Assert.assertEquals("Lead offer id NOT in String", "String", responseBody.getRequest().getLeadOfferId().getClass().getSimpleName());

//        email
        Assert.assertFalse("Email EMPTY", responseBody.getRequest().getEmail().isEmpty());
        Assert.assertEquals("Email NOT in String", "String", responseBody.getRequest().getEmail().getClass().getSimpleName());
        Assert.assertTrue("Email NOT valid", AdditionToolsInTests.isValid(responseBody.getRequest().getEmail()));

//        stateCode
        Assert.assertEquals("State code NOT in String", "String", responseBody.getRequest().getStateCode().getClass().getSimpleName());
        Assert.assertEquals("State Code length NOT 2", 2, responseBody.getRequest().getStateCode().length());

//        requestedLoanAmount
        Assert.assertEquals("Requested loan amount NOT in Integer", "Integer", ((Object) responseBody.getRequest().getRequestedLoanAmount()).getClass().getSimpleName());

//        grossMonthlyIncome
        Assert.assertEquals("Gross Monthly income", "Integer", ((Object) responseBody.getRequest().getGrossMonthlyIncome()).getClass().getSimpleName());


    }


}
