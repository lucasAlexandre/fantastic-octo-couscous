package br.com.testeitau.model.util;

import br.com.testeitau.model.Customer;
import br.com.testeitau.model.Insurance;
import br.com.testeitau.model.Valuation;
import br.com.testeitau.model.ValuationResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class ModelUtils {


    public static final String STRING_MOCK = "test";
    public static final double DECIMAL_MOCK = 30000d;
    public static final int INTEGER_MOCK = 22;

    public static Customer getMockCustomer() {
        Customer customer = new Customer();
        customer.setName(STRING_MOCK);
        customer.setCpf(STRING_MOCK);
        customer.setAge(INTEGER_MOCK);
        customer.setLocation(STRING_MOCK);
        customer.setValor_veiculo(DECIMAL_MOCK);
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
        valuationResponse.setInsurances(ModelUtils.getMockInsuranceList());

        return valuationResponse;
    }

    public static Valuation getMockValuation() {

        Valuation valuation = new ValuationResponse();
        valuation.setCustomer(getMockCustomer());

        return valuation;
    }

}