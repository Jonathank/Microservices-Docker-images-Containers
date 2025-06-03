package app.nanaBank.cards.constants;

public class CardsConstants {

    public static final String CARD_CREATED_SUCCESS = "Card created successfully";
    public static final String CARD_UPDATED_SUCCESS = "Card updated successfully";
    public static final String CARD_DELETED_SUCCESS = "Card deleted successfully";
    public static final String CARD_NOT_FOUND = "Card not found";
    public static final String CARD_ALREADY_EXISTS = "Card already exists for this mobile number";
    
    
    public static final String STATUS_CODE_SUCCESS = "200";
    public static final String Message_200 = "Request processed successfully";
    public static final String STATUS_CODE_BAD_REQUEST = "400";
    public static final String Message_400 = "Bad request. Please check your input";
    public static final String STATUS_CODE_UNAUTHORIZED = "401";
    public static final String Message_401 = "You are not authorized to perform this action";
    public static final String STATUS_CODE_FORBIDDEN = "403";
    public static final String Message_403 = "You do not have permission to access this resource";
    public static final String STATUS_CODE_NOT_FOUND = "404";
    public static final String Message_404 = "Resource not found";
    public static final String STATUS_CODE_CREATED = "201";
    public static final String Message_201 = "Account created successfully";
    public static final String STATUS_CODE_FAILURE = "500";
    public static final String Message_500 = "An error occurred.please try again or contact dev team";
    
    private CardsConstants() {
	// Private constructor to prevent instantiation
    }
}
