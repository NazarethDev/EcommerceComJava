package br.com.nazareth.Catalogo.model.product;

import jakarta.validation.constraints.NotBlank;

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
        int quant
) {
}