package br.com.microservice.stateful_any_api.domain.dto;

public record AnyResponse(Integer status, Integer code, AuthUserResponse authUser) {
}
