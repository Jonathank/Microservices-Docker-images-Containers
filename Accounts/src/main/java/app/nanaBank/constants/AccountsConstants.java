package app.nanaBank.constants;

public class AccountsConstants {

    public static final String INVALID_ACCOUNT_NUMBER = "Invalid account number";
    public static final String ACCOUNT_DELETED_SUCCESSFULLY = "Account deleted successfully";
    public static final String ACCOUNT_UPDATE_SUCCESSFUL = "Account updated successfully";
    public static final String ACCOUNT_UPDATE_FAILED = "Account update failed";
    public static final String ACCOUNT_ALREADY_EXISTS = "Account already exists for this customer";
    public static final String ACCOUNT_TYPE_SAVINGS = "SAVINGS";
    public static final String ACCOUNT_TYPE_CHECKING = "CHECKING";
    public static final String ACCOUNT_TYPE_BUSINESS = "BUSINESS";
    public static final String ACCOUNT_STATUS_ACTIVE = "ACTIVE";
    public static final String ACCOUNT_STATUS_INACTIVE = "INACTIVE";
    public static final String ACCOUNT_STATUS_CLOSED = "CLOSED";
    public static final String ACCOUNT_STATUS_FROZEN = "FROZEN";
    public static final String ACCOUNT_STATUS_PENDING = "PENDING";
    public static final String ACCOUNT_STATUS_SUSPENDED = "SUSPENDED";
    
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
    public static final String BRANCH_NAME = "Main Branch";
    public static final String BRANCH_ADDRESS = "123 Main St, kampala, Uganda";
    
    private AccountsConstants() {
	// Private constructor to prevent instantiation
    }
}
