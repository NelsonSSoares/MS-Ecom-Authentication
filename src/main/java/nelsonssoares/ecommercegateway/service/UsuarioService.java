package nelsonssoares.ecommercegateway.service;

import nelsonssoares.ecommercegateway.domain.dtos.LoginDto;
import nelsonssoares.ecommercegateway.outlayers.gateways.entities.UsuarioDTO;
import nelsonssoares.ecommercegateway.domain.dtos.UsuarioRegistrer;

public interface UsuarioService {

    public UsuarioDTO registerUser(UsuarioRegistrer usuarioRegistrer);
    public String authenticateUser(LoginDto loginDto);
}
