package com.nttd.ms.tarjeta.repository;

import com.nttd.ms.tarjeta.entity.TCredito;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TCreditoRepository implements PanacheRepository<TCredito> {
}
