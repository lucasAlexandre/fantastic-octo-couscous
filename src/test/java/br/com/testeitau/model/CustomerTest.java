package br.com.testeitau.model;

import br.com.testeitau.model.util.ModelUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CustomerTest {


    @InjectMocks
    private Customer customer;


    @BeforeEach
    public void beforeTests(){
        MockitoAnnotations.initMocks(this);
        customer = ModelUtils.getMockCustomer();
    }

    @Test
    public void testCustomerConfig(){

        Assertions.assertEquals(customer.getName(),ModelUtils.STRING_MOCK);
        Assertions.assertEquals(customer.getCpf(), ModelUtils.STRING_MOCK);
        Assertions.assertEquals(customer.getAge(), ModelUtils.INTEGER_MOCK);
        Assertions.assertEquals(customer.getLocation(),ModelUtils.STRING_MOCK);
        Assertions.assertEquals(customer.getValor_veiculo(),ModelUtils.DECIMAL_MOCK);


    }





}
