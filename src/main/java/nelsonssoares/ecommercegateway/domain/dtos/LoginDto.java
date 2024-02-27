package nelsonssoares.ecommercegateway.domain.dtos;

import jakarta.validation.constraints.NotEmpty;

public record LoginDto(
        @NotEmpty
        String email,
        @NotEmpty
        String senha) {
}
