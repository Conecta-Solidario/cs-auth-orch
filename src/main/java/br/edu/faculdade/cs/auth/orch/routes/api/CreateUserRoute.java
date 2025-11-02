package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.JwtValidationProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserRoute extends RouteBuilder {

    @Autowired
    private JwtValidationProcessor jwtValidationProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:createUser")
            .routeId("apiCreateUserRoute")
            .log("API: CREATE USER (público)")
            .to("direct:call-cs-auth-create-user");
    }
}
