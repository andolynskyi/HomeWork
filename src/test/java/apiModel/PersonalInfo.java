package apiModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalInfo {

    String firstName;
    String lastName;
    String dateOfBirth;
    Address address;
    String mobilePhone;
    String homePhone;


}
