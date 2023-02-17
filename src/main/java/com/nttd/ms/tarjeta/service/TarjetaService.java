package com.nttd.ms.tarjeta.service;

import com.nttd.ms.tarjeta.dto.TarjetaDTO;
import com.nttd.ms.tarjeta.entity.Tarjeta;

import java.util.List;

public interface TarjetaService {

    List<Tarjeta> findAll();

    Tarjeta findById(Long id);

    void save(TarjetaDTO tarjetaDTO);

    void update(Long id, Tarjeta tarjeta);

    void delete(Long id);

    Tarjeta findByNumeroTarjeta(String numeroTarjeta);

}
