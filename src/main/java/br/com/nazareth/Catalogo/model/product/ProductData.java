package br.com.nazareth.Catalogo.model.product;

import br.com.nazareth.Catalogo.entity.Produto;
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
        Integer quant,
        @NotNull
        CategoriaProduto categoriaProduto
) {
        public ProductData(Produto produto){
                this(produto.getNome(), produto.getDescricao(),
                        produto.getPrecoParaVenda(), produto.getPrecoCompra(),
                        produto.getQuant(), produto.getCategoriaProduto());
        }
}