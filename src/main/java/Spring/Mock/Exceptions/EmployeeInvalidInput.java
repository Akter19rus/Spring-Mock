package Spring.Mock.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeInvalidInput extends RuntimeException {
    public EmployeeInvalidInput(String message) {
        super(message);
    }
    public EmployeeInvalidInput(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
