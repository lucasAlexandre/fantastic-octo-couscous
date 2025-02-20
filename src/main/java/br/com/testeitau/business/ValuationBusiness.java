package br.com.testeitau.business;

import br.com.testeitau.config.InsuranceConfiguration;
import br.com.testeitau.enumeration.InsuranceType;
import br.com.testeitau.model.Customer;
import br.com.testeitau.model.Insurance;
import br.com.testeitau.model.Valuation;
import br.com.testeitau.model.ValuationResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Log4j2
public class ValuationBusiness {



    private InsuranceConfiguration insuranceConfiguration;

    @Autowired
    public ValuationBusiness(InsuranceConfiguration insuranceConfiguration) {
        this.insuranceConfiguration = insuranceConfiguration;
    }


    public ValuationResponse doValuation(Valuation valuation){
        Instant startingPoint = Instant.now();
        //Objetos globais
        ValuationResponse response  = new ValuationResponse();
        List<Insurance> insurances = new ArrayList<>();
        Customer customer = new Customer();


        //Parametrização da aplicação
        int MAX_VALUE = Integer.parseInt(insuranceConfiguration.getMaxValue());
        int MIN_VALUE = Integer.parseInt(insuranceConfiguration.getMinValue());
        int MIN_AGE = Integer.parseInt(insuranceConfiguration.getMinAge());
        String[] stateTargets = insuranceConfiguration.getStatesTarget().split(";");
        List<String> stateTargetList = Arrays.stream(stateTargets).toList();

        //Seguro basico esta em todas modalidades.
        insurances.add(new Insurance(InsuranceType.BASIC.getName(), InsuranceType.BASIC.getValue()));

        //Carregando variaveis para business
        int idade= valuation.getCustomer().getAge();
        boolean isStateTarget = stateTargetList.contains(valuation.getCustomer().getLocation());
        Double valor = valuation.getCustomer().getValor_veiculo();

        //Iniciando regras de negocio
        if((valor <= MIN_VALUE) && (isStateTarget) && (idade < MIN_AGE)){
            insurances.add(new Insurance(InsuranceType.PARTIAL.getName(), InsuranceType.PARTIAL.getValue()));
        }

        if((valor > MIN_VALUE && valor < MAX_VALUE) && (isStateTarget)){
            insurances.add(new Insurance(InsuranceType.PARTIAL.getName(), InsuranceType.PARTIAL.getValue()));
        }
        if ((valor >= MAX_VALUE)  && (idade < MIN_AGE)) {
            insurances.add(new Insurance(InsuranceType.TOTAL.getName(), InsuranceType.TOTAL.getValue()));
            insurances.add(new Insurance(InsuranceType.PARTIAL.getName(), InsuranceType.PARTIAL.getValue()));
        }

        if ((valor >= MAX_VALUE)  && (idade > MIN_AGE)) {
            insurances.add(new Insurance(InsuranceType.TOTAL.getName(), InsuranceType.TOTAL.getValue()));
        }

        //Aplicando Valores obtidos
        customer.setName(valuation.getCustomer().getName());
        response.setCustomer(customer);
        response.setInsurances(insurances);

        log.info(
                "Tempo total para as avaliação {}  s",
                Duration.between(startingPoint, Instant.now()).getSeconds());

        return response;

    }


}
