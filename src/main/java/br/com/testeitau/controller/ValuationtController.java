package br.com.testeitau.controller;

import br.com.testeitau.business.ValuationBusiness;
import br.com.testeitau.model.Valuation;
import br.com.testeitau.model.ValuationResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;


@Log4j2
@RestController
@RequestMapping(value = "/valuation")

public class ValuationtController {



    ValuationBusiness valuationBusiness;

    @Autowired
    public ValuationtController(ValuationBusiness valuationBusiness) {
        this.valuationBusiness = valuationBusiness;
    }

    @PostMapping(value = "/test",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ValuationResponse> doValuation(@RequestBody Valuation valuation) {

        Instant startingPoint = Instant.now();

        ValuationResponse response;
        try{
            response = valuationBusiness.doValuation(valuation);
        } catch (Exception e) {
            log.error("Erro ao executar a aplicação", e.getMessage());
            return new ResponseEntity<>(HttpStatusCode.valueOf(500));
        }

        log.info(
                "Tempo total para as consulta {} s Nome: {}  idade: {} localização {}, valor veiculo: {}  ",
                Duration.between(startingPoint, Instant.now()).getSeconds(), valuation.getCustomer().getName(), valuation.getCustomer().getAge(), valuation.getCustomer().getLocation(), valuation.getCustomer().getValor_veiculo());

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
    }

}