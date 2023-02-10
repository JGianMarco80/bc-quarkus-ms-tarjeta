package com.nttd.ms.tarjeta.service.impl;

import com.nttd.ms.tarjeta.entity.TCredito;
import com.nttd.ms.tarjeta.repository.TCreditoRepository;
import com.nttd.ms.tarjeta.service.TCreditoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TCreditoServiceImpl implements TCreditoService {

    @Inject
    TCreditoRepository tCreditoRepository;

    @Override
    public List<TCredito> findAll() {
        List<TCredito> tCreditos = tCreditoRepository.listAll();
        List<TCredito> tCreditosActivas = new ArrayList<>();

        for (TCredito tCredito : tCreditos) {
            if(tCredito.getEstado().equals("1")){
                tCreditosActivas.add(tCredito);
            }
        }

        return tCreditosActivas;
    }

    @Override
    public TCredito findById(Long id) {
        return tCreditoRepository.findById(id);
    }

    @Override
    public void save(TCredito tCredito) {
        tCreditoRepository.persist(tCredito);
    }

    @Override
    public void update(Long id, TCredito tCredito) {
        TCredito tcObtenida = tCreditoRepository.findById(id);
        tcObtenida.setFechaCorte(tCredito.getFechaCorte());
        tcObtenida.setFechaLimitePagoMensual(tCredito.getFechaLimitePagoMensual());
        tcObtenida.setSaldoActual(tCredito.getSaldoActual());
        tcObtenida.setLimiteCredito(tCredito.getLimiteCredito());
        tCreditoRepository.persist(tcObtenida);
    }

    @Override
    public void delete(Long id) {
        TCredito tcObtenida = tCreditoRepository.findById(id);
        tcObtenida.setEstado("0");
        tCreditoRepository.persist(tcObtenida);
    }
}
