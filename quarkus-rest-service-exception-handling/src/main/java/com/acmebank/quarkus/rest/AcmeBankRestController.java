package com.acmebank.quarkus.rest;

import com.acmebank.quarkus.exception.BankAccountNotFoundException;
import com.acmebank.quarkus.model.AcmeBank;
import com.acmebank.quarkus.repo.AcmeBankRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

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
        acmeBankRepo.persist(acmeBank);
        return "Account created successfully";
    }

    @PUT
    @Path("update")
    @Transactional
    public String updateAcmeAccount(AcmeBank acmeBank) {
        acmeBankRepo.getEntityManager().merge(acmeBank);
        return "Account Updated successfully";
    }

    @GET
    @Path("get")
    public List<AcmeBank> getAllAccount() {
        return acmeBankRepo.listAll();
    }

    @GET
    @Path("/get/{id}")
    public AcmeBank getParticularAccount(@PathParam("id") Long id) {
        Optional<AcmeBank> acmeBank = acmeBankRepo.findByIdOptional(id);
        if (acmeBank.isEmpty()) {
            throw new BankAccountNotFoundException("id-" + id);
        }
        return acmeBank.get();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public String delete(@PathParam("id") Long id) {
        acmeBankRepo.deleteById(id);
        return "Account Deleted successfully";
    }
}
