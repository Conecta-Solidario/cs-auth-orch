# CS Auth Orch - Orquestrador de Autenticação e Usuários

Serviço orquestrador responsável pela lógica de autenticação, geração/validação de tokens JWT e por ser o ponto de entrada para o gerenciamento de usuários, orquestrando as chamadas para o microserviço `cs-auth`.

## Tecnologias

- Java 17
- Spring Boot 3.2.0
- Apache Camel 4.0.0
- OpenAPI Generator 7.2.0
- JJWT (JSON Web Token)
- SpringDoc (Swagger UI)

## Estrutura do Projeto

O projeto utiliza uma arquitetura baseada em rotas e processadores do Apache Camel para desacoplar a lógica de negócio, a exposição da API e a comunicação com outros serviços.

```
cs-auth-orch/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/edu/faculdade/cs/auth/orch/
│   │   │       ├── routes/
│   │   │       │   ├── api/          # Rotas que expõem a API (uma por endpoint)
│   │   │       │   └── client/       # Rotas para comunicação com o cs-auth
│   │   │       ├── processor/      # Lógica de negócio e manipulação de dados
│   │   │       └── service/        # Serviços (ex: JwtService)
│   │   └── resources/
│   │       ├── static/openapi/
│   │       │   └── api.yml         # Especificação OpenAPI
│   │       └── application.properties
└── pom.xml
```

## Endpoints Principais

A base da API é `/api/v1`.

- `POST /login` - Autentica um usuário e retorna um token JWT.
- `POST /token/validate` - Valida um token JWT existente.
- `POST /usuarios` - Cria um novo usuário (endpoint público).
- `GET /usuarios` - Lista todos os usuários (protegido por JWT).
- `GET /usuarios/{id}` - Busca usuário por ID (protegido por JWT).
- `PUT /usuarios/{id}` - Atualiza usuário (protegido por JWT).
- `DELETE /usuarios/{id}` - Remove usuário (protegido por JWT).

## Executando

**Importante:** Este projeto requer Java 17 ou superior. O script de execução está configurado para usar Java 21.

### Usando o script helper (recomendado)

```bash
# Limpa e compila o projeto (gera as classes da API)
./mvnw.sh clean install

# Executa a aplicação
./mvnw.sh spring-boot:run
```

A aplicação estará disponível em `http://localhost:8082`.

### Swagger UI

Para visualizar e interagir com a API, acesse:
[http://localhost:8082/swagger-ui.html](http://localhost:8082/swagger-ui.html)
