package pro.sky.employeewebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeExistsException extends RuntimeException{
    public EmployeeExistsException() {
        super();
    }

    public EmployeeExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExistsException(String message) {
        super(message);
    }

    public EmployeeExistsException(Throwable cause) {
        super(cause);
    }
}
