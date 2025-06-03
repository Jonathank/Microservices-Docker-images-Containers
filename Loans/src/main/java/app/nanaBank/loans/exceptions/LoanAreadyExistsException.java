/**
 * 
 */
package app.nanaBank.loans.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author JONATHAN
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanAreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public LoanAreadyExistsException(String message) {
	super(message);
    }

    public LoanAreadyExistsException(String message, Throwable cause) {
	super(message, cause);
    }

}
