package br.com.nazareth.Catalogo.model.product;

import br.com.nazareth.Catalogo.entity.Produto;
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
        Integer quantEst
){
        public ProductDataFood (Produto produto){
                this(produto.getNome(), produto.getDescricao(), produto.getPrecoParaVenda(),
                        produto.getPrecoCompra(), produto.getDataValidade(),
                        produto.getTipoAlimento(), produto.getQuantEst());
        }
}