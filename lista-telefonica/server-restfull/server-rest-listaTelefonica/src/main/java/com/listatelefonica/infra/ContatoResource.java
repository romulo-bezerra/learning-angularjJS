package com.listatelefonica.infra;

import com.listatelefonica.domain.Contato;
import com.listatelefonica.service.ServiceContato;
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
@Path("contato")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class ContatoResource {

    @Inject
    private ServiceContato service;

    @GET
    public Response recuperarTodosOsContatos() {
        List<Contato> contatos = service.listarContatos();
        GenericEntity<List<Contato>> entity = new GenericEntity<List<Contato>>(contatos) {
        };
        return Response.ok()
                .entity(entity)
                .build();
    }

    @GET
    @Path("{id}")
    public Response recuperarContato(@PathParam("id") int id) {
        Contato contato = service.buscarContato(id);
        return Response.ok()
                .entity(contato)
                .build();
    }

    @DELETE
    @Path("{id}")
    public Response removerContato(@PathParam("id") int id) {
        service.removerContato(id);
        return Response.ok()
                .build();
    }

    @POST
    public Response adicionarContato(Contato contato) {
        service.adicionarContato(contato);
        return Response.ok()
                .entity(contato)
                .build();
    }

    @PUT
    @Path("{id}")
    public Response atualizarContato(@PathParam("id") int id, Contato contato) {
        service.atualizarContato(id, contato);
        return Response.ok()
                .entity(contato)
                .build();
    }
}
