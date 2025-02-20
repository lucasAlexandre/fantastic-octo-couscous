package br.com.testeitau.business;

import br.com.testeitau.business.util.BusinessUtils;
import br.com.testeitau.config.InsuranceConfiguration;
import br.com.testeitau.model.Customer;
import br.com.testeitau.model.Valuation;
import br.com.testeitau.model.ValuationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

public class ValuationBusinessTest {


    @InjectMocks
    private ValuationBusiness valuationBusiness;
    InsuranceConfiguration insuranceConfiguration;

    Valuation valuation;
    Valuation valuation1;
    Valuation valuation2;
    Valuation valuation3;

    Customer customer;
    Customer customer1;
    Customer customer2;
    Customer customer3;
    ValuationResponse valuationResponse ;

    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);

        valuation  = BusinessUtils.getMockValuationResponse();
        valuation1 = BusinessUtils.getMockValuationResponse1();
        valuation2 = BusinessUtils.getMockValuationResponse2();;
        valuation3 = BusinessUtils.getMockValuationResponse3();

        ReflectionTestUtils.setField(valuationBusiness, "insuranceConfiguration", BusinessUtils.getMockInsuranceConfiguration());

    }

    @Test
    public void testValuationFirstIf(){

        valuationResponse = valuationBusiness.doValuation(valuation);
        Assertions.assertNotNull(valuationResponse);

    }

    @Test
    public void testValuationSecondIf(){

        valuationResponse = valuationBusiness.doValuation(valuation1);
        Assertions.assertNotNull(valuationResponse);

    }

    @Test
    public void testValuationThrdIf(){

        valuationResponse = valuationBusiness.doValuation(valuation2);
        Assertions.assertNotNull(valuationResponse);

    }

    @Test
    public void testValuationLastIf(){

        valuationResponse = valuationBusiness.doValuation(valuation3);
        Assertions.assertNotNull(valuationResponse);

    }



}
