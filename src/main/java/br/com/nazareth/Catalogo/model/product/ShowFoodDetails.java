package br.com.nazareth.Catalogo.model.product;

import br.com.nazareth.Catalogo.entity.Comentarios;
import br.com.nazareth.Catalogo.entity.Produto;

import java.time.LocalDate;
import java.util.List;

public record ShowFoodDetails(

        Long id,
        String nome,
        String descricao,
        double precoVenda,
        List<Comentarios> comentarios,
        double avaliacao,
        CategoriaProduto categoria,
        LocalDate dataValidade,
        TipoAlimento tipoAlimento
) {
    public ShowFoodDetails(Produto produto){
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPrecoParaVenda(),
                produto.getComentarios(),
                produto.getAvaliacao(),
                produto.getCategoriaProduto(),
                produto.getDataValidade(),
                produto.getTipoAlimento()
        );
    }
}
