package com.nttd.ms.tarjeta.resource;

import com.nttd.ms.tarjeta.dto.TarjetaDTO;
import com.nttd.ms.tarjeta.entity.Tarjeta;
import com.nttd.ms.tarjeta.service.TarjetaService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tarjeta")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TarjetaResource {

    @Inject
    TarjetaService tarjetaService;

    @GET
    public List<Tarjeta> findAll() {
        return tarjetaService.findAll();
    }

    @GET
    @Path("/{id}")
    public Tarjeta findAll(@PathParam("id") Long id) {
        return tarjetaService.findById(id);
    }

    @POST
    @Transactional
    public void save(TarjetaDTO tarjeta){
        tarjetaService.save(tarjeta);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void update(@PathParam("id") Long id, Tarjeta tarjeta){
        tarjetaService.update(id, tarjeta);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(@PathParam("id") Long id){
        tarjetaService.delete(id);
    }
}
