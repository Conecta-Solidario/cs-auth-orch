package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.TokenValidationProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateTokenRoute extends RouteBuilder {

    @Autowired
    private TokenValidationProcessor tokenValidationProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:validateToken")
            .routeId("apiValidateTokenRoute")
            .log("API: Validando token")
            .doTry()
                .process(tokenValidationProcessor)
            .doCatch(SecurityException.class)
                .log("Falha na validação do token: ${exception.message}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(401))
                .setBody(constant("{\"isValid\": false}"))
            .end()
            .marshal().json(JsonLibrary.Jackson);
    }
}
