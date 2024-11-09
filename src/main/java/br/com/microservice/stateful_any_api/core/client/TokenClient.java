package br.com.microservice.stateful_any_api.core.client;

import br.com.microservice.stateful_any_api.domain.dto.AuthUserResponse;
import br.com.microservice.stateful_any_api.domain.dto.TokenDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange("/api/v1/auth/")
public interface TokenClient {

  @PostExchange("/token/validate")
  ResponseEntity<TokenDTO> validateToken(@RequestHeader String accessToken);

  @GetExchange("/user")
  AuthUserResponse getAuthenticatedUser(@RequestHeader String accessToken);
}
