package nelsonssoares.ecommercegateway.usecases;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.dtos.LoginDto;
import nelsonssoares.ecommercegateway.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateUser {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    public String authenticate(LoginDto loginDto) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.senha()));
        return authenticationService.getToken(loginDto);
    }
}
