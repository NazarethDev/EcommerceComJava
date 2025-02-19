package br.com.nazareth.Catalogo.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastro(
        @NotBlank
        String nome,
        @NotBlank
        String senha,
        @Email
        String email,
        @NotBlank
        int cpf,
        @NotBlank
        int telefone,
        @NotNull
        Role role
) {
}
