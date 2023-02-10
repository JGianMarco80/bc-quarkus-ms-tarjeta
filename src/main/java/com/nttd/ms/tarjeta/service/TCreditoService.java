package com.nttd.ms.tarjeta.service;

import com.nttd.ms.tarjeta.entity.TCredito;

import java.util.List;

public interface TCreditoService {

    List<TCredito> findAll();

    TCredito findById(Long id);

    void save(TCredito tCredito);

    void update(Long id, TCredito tCredito);

    void delete(Long id);

}
