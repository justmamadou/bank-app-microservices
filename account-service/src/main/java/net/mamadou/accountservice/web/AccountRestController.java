package net.mamadou.accountservice.web;


import net.mamadou.accountservice.clients.CustomerRestClient;
import net.mamadou.accountservice.entities.BankAccount;
import net.mamadou.accountservice.model.Customer;
import net.mamadou.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;


    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount>  accountList() {

        List<BankAccount> accountList = bankAccountRepository.findAll();
        accountList.forEach(c -> {
            Customer customer = customerRestClient.findCustomerById(c.getCustomerId());
            c.setCustomer(customer);
        });
        return accountList;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {


        BankAccount bankAccount = bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return  bankAccount;
    }

}
