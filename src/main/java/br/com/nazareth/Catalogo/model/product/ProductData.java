package br.com.nazareth.Catalogo.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductData (
        @NotBlank
        String productName,
        @NotBlank
        String description,
        @NotBlank
        Double precoParaVenda,
        @NotBlank
        Double precoCompra,
        @NotBlank
        int quant,
        @NotNull
        CategoriaProduto categoriaProduto
) {
}