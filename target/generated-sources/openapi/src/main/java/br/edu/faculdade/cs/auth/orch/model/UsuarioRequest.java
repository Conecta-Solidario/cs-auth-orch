package br.edu.faculdade.cs.auth.orch.model;

import java.net.URI;
import java.util.Objects;
import br.edu.faculdade.cs.auth.orch.model.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UsuarioRequest
 */

@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", date = "2025-11-01T21:50:35.622060-03:00[America/Sao_Paulo]")
public class UsuarioRequest {

  private String nome;

  private String email;

  private String senha;

  private TipoUsuario tipoUsuario;

  public UsuarioRequest nome(String nome) {
    this.nome = nome;
    return this;
  }

  /**
   * Get nome
   * @return nome
  */
  
  @Schema(name = "nome", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("nome")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public UsuarioRequest email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @jakarta.validation.constraints.Email 
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UsuarioRequest senha(String senha) {
    this.senha = senha;
    return this;
  }

  /**
   * Get senha
   * @return senha
  */
  
  @Schema(name = "senha", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("senha")
  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public UsuarioRequest tipoUsuario(TipoUsuario tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
    return this;
  }

  /**
   * Get tipoUsuario
   * @return tipoUsuario
  */
  @Valid 
  @Schema(name = "tipoUsuario", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tipoUsuario")
  public TipoUsuario getTipoUsuario() {
    return tipoUsuario;
  }

  public void setTipoUsuario(TipoUsuario tipoUsuario) {
    this.tipoUsuario = tipoUsuario;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsuarioRequest usuarioRequest = (UsuarioRequest) o;
    return Objects.equals(this.nome, usuarioRequest.nome) &&
        Objects.equals(this.email, usuarioRequest.email) &&
        Objects.equals(this.senha, usuarioRequest.senha) &&
        Objects.equals(this.tipoUsuario, usuarioRequest.tipoUsuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, email, senha, tipoUsuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioRequest {\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    senha: ").append(toIndentedString(senha)).append("\n");
    sb.append("    tipoUsuario: ").append(toIndentedString(tipoUsuario)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

