package br.edu.faculdade.cs.auth.orch.processor;

import br.edu.faculdade.cs.auth.orch.service.JwtService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginProcessor implements Processor {

    @Autowired
    private JwtService jwtService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, String> authResponse = exchange.getIn().getBody(Map.class);

        String userEmail = authResponse.get("email");
        String userType = authResponse.get("tipoUsuario");

        if (userEmail == null || userType == null) {
            throw new SecurityException("Resposta de autenticação inválida do serviço de usuário.");
        }

        String token = jwtService.generateToken(userEmail, userType);

        exchange.getMessage().setBody(Map.of("token", token));
    }
}
