/**
 * 
 */
package app.nanaBank.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import app.nanaBank.responsedto.ErrorResponseDTO;

/**
 * @author JONATHAN
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex,
	    HttpHeaders headers,
	    HttpStatusCode status, WebRequest request) {
	Map<String, String> validationErrors = new HashMap<>();
	List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();
	
	validationErrorList.forEach(error -> {
	    String fieldName = ((FieldError)error).getField();
	    String errorMessage = error.getDefaultMessage();
	    validationErrors.put(fieldName, errorMessage);
	    });
	return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    } 

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(
	    Exception ex,
	    WebRequest webRequest) {
	ErrorResponseDTO errorResponse = new ErrorResponseDTO(
		webRequest.getDescription(false),
		HttpStatus.INTERNAL_SERVER_ERROR,
		ex.getMessage(),
		LocalDateTime.now()
		);
	
	return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    /**
     * Handles CustomerAlreadyExistException and returns a custom error response.
     *
     * @param ex the exception that was thrown
     * @param webRequest the current web request
     * @return a ResponseEntity containing the error response
     */
    @ExceptionHandler(CustomerAlreadyExistException.class)
    public ResponseEntity<ErrorResponseDTO> handleCustomerAlreadyExistsException(
	    CustomerAlreadyExistException ex,
	    WebRequest webRequest) {
	ErrorResponseDTO errorResponse = new ErrorResponseDTO(
		webRequest.getDescription(false),
		HttpStatus.BAD_REQUEST,
		ex.getMessage(),
		LocalDateTime.now()
		);
	
	return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(
	    ResourceNotFoundException ex,
	    WebRequest webRequest) {
	ErrorResponseDTO errorResponse = new ErrorResponseDTO(
		webRequest.getDescription(false),
		HttpStatus.NOT_FOUND,
		ex.getMessage(),
		LocalDateTime.now()
		);
	return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
