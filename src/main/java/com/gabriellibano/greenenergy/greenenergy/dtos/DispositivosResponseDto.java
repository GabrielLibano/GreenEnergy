package com.gabriellibano.greenenergy.greenenergy.dtos;
import lombok.Data;

@Data
public class DispositivosResponseDto {
    private long id;
    private String nome;
    private Double kwh;
    private Double gastoLimite;
    private String tipo;
    private String volts;
}
