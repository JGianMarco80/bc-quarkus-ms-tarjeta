package com.nttd.ms.tarjeta.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "t_credito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TCredito {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "fecha_corte")
    private LocalDate fechaCorte;

    @Column(name = "fecha_limite_pago_mensual")
    private LocalDate fechaLimitePagoMensual;

    @Column(name = "saldo_actual")
    private Double saldoActual;

    @Column(name = "limite_credito")
    private Double limiteCredito;

    @Column(name = "tarjeta_id")
    private Long tarjetaId;

    //@Column(name = "cliente_id")
    //private Long clienteId;

    @Column(name = "estado")
    private String estado = "1";
}
