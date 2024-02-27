package nelsonssoares.ecommercegateway.service;

import nelsonssoares.ecommercegateway.domain.dtos.LoginDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService{

    public String getToken(LoginDto loginDto);
    public String validateToken(String token);

}
