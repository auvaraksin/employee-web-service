package pro.sky.employeewebservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeWrongNameException extends RuntimeException {

        public EmployeeWrongNameException() {
            super();
        }

        public EmployeeWrongNameException(String message, Throwable cause) {
            super(message, cause);
        }

        public EmployeeWrongNameException(String message) {
            super(message);
        }

        public EmployeeWrongNameException(Throwable cause) {
            super(cause);
        }
    }
