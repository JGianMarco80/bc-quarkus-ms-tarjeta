package com.nttd.ms.tarjeta.repository;

import com.nttd.ms.tarjeta.entity.Tarjeta;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TarjetaRepository implements PanacheRepository<Tarjeta> {
}
