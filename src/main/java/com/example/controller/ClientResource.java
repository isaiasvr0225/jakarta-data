package com.example.controller;

import com.example.dao.ClientDto;
import com.example.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/clients")
public class ClientResource {

    @Inject
    ClientService clientService;

    @GET
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GET
    @Path("/{id}")
    public ClientDto findById(@PathParam("id") Long id) {
        return clientService.findById(id);
    }

    @POST
    public Response save(ClientDto clientDto) {
        clientService.save(clientDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        ClientDto clientDto = clientService.findById(id);

        if (clientDto == null) return Response.status(Response.Status.NOT_FOUND).build();

        clientService.delete(id);
        return Response.status(Response.Status.OK).build();
    }

}
