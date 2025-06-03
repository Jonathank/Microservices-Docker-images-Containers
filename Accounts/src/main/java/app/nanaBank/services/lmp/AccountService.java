/**
 * 
 */
package app.nanaBank.services.lmp;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import app.nanaBank.constants.AccountsConstants;
import app.nanaBank.dto.AccountsDTO;
import app.nanaBank.dto.CustomerDTO;
import app.nanaBank.exceptions.CustomerAlreadyExistException;
import app.nanaBank.exceptions.ResourceNotFoundException;
import app.nanaBank.mapper.AccountsMapper;
import app.nanaBank.mapper.CustomerMapper;
import app.nanaBank.model.Accounts;
import app.nanaBank.model.Customer;
import app.nanaBank.repository.AccountsRepository;
import app.nanaBank.repository.CustomerRepository;
import app.nanaBank.services.IAccountService;
import lombok.AllArgsConstructor;

/**
 * @author JONATHAN
 */
@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private final AccountsRepository accountRepository;
    private final CustomerRepository customerRepository;
    
    @Override
    public void createAccount(CustomerDTO customerDTO) {
	Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
	Optional<Customer> existingCustomer = customerRepository.findByPhoneNumber(customer.getPhoneNumber());
	if (existingCustomer.isPresent()) {
	    throw new CustomerAlreadyExistException("Customer already registered with given mobileNumber"
	+ customer.getPhoneNumber());
	}
	Customer savedcustomer = customerRepository.save(customer);
	
	accountRepository.save(createNewAccount(savedcustomer));
    }
    
    private Accounts createNewAccount(Customer customer) {
	Accounts account = new Accounts();
	account.setCustomerId(customer.getCustomerId());
	account.setAccountName(customer.getName());
	account.setAccountType(AccountsConstants.ACCOUNT_TYPE_SAVINGS);
 	account.setAccountStatus(AccountsConstants.ACCOUNT_STATUS_ACTIVE);
	account.setBranchName(AccountsConstants.BRANCH_NAME);
	account.setBranchAddress(AccountsConstants.BRANCH_ADDRESS);
	Long randomNumber = 1000000000L + new Random().nextLong(9000000000L);
	account.setAccountNumber(randomNumber);
	
	return account;
    }
    
    
    @Override
    public CustomerDTO fetchAccountDetails(String phoneNumber) {
	Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
	.orElseThrow(() -> 
	 new ResourceNotFoundException("Customer","mobileNumber", phoneNumber));
	
	Accounts account = accountRepository.findByCustomerId(customer.getCustomerId())
		.orElseThrow(() -> 
		    new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
	CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
	customerDTO.setAccountsDetails(AccountsMapper.mapToAccountsDTO(account, new AccountsDTO()));
	return customerDTO;
	
    }

    @Override
    public boolean updateAccountDetails(CustomerDTO customerDTO) {
	boolean isUpdated = false;
	AccountsDTO accountsDTO = customerDTO.getAccountsDetails();
	if(accountsDTO != null) {
	    Accounts accounts = accountRepository.findById(accountsDTO.getAccountNumber())
		    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", accountsDTO.getAccountNumber().toString()));
	    AccountsMapper.mapToAccounts(accountsDTO, accounts);
	    accounts = accountRepository.save(accounts);
	    
	    Long customerId = accounts.getCustomerId();
	    Customer customer = customerRepository.findById(customerId)
		    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", customerId.toString()));
	    CustomerMapper.mapToCustomer(customerDTO, customer);
	    customerRepository.save(customer);
	    isUpdated = true;
	}
	return isUpdated; 
    }
    
    @Override
    public boolean deleteAccount(String phoneNumber) {
	Customer customer = customerRepository.findByPhoneNumber(phoneNumber)
		.orElseThrow(() -> 
		    new ResourceNotFoundException("Customer", "mobileNumber", phoneNumber));
	accountRepository.deleteByCustomerId(customer.getCustomerId());
	customerRepository.deleteById(customer.getCustomerId());
	return true;
    }
}
