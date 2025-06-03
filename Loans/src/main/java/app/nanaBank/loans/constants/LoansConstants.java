package app.nanaBank.loans.constants;

public class LoansConstants {

  
    public static final String LOAN_NOT_FOUND = "Loan not found";
    public static final String LOAN_ALREADY_EXISTS = "Loan already exists";
    public static final String LOAN_CREATED_SUCCESSFULLY = "Loan created successfully";
    public static final String LOAN_UPDATED_SUCCESSFULLY = "Loan updated successfully";
    public static final String LOAN_DELETED_SUCCESSFULLY = "Loan deleted successfully";
    public static final String LOAN_AMOUNT_INVALID = "Loan amount is invalid";
    public static final String LOAN_TYPE_INVALID = "Loan type is invalid";
    public static final String LOAN_NOT_ELIGIBLE = "Loan not eligible for this user";
    public static final String LOAN_PAYMENT_SUCCESSFUL = "Loan payment successful";
    public static final String LOAN_PAYMENT_FAILED = "Loan payment failed";
    public static final String LOAN_STATUS_PENDING = "Pending";
    public static final String LOAN_STATUS_APPROVED = "Approved";
    public static final String LOAN_STATUS_REJECTED = "Rejected";
    public static final String LOAN_STATUS_COMPLETED = "Completed";
    public static final String LOAN_STATUS_OVERDUE = "Overdue";
    public static final String LOAN_STATUS_CLOSED = "Closed";
    public static final String LOAN_STATUS_IN_PROGRESS = "In Progress";
    public static final int NEW_LOAN_LIMIT = 1_00_000;
    
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
    private LoansConstants() {
	// Private constructor to prevent instantiation
    }
}
