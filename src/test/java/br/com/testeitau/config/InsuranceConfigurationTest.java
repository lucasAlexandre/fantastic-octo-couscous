package br.com.testeitau.config;

import br.com.testeitau.config.util.ConfigUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class InsuranceConfigurationTest {


    @InjectMocks
    private InsuranceConfiguration insuranceConfiguration;

    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);

        insuranceConfiguration = ConfigUtils.getMockInsuranceConfiguration();

    }

    @Test
    public void testInsuranceConfig(){

        Assertions.assertEquals(insuranceConfiguration.getMaxValue(),"70000");
        Assertions.assertEquals(insuranceConfiguration.getMinValue(), "30000");
        Assertions.assertEquals(insuranceConfiguration.getMinAge(), "30");
        Assertions.assertEquals(insuranceConfiguration.getStatesTarget(),"SP");


    }





}
