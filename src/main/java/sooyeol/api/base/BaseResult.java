package sooyeol.api.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sooyeol.api.model.enums.ResultStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseResult {

    private ResultStatus status;
    private String message;
    @JsonProperty("statusCode")
    private int getStatusCode () {
        return status.value();
    }

}
