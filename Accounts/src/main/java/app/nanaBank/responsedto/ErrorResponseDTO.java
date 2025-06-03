package app.nanaBank.responsedto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor

@Schema(
	    name = "ErrorResponse",
    description = "Schema to hold error response information"
)
public class ErrorResponseDTO {

    @Schema(description = "API path where the error occurred", example = "/api/accounts/create")
    private String apiPath;
    @Schema(description = "HTTP status code of the error", example = "400")
    private HttpStatus errorCode;
    @Schema(description = "Error message describing the issue", example = "Invalid input data")
    private String errorMessage;
    @Schema(description = "Timestamp when the error occurred", example = "2023-10-01T12:00:00")
    private LocalDateTime errorTime;
}
