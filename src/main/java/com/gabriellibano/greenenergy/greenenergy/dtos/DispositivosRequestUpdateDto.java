package com.gabriellibano.greenenergy.greenenergy.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispositivosRequestUpdateDto {
    private String nome;
    private Double kwh;
    private Double gastoLimite;
    private String tipo;
    private String volts;
}
