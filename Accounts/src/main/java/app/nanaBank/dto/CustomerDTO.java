package app.nanaBank.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
@Schema(
	name = "Customer",
	description = "Schema to hold Customer and Account information"
	)
public class CustomerDTO {
    @Schema(description = "Name of the Customer", example ="Kyeyune Jonathan")
    @NotEmpty(message = "Customer name cannot be empty")
    @Size(min = 5, max = 30, message = "Customer name must be between 5 and 30 characters")
    private String name;
    
    @Schema(description = "Email address of the Customer", example = "kyeyunejonathan001@gmail.com")
    @Email(message = "Email should be valid")
    private String email;
    
    @Schema(description = "Mobile number of the Customer", example = "0701234567")
    @NotEmpty(message = "Customer mobileNumber cannot be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @Schema(description = "Accounts details for the Customer")
    private AccountsDTO accountsDetails;
}
