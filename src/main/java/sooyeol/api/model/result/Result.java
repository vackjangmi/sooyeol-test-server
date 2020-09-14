package sooyeol.api.model.result;

import lombok.*;
import sooyeol.api.base.BaseResult;
import sooyeol.api.model.enums.ResultStatus;

@Data
public class Result extends BaseResult {

    @Builder
    public Result(ResultStatus status, String message) {
        super(status, message);
    }
}
