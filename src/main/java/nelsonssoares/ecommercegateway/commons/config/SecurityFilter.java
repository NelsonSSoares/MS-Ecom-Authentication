package nelsonssoares.ecommercegateway.commons.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.domain.entities.UsuarioAuth;
import nelsonssoares.ecommercegateway.service.AuthenticationService;
import nelsonssoares.ecommercegateway.usecases.GetUserByEmail;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final AuthenticationService authenticationService;
    private final GetUserByEmail getUserByEmail;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = extractToken(request);
        System.out.println("doFilter Token "+token);
        if(token != null){
           String login =  authenticationService.validateToken(token);
           UsuarioAuth usuarioAuth = getUserByEmail.getUserByEmail(login);
           var authentication = new UsernamePasswordAuthenticationToken(usuarioAuth, null, usuarioAuth.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

    public String extractToken(HttpServletRequest request){

        var token = request.getHeader("Authorization");
        System.out.println("extractToken "+token);
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
            return null;
        }
       if(!token.split(" ")[0].equals("Bearer ")){
            return null;
        }

       String token1 = token.split(" ")[1];
        System.out.println("extractToken1 "+token1);
        return token1;
        //return token.split(" ")[1];
    }

}
