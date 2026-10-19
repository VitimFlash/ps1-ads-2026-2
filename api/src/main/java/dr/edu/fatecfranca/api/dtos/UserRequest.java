package dr.edu.fatecfranca.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest (

    @NotBlank(message = "O nome completo é obrigatório.")
    private String fullname;

    @NotBlank(message = "O nome de usuário é obrigatório.")
    @Pattern(
        regexp = "^[a-zA-Z0-9._-]+$",
        message = "O nome de usuário pode conter apenas letras sem acentos, números, ponto, hífen e sublinhado."
    )
    private String username;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Informe um e-mail válido.")
    private String email;

    @NotBlank(message = "A senha é obrigatória.")
    @Size(min = 8, message = "A senha deve ter pelo menos 8 caracteres.")
    private String password;

    @NotNull(message = "É obrigatório informar se o usuário é administrador.")
    private Boolean isAdmin;
) {}