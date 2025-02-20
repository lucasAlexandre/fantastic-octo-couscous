package br.com.testeitau.config.util;

import br.com.testeitau.config.InsuranceConfiguration;
import br.com.testeitau.model.Customer;
import br.com.testeitau.model.Insurance;
import br.com.testeitau.model.ValuationResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ConfigUtils {


    public static InsuranceConfiguration getMockInsuranceConfiguration() {

        InsuranceConfiguration insuranceConfiguration = new InsuranceConfiguration();
        insuranceConfiguration.setMaxValue("70000");
        insuranceConfiguration.setMinValue("30000");
        insuranceConfiguration.setMinAge("30");
        insuranceConfiguration.setStatesTarget("SP");

        return insuranceConfiguration;
    }




}