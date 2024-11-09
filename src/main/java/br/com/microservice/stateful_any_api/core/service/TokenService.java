package br.com.microservice.stateful_any_api.core.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import br.com.microservice.stateful_any_api.core.client.TokenClient;
import br.com.microservice.stateful_any_api.domain.dto.AuthUserResponse;
import br.com.microservice.stateful_any_api.infra.exception.AuthenticationException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class TokenService {

  private final TokenClient tokenClient;

  public void validateToken(final String token) {
    try {
      log.info("Sending request for validate token {}", token);

      var response = tokenClient.validateToken(token);

      log.info("Received response for validate token {} ", response.toString());
    } catch (Exception exception) {
      throw new AuthenticationException("Auth error: " + exception.getMessage());
    }
  }

  public AuthUserResponse getAuthenticatedUser(String token) {
    try {
      log.info("Sending request for authenticated user {} ", token);

      var response = tokenClient.getAuthenticatedUser(token);

      log.info("Received response for authenticated user {}", response.toString());

      return response;
    } catch (Exception exception) {
      throw new AuthenticationException(
          "Error to get authenticated user: " + exception.getMessage());
    }
  }
}
