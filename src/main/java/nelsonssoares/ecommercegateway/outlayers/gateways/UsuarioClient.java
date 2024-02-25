package nelsonssoares.ecommercegateway.outlayers.gateways;

import jakarta.validation.Valid;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
//@FeignClient(name = "${feign.user-api.name}", url = "${feign.user-api.url}")
public interface UsuarioClient {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDTO> save(@RequestBody @Valid UsuarioDTO dto);
}
