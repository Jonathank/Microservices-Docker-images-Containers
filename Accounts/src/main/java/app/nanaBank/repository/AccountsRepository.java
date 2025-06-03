package app.nanaBank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import app.nanaBank.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    /**
     * @param customerId
     * @return
     */
    Optional<Accounts> findByCustomerId(Long customerId);
    // Additional query methods can be defined here if needed

    /**
     * @param customerId
     */
    void deleteByCustomerId(Long customerId);

}
