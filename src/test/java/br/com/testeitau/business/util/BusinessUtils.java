package br.com.testeitau.business.util;

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
public class BusinessUtils {


    public static final String STRING_MOCK = "test";
    public static final double DECIMAL_MOCK = 30000d;
    public static final int INTEGER_MOCK = 22;

    public static Customer getMockCustomer() {
        Customer customer = new Customer();
        customer.setName(STRING_MOCK);
        customer.setCpf(STRING_MOCK);
        customer.setAge(22);
        customer.setLocation("SP");
        customer.setValor_veiculo(30000d);
        return customer;
    }

    public static Customer getMockCustomer1() {
        Customer customer = new Customer();
        customer.setName(STRING_MOCK);
        customer.setCpf(STRING_MOCK);
        customer.setAge(22);
        customer.setLocation("SP");
        customer.setValor_veiculo(35000d);

        return customer;
    }

    public static Customer getMockCustomer2() {
        Customer customer = new Customer();
        customer.setName(STRING_MOCK);
        customer.setCpf(STRING_MOCK);
        customer.setAge(21);
        customer.setLocation("SP");
        customer.setValor_veiculo(75000d);
        return customer;
    }

    public static Customer getMockCustomer3() {
        Customer customer = new Customer();
        customer.setName(STRING_MOCK);
        customer.setCpf(STRING_MOCK);
        customer.setAge(50);
        customer.setLocation("SP");
        customer.setValor_veiculo(175000d);

        return customer;
    }

    public static Insurance getMockInsurance() {
        Insurance insurance = new Insurance();
        insurance.setCost(INTEGER_MOCK);
        insurance.setType(STRING_MOCK);
        return insurance;
    }

    public static List<Insurance> getMockInsuranceList() {
        return Arrays.asList(getMockInsurance());
    }

    public static ValuationResponse getMockValuationResponse() {
       
        ValuationResponse valuationResponse = new ValuationResponse();
        valuationResponse.setCustomer(getMockCustomer());    
        valuationResponse.setInsurances(getMockInsuranceList());
     
        return valuationResponse;
    }

    public static ValuationResponse getMockValuationResponse1() {

        ValuationResponse valuationResponse = new ValuationResponse();
        valuationResponse.setCustomer(getMockCustomer1());
        valuationResponse.setInsurances(getMockInsuranceList());

        return valuationResponse;
    }

    public static ValuationResponse getMockValuationResponse2() {

        ValuationResponse valuationResponse = new ValuationResponse();
        valuationResponse.setCustomer(getMockCustomer2());
        valuationResponse.setInsurances(getMockInsuranceList());

        return valuationResponse;
    }

    public static ValuationResponse getMockValuationResponse3() {

        ValuationResponse valuationResponse = new ValuationResponse();
        valuationResponse.setCustomer(getMockCustomer3());
        valuationResponse.setInsurances(getMockInsuranceList());

        return valuationResponse;
    }

    public static InsuranceConfiguration getMockInsuranceConfiguration() {

        InsuranceConfiguration insuranceConfiguration = new InsuranceConfiguration();
        insuranceConfiguration.setMaxValue("70000");
        insuranceConfiguration.setMinValue("30000");
        insuranceConfiguration.setMinAge("30");
        insuranceConfiguration.setStatesTarget("SP");

        return insuranceConfiguration;
    }




}