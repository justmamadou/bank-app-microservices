package net.mamadou.accountservice;

import net.mamadou.accountservice.entities.BankAccount;
import net.mamadou.accountservice.enums.AccountType;
import net.mamadou.accountservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(BankAccountRepository bankAccountRepository) {
		return args ->  {

			List<BankAccount> accountList = List.of(BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.currency("MRU")
							.balance(560000)
							.createdAt(LocalDate.now())
							.type(AccountType.SAVING_ACCOUNT)
							.customerId(Long.valueOf(1))
							.build(),
					BankAccount.builder()
							.accountId(UUID.randomUUID().toString())
							.currency("MRU")
							.balance(9800000)
							.createdAt(LocalDate.now())
							.type(AccountType.CURRENT_TYPE)
							.customerId(Long.valueOf(2))
							.build()
			);


			bankAccountRepository.saveAll(accountList);



		};
	}

}
