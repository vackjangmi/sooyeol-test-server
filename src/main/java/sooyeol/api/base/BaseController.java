package sooyeol.api.base;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import sooyeol.api.model.enums.ResultStatus;
import sooyeol.api.model.result.ExceptionResult;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public @ResponseBody
    ExceptionResult handleException(Exception e) {
        ExceptionResult result = new ExceptionResult();

        result.setStatus(ResultStatus.ERROR);
        result.setMessage(e.getMessage());

        return result;
    }
}
