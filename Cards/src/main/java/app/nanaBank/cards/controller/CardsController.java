package app.nanaBank.cards.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.nanaBank.cards.constants.CardsConstants;
import app.nanaBank.cards.dto.CardsDTO;
import app.nanaBank.cards.responsedtos.ErrorResponseDTO;
import app.nanaBank.cards.responsedtos.ResponseDTPO;
import app.nanaBank.cards.service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

/**
 * @Tag is used to group and document the REST APIs 
 * for cards management in NANA Bank.
 * * This controller provides endpoints for
 *  creating, retrieving, updating, and deleting customer cards.
 * 
 */
@Tag(
	name = "	CRUD REST APIs for Cards Management in NANA Bank", 
	description = "APIs for managing customer Cards in NANA Bank, "
		+ "including creation, retrieval, updating, and deletion of Cards."
)
@RestController
@RequiredArgsConstructor
@RequestMapping(path="/api/cards", produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
public class CardsController {
    
    private final ICardsService cardsService;
    @Operation(
	    summary = "Create Cards REST API", 
	    description = "This endpoint allows you to create"
	    	+ " a new customer Card in NANA Bank."
    )
    @ApiResponses({
	    @ApiResponse(
	    responseCode = "201", 
	    description = "HTTP Status CREATED"
	    ),
	    @ApiResponse(
	    responseCode = "500",
	    description = "Internal Server Error",
	    content = @Content(
		    schema = @Schema(implementation = ErrorResponseDTO.class))
	    )
    })
    @PostMapping("/create")
     public ResponseEntity<ResponseDTPO> createCard(
	     @Valid@RequestParam
	     @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	     String mobileNumber
	     ) {
	cardsService.createCard(mobileNumber);
	return ResponseEntity.status(HttpStatus.CREATED).body(
		    new ResponseDTPO(CardsConstants.STATUS_CODE_CREATED,
			    CardsConstants.Message_201));
	    }
    
    @Operation(
	    summary = "Fetch Card Details REST API", 
	    description = "This endpoint allows you to fetch"
		    + " Card details of a customer by their phone number."
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
               schema = @Schema(implementation = ErrorResponseDTO.class ))
	  )
	        })
    @PostMapping("/fetch")
    public ResponseEntity<CardsDTO> fetchCardDetails(
	    @Valid@RequestParam
	  @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	  String mobileNumber
	    ) {
	CardsDTO fetchedCardDetails = cardsService.fetchCardDetails(mobileNumber);
	return ResponseEntity.status(HttpStatus.OK).body(fetchedCardDetails);
    }

    @Operation(
	    summary = "Update Cards Details REST API", 
	    description = "This endpoint allows you to update"
		    + " card details of a customer."
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
    public ResponseEntity<ResponseDTPO> updateCardsDetails(
	    @Valid@RequestBody CardsDTO cardsDTO
	    ) {
	boolean isUpdated = cardsService.updateCard(cardsDTO);
	if (isUpdated) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(CardsConstants.STATUS_CODE_SUCCESS,
			    CardsConstants.CARD_UPDATED_SUCCESS));	
	} else {
	    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(CardsConstants.STATUS_CODE_FAILURE,
			   CardsConstants.Message_500));
	    
	}
    }
    
    @Operation(
	    summary = "Delete Cards REST API", 
	    description = "This endpoint allows you to delete"
		    + " a customer Cards in NANA Bank."
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
    @PostMapping("/delete")
    public ResponseEntity<ResponseDTPO> deleteCard(
	    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
	    String mobileNumber
	    ) {
	
	boolean isDeleted = cardsService.deleteCard(mobileNumber);
	if (isDeleted) {
	    return ResponseEntity.status(HttpStatus.OK).body(
		    new ResponseDTPO(CardsConstants.STATUS_CODE_SUCCESS,
			    CardsConstants.CARD_DELETED_SUCCESS));
	    } else {
			    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
		    new ResponseDTPO(CardsConstants.STATUS_CODE_FAILURE,
			    CardsConstants.Message_500));
			    
	    }
    }
}

