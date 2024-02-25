package nelsonssoares.ecommercegateway.domain.dtos;

public record UsuarioAuthentication(
        String nome,
        String email,
        String  password
) {
}
