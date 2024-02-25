package nelsonssoares.ecommercegateway.domain.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static nelsonssoares.ecommercegateway.commons.constants.JpaConstants.TABLE_NAME;

@Entity
@Table(name = TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioAuth {
    @Id
    @GeneratedValue
    private Integer id;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

}
