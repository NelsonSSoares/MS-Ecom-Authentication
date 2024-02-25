package nelsonssoares.ecommercegateway.usecases;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.repository.UsuarioAuthRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyExistsEmail {
    private final UsuarioAuthRepository usuarioAuthRepository;
    public boolean verify(String email) {
        if(usuarioAuthRepository.findByEmail(email) != null){
            return true;
        }
        return false;
    }
}
