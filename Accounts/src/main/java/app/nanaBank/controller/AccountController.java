package app.nanaBank.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.nanaBank.constants.AccountsConstants;
import app.nanaBank.dto.CustomerDTO;
import app.nanaBank.responsedto.ErrorResponseDTO;
import app.nanaBank.responsedto.ResponseDTPO;
import app.nanaBank.services.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

/**
 * @Tag is used to group and document the REST APIs 
 * for account management in NANA Bank.
 * * This controller provides endpoints for
 *  creating, retrieving, updating, and deleting customer accounts.
 * 
 */
@Tag(
	name = "	CRUD REST APIs for Account Management in NANA Bank", 
	description = "APIs for managing customer accounts in NANA Bank, "
		+ "including creation, retrieval, updating, and deletion of accounts."
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/accounts", produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
public class AccountController {

    private final IAccountService accountService;
    
    @Operation(
	    summary = "Create Account REST API", 
	    description = "This endpoint allows you to create"
	    	+ " a new customer account in NANA Bank."
    )
    @ApiResponse(
	    responseCode = "201", 
	    description = "HTTP Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDTPO>createAccount(
	   @Valid @RequestBody CustomerDTO customerDTO
	    ) {
	accountService.createAccount(customerDTO);
	return ResponseEntity.status(HttpStatus.CREATED).body(
	    new ResponseDTPO(AccountsConstants.STATUS_CODE_CREATED,
		    AccountsConstants.Message_201));
    }
    
    @Operation(
	    summary = "Fetch Account Details REST API", 
	    description = "This endpoint allows you to fetch"
		    + " account details of a customer by their phone number."
    )
    @ApiResponses({
	    @ApiResponse(
	    responseCode = "200", 
	    description = "HTTP Status OK"
	           ),
	    
	 @ApiResponse(
			    responseCode = "500", 
			    description = "Internal Server Error",
			    content = @Content(
				schema = @Schema(
				implementation = ErrorResponseDTO.class
			))
    	    )
    })
    @GetMapping("/fetch/AccountDetails")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(
	    @RequestParam
	    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	    String phoneNumber) {
	CustomerDTO customerDTO = accountService.fetchAccountDetails(phoneNumber);
	
	return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }
    
    @Operation(
	    summary = "Update Account Details REST API", 
	    description = "This endpoint allows you to update"
		    + " account details of a customer."
    )
    @ApiResponses({
	    @ApiResponse(
		    responseCode = "200", 
		    description = "HTTP Status OK"
	    ),
	    @ApiResponse(
		    responseCode = "500", 
		    description = "Internal Server Error",
		    content = @Content(
			    schema = @Schema(
				    implementation = ErrorResponseDTO.class
			    ))
			    
	    )
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDTPO> updateAccountDetails(
	    @Valid@RequestBody CustomerDTO customerDTO) {
	boolean isUpdated = accountService.updateAccountDetails(customerDTO);
	if (isUpdated) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_SUCCESS,
			    AccountsConstants.ACCOUNT_UPDATE_SUCCESSFUL));	
	} else {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_FAILURE,
			    AccountsConstants.Message_500));
	    
	}
    }
    
    @Operation(
	    summary = "Delete Account REST API", 
	    description = "This endpoint allows you to delete"
		    + " a customer account by their phone number."
    )
    @ApiResponses({
	    @ApiResponse(
		    responseCode = "200", 
		    description = "HTTP Status OK"
	    ),
	    @ApiResponse(
		    responseCode = "500", 
		    description = "Internal Server Error",
		    content = @Content(
			schema = @Schema(
			implementation = ErrorResponseDTO.class
		))
	    )
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTPO> deleteAccount(
	    @RequestParam 
	    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	    String phoneNumber) {
	boolean isDeleted = accountService.deleteAccount(phoneNumber);
	if (isDeleted) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_SUCCESS,
			    AccountsConstants.ACCOUNT_DELETED_SUCCESSFULLY));
	    } else {
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(AccountsConstants.STATUS_CODE_FAILURE,
			    AccountsConstants.Message_500));
			    
	    }
    }
}
