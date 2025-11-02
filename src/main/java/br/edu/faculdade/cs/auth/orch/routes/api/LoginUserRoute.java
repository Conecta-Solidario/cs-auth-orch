package br.edu.faculdade.cs.auth.orch.routes.api;

import br.edu.faculdade.cs.auth.orch.processor.LoginProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserRoute extends RouteBuilder {

    @Autowired
    private LoginProcessor loginProcessor;

    @Override
    public void configure() throws Exception {
        from("direct:loginUser")
            .routeId("apiLoginUserRoute")
            .log("API: Recebida requisição de login para o usuário: ${body[email]}")
            .doTry()
                .to("direct:call-cs-auth-login")
                .process(loginProcessor)
            .doCatch(Exception.class)
                .log("Falha no processo de login: ${exception.message}")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(401))
                .setBody(constant("{\"message\": \"Credenciais inválidas ou falha no sistema de autenticação.\"}"))
                .stop()
            .end()
            .marshal().json(JsonLibrary.Jackson);
    }
}

