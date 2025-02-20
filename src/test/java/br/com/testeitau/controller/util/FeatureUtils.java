package br.com.testeitau.controller.util;

import br.com.testeitau.model.Valuation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.IOException;

public class FeatureUtils {
    public static String URL = "http://localhost:8080/valuation";
    public static Valuation getMockValuation() {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("features/Valuation.json");
        try {
            return objectMapper.readValue(resource.getInputStream(), Valuation.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}