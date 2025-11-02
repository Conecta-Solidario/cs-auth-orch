package br.edu.faculdade.cs.auth.orch.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TipoUsuario
 */

@Generated(value = "org.openapitools.codegen.languages.JavaCamelServerCodegen", date = "2025-11-01T21:50:35.622060-03:00[America/Sao_Paulo]")
public enum TipoUsuario {
  
  ADMIN("ADMIN"),
  
  DOADOR("DOADOR"),
  
  BENEFICIARIO("BENEFICIARIO");

  private String value;

  TipoUsuario(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TipoUsuario fromValue(String value) {
    for (TipoUsuario b : TipoUsuario.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

