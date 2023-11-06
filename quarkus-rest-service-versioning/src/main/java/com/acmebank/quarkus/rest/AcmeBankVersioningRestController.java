package com.acmebank.quarkus.rest;

import com.acmebank.quarkus.model.AcmeBankV1;
import com.acmebank.quarkus.model.AcmeBankV2;
import com.acmebank.quarkus.model.Name;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/acmebank")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AcmeBankVersioningRestController {

    @GET
    @Path("v1/greeting")
    public AcmeBankV1 greetingV1() {
        return new AcmeBankV1(1l,"Bob Charlie","ACMR8756");
    }

    @GET
    @Path("v2/greeting")
    public AcmeBankV2 greetingV2() {
        return new AcmeBankV2(1l,new Name("Bob", "Charlie"),"ACMR8756");
    }

    @GET
    @Path(value = "/greeting/param")
    public AcmeBankV1 paramV1(@DefaultValue("1") @QueryParam("version") Integer version) {
        return new AcmeBankV1(1l,"Bob Charlie","ACMR8756");
    }

    @GET
    @Path(value = "/greeting/param")
    public AcmeBankV2 paramV2(@DefaultValue("2") @QueryParam("version") Integer version) {
        return new AcmeBankV2(1l,new Name("Bob", "Charlie"),"ACMR8756");
    }

    @GET
    @Path(value = "/greeting/header")
    @HeaderParam("X-API-VERSION=1")
    public AcmeBankV1 headerV1() {
        return new AcmeBankV1(1l,"Bob Charlie","ACMR8756");
    }

    @GET
    @Path(value = "/greeting/header")
    @HeaderParam("X-API-VERSION=2")
    public AcmeBankV2 headerV2() {
        return new AcmeBankV2(1l,new Name("Bob", "Charlie"),"ACMR8756");
    }

    @GET
    @Path(value = "/greeting/produces")
    @Produces("application/vnd.company.app-v1+json")
    public AcmeBankV1 producesV1() {
        return new AcmeBankV1(1l,"Bob Charlie","ACMR8756");
    }

    @GET
    @Path(value = "/greeting/produces")
    @Produces("application/vnd.company.app-v2+json")
    public AcmeBankV2 producesV2() {
        return new AcmeBankV2(1l,new Name("Bob", "Charlie"),"ACMR8756");
    }
}
