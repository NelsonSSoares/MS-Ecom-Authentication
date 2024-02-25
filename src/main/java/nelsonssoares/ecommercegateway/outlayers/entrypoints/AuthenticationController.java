package nelsonssoares.ecommercegateway.outlayers.entrypoints;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import nelsonssoares.ecommercegateway.domain.dtos.UsuarioRegistrer;
import nelsonssoares.ecommercegateway.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static nelsonssoares.ecommercegateway.commons.constants.ControllerConstants.API_BASE_URL;
import static nelsonssoares.ecommercegateway.commons.constants.ControllerConstants.API_PRODUCES;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = API_BASE_URL, produces = API_PRODUCES)
public class AuthenticationController {

    private final ObjectMapper objectMapper;
    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO save(@RequestBody @Valid UsuarioRegistrer usuarioRegistrer) {

        return usuarioService.registerUser(usuarioRegistrer);
    }

}
