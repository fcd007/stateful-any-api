package br.com.microservice.stateful_any_api.infra.exception;

public record ExceptionDetails (int status, String message){
}