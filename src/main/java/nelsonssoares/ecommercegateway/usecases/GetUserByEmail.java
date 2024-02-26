package nelsonssoares.ecommercegateway.usecases;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import nelsonssoares.ecommercegateway.domain.repository.UsuarioAuthRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByEmail {

    private final UsuarioAuthRepository usuarioAuthRepository;

    public UsuarioAuth getUserByEmail(String email) {
        Optional<UsuarioAuth> usuarioAuth = Optional.ofNullable(usuarioAuthRepository.findByEmail(email));
        if(usuarioAuth.isPresent()){
            return usuarioAuth.get();
        }
        return null;
    }

}
