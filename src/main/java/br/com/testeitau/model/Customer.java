package br.com.testeitau.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    String name;
    String cpf;
    Integer age;
    String location;
    Double valor_veiculo;

}
