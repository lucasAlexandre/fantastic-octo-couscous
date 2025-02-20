package br.com.testeitau.model;

import br.com.testeitau.model.util.ModelUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ValuationTest {


    @InjectMocks
    private Valuation valuation;

    private Customer customer;

    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);

        valuation = ModelUtils.getMockValuation();

    }

    @Test
    public void testValuationConfig(){

        Assertions.assertEquals(valuation.getCustomer().getName(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuation.getCustomer().getLocation(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuation.getCustomer().getCpf(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(valuation.getCustomer().getAge(), ModelUtils.INTEGER_MOCK);
        Assertions.assertEquals(valuation.getCustomer().getValor_veiculo(), ModelUtils.DECIMAL_MOCK);

    }





}
