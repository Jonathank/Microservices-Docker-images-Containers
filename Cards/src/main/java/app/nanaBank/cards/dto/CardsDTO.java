package app.nanaBank.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
	name = "Cards",
	description = "Schema to hold Cards information"
	)
public class CardsDTO {
    @NotEmpty(message = "Mobile Number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Schema(description = "Mobile Number of the borrower", example = "0771234567")
    private String mobileNumber;
    
    @NotEmpty(message = "Card Number cannot be empty")
    @Pattern(regexp = "^[0-9]{12}$", message = "Card number must be 12 digits")
    @Schema(description = "Card Number of Nana Bank", example = "123456789012")
    private String cardNumber;
    
    @NotEmpty(message = "Card Type cannot be empty")
    @Schema(description = "Type of Card", example = "Credit Card")
    private String cardType;
    
    @Positive(message = "Total Limit must be greater than zero")
    @Schema(description = "Total Limit of the Card", example = "500000")
    private int totalLimit;
    
    @PositiveOrZero(message = "Amount Used must be greater than or equal to zero")
    @Schema(description = "Amount Used from the Card Limit", example = "200000")
    private int amountUsed;
    
    @PositiveOrZero(message = "Available Amount must be greater than or equal to zero")
    @Schema(description = "Available Amount on the Card", example = "300000")
    private int availableAmount;

}
