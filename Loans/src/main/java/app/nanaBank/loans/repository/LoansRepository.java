package app.nanaBank.loans.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.nanaBank.loans.models.Loans;

public interface LoansRepository extends JpaRepository<Loans, Long> {

    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);


}
