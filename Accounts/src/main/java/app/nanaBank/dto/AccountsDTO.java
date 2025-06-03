package app.nanaBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
	name = "Accounts",
	description = "Schema to hold Account information"
	)
public class AccountsDTO {

    @Schema(description = "Account Number of Nana Bank", example = "1234567890")
    @NotEmpty(message = "accountNumber cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number must be 10 digits")
    private Long accountNumber;
    
    @Schema(description = "Account Name of Nana Bank", example = "Kyeyune Jonathan")
    @NotEmpty(message = "accountName cannot be empty")
    private String accountName;
    
    @Schema(description = "Account Type of Nana Bank", example = "Savings")
    @NotEmpty(message = "accountType cannot be empty")
    private String accountType;
    
    @Schema(description = "Account Status of Nana Bank", example = "Active")
    @NotEmpty(message = "accountStatus cannot be empty")
    private String accountStatus;
    
    @Schema(description = "Branch Name of Nana Bank", example = "Kampala Branch")
    @NotEmpty(message = "branchName cannot be empty")
    private String branchName;
    
    @Schema(description = "Branch Address of Nana Bank", example = "Plot 123, Kampala Road, Kampala")
    @NotEmpty(message = "branchAddress cannot be empty")
    private String branchAddress;
}
