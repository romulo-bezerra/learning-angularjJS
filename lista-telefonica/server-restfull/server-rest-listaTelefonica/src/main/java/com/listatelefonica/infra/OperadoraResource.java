package com.listatelefonica.infra;

import com.listatelefonica.domain.Operadora;
import com.listatelefonica.service.ServiceOperadora;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Jozimar
 */
@Path("operadora")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class OperadoraResource {

    @Inject
    private ServiceOperadora service;

    @GET
    public Response recuperarTodasAsOperadoras() {
        List<Operadora> operadoras = service.listarOperadoras();
        GenericEntity<List<Operadora>> entity = new GenericEntity<List<Operadora>>(operadoras) {
        };
        return Response.ok()
                .entity(entity)
                .build();
    }

    @GET
    @Path("{id}")
    public Response recuperarOperadora(@PathParam("id") int id) {
        Operadora operadora = service.buscarOperadora(id);
        return Response.ok()
                .entity(operadora)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response removerOperadora(@PathParam("id") int id) {
        service.removerOperadora(id);
        return Response.ok()
                .build();
    }

    @POST
    public Response adicionarOperdaora(Operadora operadora) {
        service.adicionarOperadora(operadora);
        return Response.ok()
                .entity(operadora)
                .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarOperadora(@PathParam("id") int id, Operadora operadora) {
        service.atualizarOperadora(id, operadora);
        return Response.ok()
                .entity(operadora)
                .build();
    }
}
