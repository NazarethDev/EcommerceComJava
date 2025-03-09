package br.com.nazareth.Catalogo.model.order;

import br.com.nazareth.Catalogo.entity.Endereco;
import br.com.nazareth.Catalogo.entity.Pedido;
import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.entity.Usuario;

import java.util.List;

public record DadosDoPedido(
        Long id,
        Usuario cliente,
        Endereco enderecoEntrega,
        Endereco enderecoFaturacao,
        double valorTotal,
        double valorProdutos,
        double valorEntrega,
        List<Produto> produtos
) {
    public DadosDoPedido (Pedido pedido){
        this(pedido.getId(), pedido.getCliente(),
                pedido.getEnderecoEntrega(),pedido.getEnderecoFaturacao(),
                pedido.getValorTotal(), pedido.getValorProdutos(), pedido.getValorEntrega(),pedido.getProdutos());
    }
}