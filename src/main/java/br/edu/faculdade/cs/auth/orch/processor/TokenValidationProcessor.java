package br.edu.faculdade.cs.auth.orch.processor;

import br.edu.faculdade.cs.auth.orch.service.JwtService;
import io.jsonwebtoken.Claims;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TokenValidationProcessor implements Processor {

    @Autowired
    private JwtService jwtService;

    @Override
    public void process(Exchange exchange) throws Exception {
        Map<String, String> requestBody = exchange.getIn().getBody(Map.class);
        String token = requestBody.get("token");

        if (token == null || !jwtService.validateToken(token)) {
            throw new SecurityException("Token inválido ou expirado.");
        }

        // Se o token for válido, extrai as informações para a resposta
        Claims claims = jwtService.getClaimsFromToken(token);
        String email = claims.getSubject();
        String userType = claims.get("type", String.class);

        Map<String, Object> response = Map.of(
            "isValid", true,
            "email", email,
            "userType", userType
        );

        exchange.getMessage().setBody(response);
    }
}
