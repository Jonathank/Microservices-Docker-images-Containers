package app.nanaBank.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
@Schema(
	name = "Loans",
	description = "Schema to hold Loan information"
	)
public class LoansDTO {

    @NotEmpty(message = "Mobile Number cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Schema(description = "Mobile Number of the borrower", example = "0771234567")
    private String mobileNumber;

    @NotEmpty(message = "Loan Number cannot be empty")
    @Pattern(regexp = "^[A-Z]{10}[0-9]{12}$", message = "Loan number must start with two uppercase letters followed by ten digits")
    @Schema(description = "Loan Number of Nana Bank", example = "LN1234567890")
    private String loanNumber;

    @NotEmpty(message = "Loan Type cannot be empty")
    @Schema(description = "Type of Loan", example = "Personal Loan")
    private String loanType;

    @Positive(message = "Total Loan Amount must be greater than zero")
    @Schema(description = "Total Loan Amount", example = "1000000")
    private int totalLoan;

    @PositiveOrZero(message = "Amount Paid must be greater than or equal to zero")
    @Schema(description = "Amount Paid towards the Loan", example = "500000")
    private int amountPaid;

    @PositiveOrZero(message = "Outstanding Amount must be greater than or equal to zero")
    @Schema(description = "Outstanding Amount on the Loan", example = "500000")
    private int outstandingAmount;
}
