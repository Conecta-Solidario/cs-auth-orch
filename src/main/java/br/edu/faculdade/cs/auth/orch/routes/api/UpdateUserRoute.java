package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.JwtValidationProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateUserRoute extends RouteBuilder {

    @Autowired
    private JwtValidationProcessor jwtValidationProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:updateUser")
            .routeId("apiUpdateUserRoute")
            .log("API: UPDATE USER (protegido) por ${header.userEmail}")
            .process(jwtValidationProcessor)
            .to("direct:call-cs-auth-update-user");
    }
}
