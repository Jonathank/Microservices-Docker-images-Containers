package app.nanaBank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
/*
 * @EnableJpaAuditing is used to enable JPA auditing features
 * It allows us to automatically populate fields 
 * like createdAt, updatedAt, createdBy, and updatedBy in our entities
 * This is particularly useful for tracking
 * The  auditorAwareRef = "auditAwareImpl" specifies the bean name of the AuditorAware implementation
 */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
/**
 * @OpenAPIDefinition is used to enable OpenAPI documentation for the application
 * It allows us to generate API documentation automatically
 * This is useful for providing clear and structured API documentation
 * @Info annotation is used to provide metadata about the API
 * It includes the title and description of the API
 */
@OpenAPIDefinition(
	info = @Info(
		title = "Accounts Microservice API",
		description = "RestAPIs for managing accounts in the NanaBank application",
		version = "1.0.0",
		contact = @Contact(
			name = "Kyeyune Jonathan",
			email = "kyeyunejonathan001@gmail.com",
		        url = "https://github.com/Jonathank"+"\nhttps://www.linkedin.com/in/kyeyune-jonathan"
			
			),
		license = @License(
			name = "Apache License Version 2.0",
			url = "https://github.com/Jonathank/Accounts-Microservices"
		),
		summary = "This is a summary of the Accounts Microservice API."
				+ " It provides endpoints for managing accounts in "
				+ "the NanaBank application. "
				+ "The API allows users to create, read, update, and delete accounts, "
				+ "as well as perform various operations related to account management."
		
	))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
