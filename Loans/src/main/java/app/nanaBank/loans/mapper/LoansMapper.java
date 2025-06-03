/**
 * 
 */
package app.nanaBank.loans.mapper;

import app.nanaBank.loans.dto.LoansDTO;
import app.nanaBank.loans.models.Loans;

/**
 * @author JONATHAN
 */
public class LoansMapper {

    public static LoansDTO mapToLoansDTO(Loans loans, LoansDTO loansDTO) {
		if (loans == null) {
	    return null;
	}
	if (loansDTO == null) {
	    loansDTO = new LoansDTO();
	}
	
	loansDTO.setMobileNumber(loans.getMobileNumber());
	loansDTO.setLoanNumber(loans.getLoanNumber());
	loansDTO.setLoanType(loans.getLoanType());
	loansDTO.setTotalLoan(loans.getTotalLoan());
	loansDTO.setAmountPaid(loans.getAmountPaid());
	loansDTO.setOutstandingAmount(loans.getOutstandingAmount());
	
	return loansDTO;
    }
    
    public static Loans mapToLoans(LoansDTO loansDTO, Loans loans) {
	if (loansDTO == null) {
	    return null;
	}
	if (loans == null) {
	    loans = new Loans();
	}
	loans.setMobileNumber(loansDTO.getMobileNumber());
	loans.setLoanNumber(loansDTO.getLoanNumber());
	loans.setLoanType(loansDTO.getLoanType());
	loans.setTotalLoan(loansDTO.getTotalLoan());
	loans.setAmountPaid(loansDTO.getAmountPaid());
	loans.setOutstandingAmount(loansDTO.getOutstandingAmount());
	return loans;
	
    }
    
}
