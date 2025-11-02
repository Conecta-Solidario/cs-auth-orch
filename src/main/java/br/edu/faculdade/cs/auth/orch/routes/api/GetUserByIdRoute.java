package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.JwtValidationProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserByIdRoute extends RouteBuilder {

    @Autowired
    private JwtValidationProcessor jwtValidationProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:getUserById")
            .routeId("apiGetUserByIdRoute")
            .log("API: GET USER BY ID (protegido) por ${header.userEmail}")
            .process(jwtValidationProcessor)
            .to("direct:call-cs-auth-get-user");
    }
}
