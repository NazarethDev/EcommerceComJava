package br.com.nazareth.Catalogo.model.product;

import br.com.nazareth.Catalogo.entity.Produto;

import java.time.LocalDate;

public record ProdutoAlimentoAtualizado(
        Long id,
        String productName,
        String description,
        Double precoParaVenda,
        Double precoCompra,
        LocalDate dataValidade,
        TipoAlimento tipoAlimento,
        Integer quant,
        CategoriaProduto categoriaProduto,
        Boolean alimento,
        LocalDate updatedAt,
        LocalDate createdAt
) {
    public ProdutoAlimentoAtualizado(Produto produto){
        this(   produto.getId(), produto.getNome(), produto.getDescricao(),
                produto.getPrecoParaVenda(), produto.getPrecoCompra(),
                produto.getDataValidade(), produto.getTipoAlimento(),
                produto.getQuant(), produto.getCategoriaProduto(),
                produto.getAlimento(), produto.getUpdatedAt(), produto.getCreatedAt()
        );
    }
}
