/**
 * 
 */
package app.nanaBank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author JONATHAN
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CustomerAlreadyExistException(String message) {
	super(message);
    }

    public CustomerAlreadyExistException(String message, Throwable cause) {
	super(message, cause);
    }

}
