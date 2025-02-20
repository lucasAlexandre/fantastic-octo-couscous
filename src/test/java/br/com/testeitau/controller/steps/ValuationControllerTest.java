package br.com.testeitau.controller.steps;


import br.com.testeitau.controller.util.FeatureUtils;
import br.com.testeitau.model.Valuation;
import br.com.testeitau.model.ValuationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    private Valuation mockValuation = FeatureUtils.getMockValuation();
    private ResponseEntity<ValuationResponse> response;
    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
    String json = ow.writeValueAsString(mockValuation);

    public ValuationControllerTest() throws JsonProcessingException {
    }

    @Given("an valuation with Parameters")
    public void anExistingAccountWithID() throws JsonProcessingException {
        // use the mock account saved
        this.mockValuation = FeatureUtils.getMockValuation();
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        json = ow.writeValueAsString(mockValuation);
    }

    @When("the user sends a GET request to {string}")
    public void theUserSendsAGETRequestTo(String path) {

        String url = FeatureUtils.URL + path;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        response = this.restTemplate.postForEntity(url, entity, ValuationResponse.class);
    }

    @Then("the response status code of getting an account should be {int}")
    public void theResponseStatusCodeOfGettingAnAccountShouldBe(int statusCode) {
        assertEquals(HttpStatusCode.valueOf(statusCode), response.getStatusCode());
    }

    @And("the response body should contain the account details")
    public void theResponseBodyShouldContainTheAccountDetails() {
        ValuationResponse resAccount = response.getBody();
        assert resAccount != null;
        assertEquals("João", resAccount.getCustomer().getName());
    }
}