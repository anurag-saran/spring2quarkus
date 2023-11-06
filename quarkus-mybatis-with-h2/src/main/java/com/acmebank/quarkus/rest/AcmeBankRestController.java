package com.acmebank.quarkus.rest;

import com.acmebank.quarkus.model.AcmeBank;
import com.acmebank.quarkus.repo.AcmeBankRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/acmebank")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcmeBankRestController {

    private final AcmeBankRepo acmeBankRepo;

    @Inject
    public AcmeBankRestController(AcmeBankRepo acmeBankRepo){
        this.acmeBankRepo = acmeBankRepo;
    }

    @POST
    @Path("create")
    @Transactional
    public String createAcmeAccount(AcmeBank acmeBank) {
        acmeBankRepo.insert(acmeBank);
        return "Account created successfully";
    }

    @PUT
    @Path("update")
    @Transactional
    public String updateAcmeAccount(AcmeBank acmeBank) {
        acmeBankRepo.update(acmeBank);
        return "Account Updated successfully";
    }

    @GET
    @Path("get")
    public List<AcmeBank> getAllAccount() {
        return acmeBankRepo.findAll();
    }

    @GET
    @Path("/get/{id}")
    public Response getParticularAccount(@PathParam("id") Long id) {
        AcmeBank acmeBank = acmeBankRepo.findById(id);
        return Response
                .status(Response.Status.OK)
                .entity(acmeBank)
                .build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public String delete(@PathParam("id") Long id) {
        acmeBankRepo.deleteById(id);
        return "Account Deleted successfully";
    }
}
