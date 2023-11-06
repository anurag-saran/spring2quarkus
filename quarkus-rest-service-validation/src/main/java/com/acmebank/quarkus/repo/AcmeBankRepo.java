package com.acmebank.quarkus.repo;

import com.acmebank.quarkus.model.AcmeBank;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AcmeBankRepo implements PanacheRepository<AcmeBank> {
}
