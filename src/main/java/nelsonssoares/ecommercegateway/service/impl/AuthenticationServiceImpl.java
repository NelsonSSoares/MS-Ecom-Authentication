package nelsonssoares.ecommercegateway.service.impl;

import lombok.RequiredArgsConstructor;
import nelsonssoares.ecommercegateway.usecases.GetUserByEmail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements UserDetailsService {

    private final GetUserByEmail getUserByEmail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = getUserByEmail.getUserByEmail(username);
        return userDetails;
    }
}
