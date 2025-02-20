package br.com.testeitau.model;

import br.com.testeitau.model.util.ModelUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ValuationResponseTest {


    @InjectMocks
    private ValuationResponse valuationResponse;


    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);
        valuationResponse = ModelUtils.getMockValuationResponse();
    }

    @Test
    public void testvaluationResponseConfig(){

        Assertions.assertEquals(valuationResponse.getCustomer().getName(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuationResponse.getCustomer().getLocation(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuationResponse.getCustomer().getCpf(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuationResponse.getCustomer().getAge(), ModelUtils.INTEGER_MOCK);
        Assertions.assertEquals(valuationResponse.getCustomer().getValor_veiculo(), ModelUtils.DECIMAL_MOCK);
        Assertions.assertEquals(valuationResponse.getInsurances().get(0).getCost(), ModelUtils.INTEGER_MOCK);
        Assertions.assertEquals(valuationResponse.getInsurances().get(0).getType(), ModelUtils.STRING_MOCK);
    }





}
