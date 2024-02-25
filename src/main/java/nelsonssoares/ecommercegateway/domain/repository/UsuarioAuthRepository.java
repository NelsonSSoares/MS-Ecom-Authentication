package nelsonssoares.ecommercegateway.domain.repository;

import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioAuthRepository extends JpaRepository<UsuarioAuth, Integer> {

    UsuarioAuth findByEmail(String email);
}
