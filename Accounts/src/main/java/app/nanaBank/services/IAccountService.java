package app.nanaBank.services;

import app.nanaBank.dto.CustomerDTO;

public interface IAccountService {

   void createAccount(CustomerDTO customerDTO);
/**
 * @param phoneNumber
 * @return
 */
CustomerDTO fetchAccountDetails(String phoneNumber);
/**
 * @param customerDTO
 * @return
 */
boolean updateAccountDetails(CustomerDTO customerDTO);
/**
 * @param phoneNumber
 * @return
 */
boolean deleteAccount(String phoneNumber);
   
}
