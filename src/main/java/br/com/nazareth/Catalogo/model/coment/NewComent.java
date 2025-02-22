package br.com.nazareth.Catalogo.model.coment;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NewComent(
        @NotNull
        Long productId,
        @NotBlank
        String mensagem
) {
}
