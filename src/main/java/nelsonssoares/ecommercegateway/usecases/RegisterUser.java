package nelsonssoares.ecommercegateway.usecases;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import nelsonssoares.ecommercegateway.outlayers.gateways.UsuarioGateway;
import nelsonssoares.ecommercegateway.outlayers.gateways.clients.UsuarioClient;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import nelsonssoares.ecommercegateway.domain.dtos.UsuarioRegistrer;
import nelsonssoares.ecommercegateway.domain.repository.UsuarioAuthRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterUser {

    private final UsuarioAuthRepository usuarioAuthRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioGateway usuarioGateway;

    @Transactional
    public UsuarioRegistrer register(UsuarioRegistrer usuarioRegistrer) {

        UsuarioAuth usuarioAuth = objectMapper.convertValue(usuarioRegistrer, UsuarioAuth.class);
        var password = passwordEncoder.encode(usuarioRegistrer.senha());
        usuarioAuth.setSenha(password);

//        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuarioRegistrer, UsuarioDTO.class);
//
//        UsuarioDTO usuarioRequest = usuarioGateway.usuarioPost(usuarioDTO);
//        System.out.println(usuarioRequest);
//        if (usuarioRequest == null) {
//            return null;
//        }

        usuarioAuthRepository.save(usuarioAuth);

        return usuarioRegistrer;
    }
}
