package com.acmebank.quarkus.swagger;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        tags = {
                @Tag(name = "AcmeBank",description = "This api contains related to Acembank")
        },
        info = @Info(
                title = "",
                version = "",
                contact = @Contact(
                        name = "",
                        url = "",
                        email = ""
                ),
                license = @License(
                        name = "",
                        url = ""
                )
        )
)
public class CustomApi extends Application {
}
