package net.mamadou.customerservice;

import net.mamadou.customerservice.config.GlobalConfig;
import net.mamadou.customerservice.entities.Customer;
import net.mamadou.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {


			List<Customer> customerList = List.of(
					Customer.builder().firstname("Amadou")
					.lastname("Ba")
					.email("amadouba@gmail.com")
					.build(),

					Customer.builder()
							.firstname("Amadou")
							.lastname("Ba")
							.email("amadouba@gmail.com")
							.build()
					);
			//Customer customer = new Customer(null,"Amadou","Ba","amadou@gmail.com");
			//Customer customer2 = new Customer(null,"Diomaye","faye","diomaye@gmail.com");


			customerRepository.saveAll(customerList);

        };
	}


}
