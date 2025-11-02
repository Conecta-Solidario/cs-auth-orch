package br.edu.faculdade.cs.auth.orch.processor;

import br.edu.faculdade.cs.auth.orch.service.JwtService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtValidationProcessor implements Processor {

    @Autowired
    private JwtService jwtService;

    @Override
    public void process(Exchange exchange) throws Exception {
        String authorizationHeader = exchange.getIn().getHeader("Authorization", String.class);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new SecurityException("Token JWT não fornecido ou em formato inválido.");
        }

        String token = authorizationHeader.substring(7);

        if (!jwtService.validateToken(token)) {
            throw new SecurityException("Token JWT inválido ou expirado.");
        }

        String email = jwtService.getEmailFromToken(token);
        exchange.getIn().setHeader("userEmail", email);
    }
}
