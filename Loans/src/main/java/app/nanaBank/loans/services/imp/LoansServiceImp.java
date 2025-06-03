package app.nanaBank.loans.services.imp;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import app.nanaBank.loans.constants.LoansConstants;
import app.nanaBank.loans.dto.LoansDTO;
import app.nanaBank.loans.exceptions.LoanAreadyExistsException;
import app.nanaBank.loans.exceptions.ResourceNotFoundException;
import app.nanaBank.loans.mapper.LoansMapper;
import app.nanaBank.loans.models.Loans;
import app.nanaBank.loans.repository.LoansRepository;
import app.nanaBank.loans.services.ILoansService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoansServiceImp implements ILoansService {

    private final LoansRepository loansRepository;
    
    @Override
    public void createLoan(String mobileNumber) {
	Optional<Loans> optionalLoan = loansRepository.findByMobileNumber(mobileNumber);
	if (optionalLoan.isPresent()) {
	    throw new LoanAreadyExistsException("Loan already exists for mobile number: " + mobileNumber);
	}
	
	loansRepository.save(createNewLoan(mobileNumber));
	
    }

    private Loans createNewLoan(String mobileNumber) {
	Loans loan = new Loans();
	loan.setMobileNumber(mobileNumber);
	long randomNumber = 1000000000L + new Random().nextLong(9000000000L);
	loan.setLoanNumber("LN" + randomNumber); 
	loan.setLoanType("Personal Loan"); 
	loan.setTotalLoan(LoansConstants.NEW_LOAN_LIMIT); 
	loan.setAmountPaid(0); // 
	loan.setOutstandingAmount(LoansConstants.NEW_LOAN_LIMIT); 
	return loan;
    }
    @Override
    public LoansDTO fetchLoanDetails(String mobileNumber) {
	Loans loan = loansRepository.findByMobileNumber(mobileNumber)
		.orElseThrow(() -> new ResourceNotFoundException("Loan","mobile number: ",  mobileNumber));
	return LoansMapper.mapToLoansDTO(loan, new LoansDTO());
    }

    @Override
    public boolean updateLoan(LoansDTO loansDTO) {
	Loans existingLoan = loansRepository.findByLoanNumber(loansDTO.getLoanNumber())
		.orElseThrow(() -> new ResourceNotFoundException("Loan", "loan number: ", loansDTO.getLoanNumber()));
	LoansMapper.mapToLoans(loansDTO, existingLoan);
	loansRepository.save(existingLoan);
	return true;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
	Loans existingLoan = loansRepository.findByMobileNumber(mobileNumber)
		.orElseThrow(() -> new ResourceNotFoundException("Loan", "mobile number: ", mobileNumber));
    loansRepository.deleteById(existingLoan.getLoadId());
	return true;
    }

}
