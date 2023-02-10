package com.nttd.ms.tarjeta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarjeta {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_tarjeta")
    private String tipotarjeta;

    @Column(name = "numero_tarjeta")
    private String numeroTarjeta;

    @Column(name = "pin")
    private String pin;

    @Column(name = "codigo_validacion")
    private String codigoValidacion;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @Column(name = "estado")
    private String estado = "1";
}
