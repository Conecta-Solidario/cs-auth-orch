package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.JwtValidationProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListUsersRoute extends RouteBuilder {

    @Autowired
    private JwtValidationProcessor jwtValidationProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:listUsers")
            .routeId("apiListUsersRoute")
            .log("API: LIST USERS (protegido) por ${header.userEmail}")
            .process(jwtValidationProcessor)
            .to("direct:call-cs-auth-list-users");
    }
}
