package nelsonssoares.ecommercegateway.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.dtos.LoginDto;
import nelsonssoares.ecommercegateway.domain.dtos.UsuarioRegistrer;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import nelsonssoares.ecommercegateway.service.UsuarioService;

import nelsonssoares.ecommercegateway.usecases.AuthenticateUser;
import nelsonssoares.ecommercegateway.usecases.RegisterUser;
import nelsonssoares.ecommercegateway.usecases.VerifyExistsEmail;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final ObjectMapper objectMapper;
    private final RegisterUser registerUser;
    private final VerifyExistsEmail verifyExistsEmail;
    private final AuthenticateUser authenticateUser;

    @Override
    public UsuarioDTO registerUser(UsuarioRegistrer usuarioRegistrer) {

        boolean exists = verifyExistsEmail.verify(usuarioRegistrer.email());
        if(exists){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email já cadastrado");
        }
        UsuarioRegistrer usersaved = registerUser.register(usuarioRegistrer);

        if(usersaved == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao salvar usuario, verifique as informações");
        }

        UsuarioDTO usuarioDTO = objectMapper.convertValue(usersaved, UsuarioDTO.class);
        return usuarioDTO;
    }

    @Override
    public String authenticateUser(LoginDto loginDto) {
        return authenticateUser.authenticate(loginDto);
    }


}
