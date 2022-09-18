package apiModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Offers {

    String description;
    int amount;
    double representativeAPR;
    String offerRefID;
    int interestRate;
    String productName;
    int term;
    String currency;
    int monthlyPayment;
    String url;

}
