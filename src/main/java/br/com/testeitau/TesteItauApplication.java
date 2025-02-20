package br.com.testeitau;

import br.com.testeitau.config.InsuranceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(InsuranceConfiguration.class)
public class TesteItauApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesteItauApplication.class, args);
	}

}
