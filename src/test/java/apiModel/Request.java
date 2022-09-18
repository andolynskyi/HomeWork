package apiModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {

    String email;
    IncomeInfo incomeInfo;
    String campaignId;
    int requestedLoanAmount;
    int grossMonthlyIncome;
    String leadOfferId;
    String socialSecurityNumber;
    boolean isProduction;
    PersonalInfo personalInfo;
    String currency;
    String language;
    String stateCode;
    EmploymentInfo employmentInfo;
    BankInfo bankInfo;


}
