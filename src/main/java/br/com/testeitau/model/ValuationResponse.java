package br.com.testeitau.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ValuationResponse extends Valuation{

    List<Insurance> insurances;
}
