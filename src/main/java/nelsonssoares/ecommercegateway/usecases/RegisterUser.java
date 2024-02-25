package nelsonssoares.ecommercegateway.usecases;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import nelsonssoares.ecommercegateway.domain.dtos.UsuarioRegistrer;
import nelsonssoares.ecommercegateway.domain.repository.UsuarioAuthRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUser {

    private final UsuarioAuthRepository usuarioAuthRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    public UsuarioRegistrer register(UsuarioRegistrer usuarioRegistrer) {

        UsuarioAuth usuarioAuth = objectMapper.convertValue(usuarioRegistrer, UsuarioAuth.class);
        usuarioAuthRepository.save(usuarioAuth);


        return usuarioRegistrer;
    }
}
