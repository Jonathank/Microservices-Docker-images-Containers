/**
 * 
 */
package app.nanaBank.mapper;

import app.nanaBank.dto.AccountsDTO;
import app.nanaBank.model.Accounts;

/**
 * @author JONATHAN
 */
public class AccountsMapper {

    public static AccountsDTO mapToAccountsDTO(Accounts accounts, AccountsDTO accountsDTO) {
	if (accounts == null) {
	    return null;
	}
	if (accountsDTO == null) {
	    accountsDTO = new AccountsDTO();
	}
	
	accountsDTO.setAccountNumber(accounts.getAccountNumber());
	accountsDTO.setAccountName(accounts.getAccountName());
	accountsDTO.setAccountType(accounts.getAccountType());
	accountsDTO.setAccountStatus(accounts.getAccountStatus());
	accountsDTO.setBranchName(accounts.getBranchName());
	accountsDTO.setBranchAddress(accounts.getBranchAddress());
	
	return accountsDTO;
    }
    
    public static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts) {
	if (accountsDTO == null) {
	    return null;
	}
	if (accounts == null) {
	    accounts = new Accounts();
	}
	accounts.setAccountNumber(accountsDTO.getAccountNumber());
	accounts.setAccountName(accountsDTO.getAccountName());
	accounts.setAccountType(accountsDTO.getAccountType());
	accounts.setAccountStatus(accountsDTO.getAccountStatus());
	accounts.setBranchName(accountsDTO.getBranchName());
	accounts.setBranchAddress(accountsDTO.getBranchAddress());
	return accounts;
	
    }
}
