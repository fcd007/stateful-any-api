package br.com.microservice.stateful_any_api.core.controller;

import br.com.microservice.stateful_any_api.core.service.AnyService;
import br.com.microservice.stateful_any_api.domain.dto.AnyResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("api/v1/any")
public class AnyController {

  private final AnyService anyService;

  @GetMapping("/resource")
  public ResponseEntity<AnyResponse> getResource(@RequestHeader String accessToken) {
    log.info("Request received to get data");

    var response = anyService.getData(accessToken);

    log.info("Data retrieved successfully");
    return ResponseEntity.ok(response);
  }
}
