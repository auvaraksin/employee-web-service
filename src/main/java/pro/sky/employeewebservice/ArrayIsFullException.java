package pro.sky.employeewebservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException() {
        super();
    }

    public ArrayIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArrayIsFullException(String message) {
        super(message);
    }

    public ArrayIsFullException(Throwable cause) {
        super(cause);
    }
}
