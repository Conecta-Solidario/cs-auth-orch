package br.edu.faculdade.cs.auth.orch.routes.client;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class CsAuthClientRoutes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:call-cs-auth-login")
            .routeId("csAuthLoginClient")
            .log("Chamando cs-auth para login")
            .marshal().json(JsonLibrary.Jackson)
            .toD("{{cs.auth.service.url}}/login?bridgeEndpoint=true")
            .unmarshal().json(JsonLibrary.Jackson, java.util.Map.class);

        from("direct:call-cs-auth-create-user")
            .routeId("csAuthCreateUserClient")
            .log("Chamando cs-auth para criar usuário")
            .marshal().json(JsonLibrary.Jackson)
            .toD("{{cs.auth.service.url}}/usuarios?bridgeEndpoint=true");

        from("direct:call-cs-auth-list-users")
            .routeId("csAuthListUsersClient")
            .log("Chamando cs-auth para listar usuários")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .setBody(constant(null)) // Limpa o corpo para requisições GET
            .toD("{{cs.auth.service.url}}/usuarios?bridgeEndpoint=true");

        from("direct:call-cs-auth-get-user")
            .routeId("csAuthGetUserClient")
            .log("Chamando cs-auth para buscar usuário ${header.id}")
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .setBody(constant(null))
            .toD("{{cs.auth.service.url}}/usuarios/${header.id}?bridgeEndpoint=true");

        from("direct:call-cs-auth-update-user")
            .routeId("csAuthUpdateUserClient")
            .log("Chamando cs-auth para atualizar usuário ${header.id}")
            .setHeader(Exchange.HTTP_METHOD, constant("PUT"))
            .marshal().json(JsonLibrary.Jackson)
            .toD("{{cs.auth.service.url}}/usuarios/${header.id}?bridgeEndpoint=true");

        from("direct:call-cs-auth-delete-user")
            .routeId("csAuthDeleteUserClient")
            .log("Chamando cs-auth para deletar usuário ${header.id}")
            .setHeader(Exchange.HTTP_METHOD, constant("DELETE"))
            .setBody(constant(null))
            .toD("{{cs.auth.service.url}}/usuarios/${header.id}?bridgeEndpoint=true");
    }
}
