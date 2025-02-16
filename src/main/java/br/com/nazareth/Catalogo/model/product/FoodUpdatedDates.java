package br.com.nazareth.Catalogo.model.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record FoodUpdatedDates (
        Long id,
        String productName,
        String description,
        Double precoParaVenda,
        Double precoCompra,
        LocalDate dataValidade,
        TipoAlimento tipoAlimento,
        int quant
){
}
