package apiModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseBody {

    List<Offers> offers;

    boolean accepted;
    int partnerId;
    String reference_id;
    int code;
    String status;
    String apiVersion;

    Request request;

}
