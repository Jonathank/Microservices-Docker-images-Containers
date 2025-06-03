package app.nanaBank.responsedto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Schema(
	name = "Response",
	description = "Schema to hold successful response information"
	)
public class ResponseDTPO {

    @Schema(description = "Status code of the response", example = "201")
    private String statusCode;
    
    @Schema(description = "Status message of the response", example = "Account created successfully")
    private String statusMessage;
   // private Object data;
}
