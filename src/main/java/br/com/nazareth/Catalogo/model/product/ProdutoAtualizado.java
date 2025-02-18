package br.com.nazareth.Catalogo.model.product;

import br.com.nazareth.Catalogo.entity.Produto;

import java.time.LocalDate;

public record ProdutoAtualizado(
        Long id,
        String productName,
        String description,
        Double precoParaVenda,
        Double precoCompra,
        Integer quant,
        CategoriaProduto categoriaProduto,
        Boolean alimento,
        LocalDate updatedAt,
        LocalDate createdAt
) {
    public ProdutoAtualizado (Produto produto){
        this(
                produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getPrecoParaVenda(), produto.getPrecoCompra(),
                produto.getQuant(), produto.getCategoriaProduto(),
                produto.getAlimento(), produto.getUpdatedAt(), produto.getCreatedAt()
        );
    }
}
