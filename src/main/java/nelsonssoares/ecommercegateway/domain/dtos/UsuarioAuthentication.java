package nelsonssoares.ecommercegateway.domain.dtos;

import jakarta.validation.constraints.NotEmpty;

public record UsuarioAuthentication(

        @NotEmpty
        String nome,
        @NotEmpty
        String email,
        @NotEmpty
        String senha,
        @NotEmpty
        String role
) {
}
