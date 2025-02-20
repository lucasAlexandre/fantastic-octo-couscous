package br.com.testeitau.model;

import br.com.testeitau.model.util.ModelUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class InsuranceTest {


    @InjectMocks
    private Insurance insurance;

    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);

        insurance = ModelUtils.getMockInsurance();

    }

    @Test
    public void testInsuranceConfig(){

        Assertions.assertEquals(insurance.getCost(),ModelUtils.INTEGER_MOCK);
        Assertions.assertEquals(insurance.getType(), ModelUtils.STRING_MOCK);


    }





}
