package app.nanaBank.loans.services;

import app.nanaBank.loans.dto.LoansDTO;

public interface ILoansService {

    void createLoan(String mobileNumber);

    LoansDTO fetchLoanDetails(String mobileNumber);

    boolean updateLoan(LoansDTO loansDTO);

    boolean deleteLoan(String mobileNumber);

}
