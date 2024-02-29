package nelsonssoares.ecommercegateway.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.commons.constants.SecurityConstants;
import nelsonssoares.ecommercegateway.domain.dtos.LoginDto;
import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import nelsonssoares.ecommercegateway.service.AuthenticationService;
import nelsonssoares.ecommercegateway.usecases.GetUserByEmail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final GetUserByEmail getUserByEmail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = getUserByEmail.getUserByEmail(username);
        return userDetails;
    }

    @Override
    public String getToken(LoginDto loginDto) {
        UsuarioAuth usuarioAuth = getUserByEmail.getUserByEmail(loginDto.email());
        return generateToken(usuarioAuth);
    }

    public String generateToken(UsuarioAuth usuarioAuth){
        try {

            Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.SECRET);
            return JWT.create()
                    .withSubject(usuarioAuth.getEmail())
                    .withIssuer("EcommerceGateway")
                    .withExpiresAt(gerateExpiryDate())
                    .sign(algorithm);

        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao criar token"+e.getMessage());
        }

    }

    public String validateToken(String token){
        System.out.println("validateToken "+token);
        try {
            Algorithm algorithm = Algorithm.HMAC256(SecurityConstants.SECRET);
            return
                    JWT.require(algorithm)
                            .withIssuer("EcommerceGateway")
                            .build()
                            .verify(token)
                            .getSubject();
        }catch (JWTVerificationException e){
            return e.getMessage();
        }

    }

    private Instant gerateExpiryDate() {
        return LocalDateTime.now().plusHours(8).toInstant(ZoneOffset.of("-03:00"));
    }
}
