package br.com.nazareth.Catalogo.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProductDataFood(
        @NotBlank
        String productName,
        @NotBlank
        String description,
        @NotBlank
        Double precoParaVenda,
        @NotBlank
        Double precoCompra,
        @NotNull
        LocalDate dataValidade,
        @NotNull
        TipoAlimento tipoAlimento,
        @NotBlank
        int quant
){
}