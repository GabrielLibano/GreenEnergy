package com.gabriellibano.greenenergy.greenenergy.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Dispositivos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 3)
    private Double kwh;

    @Column(nullable = false, length = 5)
    private Double gastoLimite;

    @Column(nullable = false, length = 60)
    private String tipo;

    @Column(nullable = false, length = 4)
    private String volts;

}
