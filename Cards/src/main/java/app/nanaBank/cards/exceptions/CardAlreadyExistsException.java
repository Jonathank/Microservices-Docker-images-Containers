/**
 * 
 */
package app.nanaBank.cards.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author JONATHAN
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CardAlreadyExistsException(String message) {
	super(message);
    }

    public CardAlreadyExistsException(String message, Throwable cause) {
	super(message, cause);
    }

}
