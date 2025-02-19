package br.com.nazareth.Catalogo.model.user;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}