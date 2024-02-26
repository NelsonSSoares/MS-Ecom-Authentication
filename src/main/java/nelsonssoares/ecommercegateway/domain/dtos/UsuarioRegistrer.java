package nelsonssoares.ecommercegateway.domain.dtos;

import jakarta.validation.constraints.NotEmpty;

public record UsuarioRegistrer(
        @NotEmpty
        String nome,
        @NotEmpty
        String sobrenome,
        @NotEmpty
        String cpf,
        @NotEmpty
        String telefone,
        @NotEmpty
        String email,
        @NotEmpty
        String senha,
        @NotEmpty
        String role
) {
}
