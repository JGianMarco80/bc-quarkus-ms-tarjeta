package com.nttd.ms.tarjeta.service.impl;

import com.nttd.ms.tarjeta.dto.TarjetaDTO;
import com.nttd.ms.tarjeta.entity.TCredito;
import com.nttd.ms.tarjeta.entity.Tarjeta;
import com.nttd.ms.tarjeta.repository.TarjetaRepository;
import com.nttd.ms.tarjeta.service.TCreditoService;
import com.nttd.ms.tarjeta.service.TarjetaService;
import com.nttd.ms.tarjeta.util.TarjetaUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TarjetaServiceImpl implements TarjetaService {

    @Inject
    TarjetaRepository tarjetaRepository;

    @Inject
    TCreditoService tCreditoService;

    @Inject
    TarjetaUtil tarjetaUtil;

    @Override
    public List<Tarjeta> findAll() {
        List<Tarjeta> tarjetas = tarjetaRepository.listAll();
        List<Tarjeta> tarjetasActivas = new ArrayList<>();

        for (Tarjeta tarjeta : tarjetas) {
            if(tarjeta.getEstado().equals("1")){
                tarjetasActivas.add(tarjeta);
            }
        }

        return tarjetasActivas;
    }

    @Override
    public Tarjeta findById(Long id) {
        return tarjetaRepository.findById(id);
    }

    @Override
    public void save(TarjetaDTO tarjetaDTO) {
        Tarjeta tarjeta = tarjetaUtil.saveTarjeta(tarjetaDTO);
        tarjetaRepository.persist(tarjeta);

        tarjetaDTO.setId(tarjeta.getId());

        if(tarjeta.getTipotarjeta().equals("2")){
            TCredito tCredito = tarjetaUtil.saveTCredito(tarjetaDTO);
            tCreditoService.save(tCredito);
        }
    }

    @Override
    public void update(Long id, Tarjeta tarjeta) {
        Tarjeta tObtenida = tarjetaRepository.findById(id);
        tObtenida.setTipotarjeta(tarjeta.getTipotarjeta());
        tObtenida.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        tObtenida.setPin(tarjeta.getPin());
        tObtenida.setCodigoValidacion(tarjeta.getCodigoValidacion());
        tObtenida.setFechaVencimiento(tarjeta.getFechaVencimiento());
        tarjetaRepository.persist(tObtenida);
    }

    @Override
    public void delete(Long id) {
        Tarjeta tObtenida = tarjetaRepository.findById(id);
        tObtenida.setEstado("0");
        tarjetaRepository.persist(tObtenida);
    }

    @Override
    public Tarjeta findByNumeroTarjeta(String numeroTarjeta) {
        List<Tarjeta> tarjetas = tarjetaRepository.listAll();
        Tarjeta tObtenida = new Tarjeta();

        for (Tarjeta t: tarjetas) {
            if(t.getNumeroTarjeta().equals(numeroTarjeta)) {
                tObtenida = t;
            }
        }

        return tObtenida;
    }
}
