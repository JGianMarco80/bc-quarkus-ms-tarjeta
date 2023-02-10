package com.nttd.ms.tarjeta.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TarjetaDTO {

    private Long id;

    private String tipotarjeta;

    private String numeroTarjeta;

    private String pin;

    private String codigoValidacion;

    private LocalDate fechaVencimiento;

    //para tarjeta de credito
    private String numeroCuenta;

    private LocalDate fechaCorte;

    private LocalDate fechaLimitePagoMensual;

    private Double saldoActual;

    private Double limiteCredito;

}
