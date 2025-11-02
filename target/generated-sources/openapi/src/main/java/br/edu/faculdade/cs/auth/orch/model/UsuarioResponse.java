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
 * UsuarioResponse
 */

@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", date = "2025-11-01T21:50:35.622060-03:00[America/Sao_Paulo]")
public class UsuarioResponse {

  private String id;

  private String nome;

  private String email;

  private TipoUsuario tipoUsuario;

  public UsuarioResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UsuarioResponse nome(String nome) {
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

  public UsuarioResponse email(String email) {
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

  public UsuarioResponse tipoUsuario(TipoUsuario tipoUsuario) {
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
    UsuarioResponse usuarioResponse = (UsuarioResponse) o;
    return Objects.equals(this.id, usuarioResponse.id) &&
        Objects.equals(this.nome, usuarioResponse.nome) &&
        Objects.equals(this.email, usuarioResponse.email) &&
        Objects.equals(this.tipoUsuario, usuarioResponse.tipoUsuario);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, email, tipoUsuario);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsuarioResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

