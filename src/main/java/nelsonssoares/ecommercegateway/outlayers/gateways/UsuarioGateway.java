package nelsonssoares.ecommercegateway.outlayers.gateways;


import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.outlayers.gateways.clients.UsuarioClient;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsuarioGateway {

    private final UsuarioClient usuarioClient;

    public UsuarioDTO usuarioPost(UsuarioDTO usuarioDTO){

        ResponseEntity<UsuarioDTO> usuarioRequest = usuarioClient.save( usuarioDTO );

        if (usuarioRequest.getBody() == null || usuarioRequest.getStatusCode().is4xxClientError() || !usuarioRequest.hasBody()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi possivel salvar usuario, verifique as informações");
        }

        return usuarioRequest.getBody();
    }
}
