package com.nttd.ms.tarjeta.util;

import com.nttd.ms.tarjeta.dto.TarjetaDTO;
import com.nttd.ms.tarjeta.entity.TCredito;
import com.nttd.ms.tarjeta.entity.Tarjeta;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarjetaUtil {

    public Tarjeta saveTarjeta(TarjetaDTO tarjetaDTO){
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setTipotarjeta(tarjetaDTO.getTipotarjeta());
        tarjeta.setNumeroTarjeta(tarjetaDTO.getNumeroTarjeta());
        tarjeta.setPin(tarjetaDTO.getPin());
        tarjeta.setCodigoValidacion(tarjetaDTO.getCodigoValidacion());
        tarjeta.setFechaVencimiento(tarjetaDTO.getFechaVencimiento());
        return tarjeta;
    }

    public TCredito saveTCredito(TarjetaDTO tarjetaDTO){
        TCredito tCredito = new TCredito();
        tCredito.setNumeroCuenta(tarjetaDTO.getNumeroCuenta());
        tCredito.setFechaCorte(tarjetaDTO.getFechaCorte());
        tCredito.setFechaLimitePagoMensual(tarjetaDTO.getFechaLimitePagoMensual());
        tCredito.setSaldoActual(tarjetaDTO.getSaldoActual());
        tCredito.setLimiteCredito(tarjetaDTO.getLimiteCredito());
        tCredito.setTarjetaId(tarjetaDTO.getId());
        return tCredito;
    }
}
