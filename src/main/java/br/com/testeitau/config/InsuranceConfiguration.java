package br.com.testeitau.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "insurance.parameters")
public class InsuranceConfiguration {

    String minValue;
    String maxValue;
    String minAge;
    //Pode ser mais de um valor separado por ";"
    String statesTarget;


}
