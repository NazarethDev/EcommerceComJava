package br.com.nazareth.Catalogo.model.product;

import java.time.LocalDate;

public record UpdateProduct (
        Long id,
        String productName,
        String description,
        Double precoParaVenda,
        Double precoCompra,
        LocalDate dataValidade,
        TipoAlimento tipoAlimento,
        Integer quantEst,
        CategoriaProduto categoriaProduto,
        Boolean alimento
){
}
