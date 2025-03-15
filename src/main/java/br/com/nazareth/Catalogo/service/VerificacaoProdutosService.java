package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class VerificacaoProdutosService {
    @Autowired
    ProdutoRepository productRepository;

    //remove produtos inexistentes da lista de produtos caso algum seja adicionado
    public void removeProdutosInexistentes(List<Produto> produtos){
        List<Long> idExistentes = productRepository.findAllById(
                produtos.stream().map(Produto::getId).toList()
        ).stream().map(Produto::getId).toList();

        produtos.removeIf(produto -> !idExistentes.contains(produto.getId()));
    }

    //ajusta a quantidade de produtos no pedido para a quantidade de produtos caso necessário
    public void ajustaQuantidades(List<Produto> produtosPedidos){
        Map<Long, Integer> qntPedidaMap = produtosPedidos.stream()
                .collect(Collectors.toMap(
                        Produto::getId,
                        Produto::getQuantPed,
                        Integer::sum
                ));
        List<Produto> produtosDB = productRepository.findAllById(qntPedidaMap.keySet());

        Map<Long, Integer> estoqueDisponivelMap = produtosDB.stream()
                .collect(Collectors.toMap(Produto::getId, Produto::getQuantEst));

        for (Produto produto : produtosPedidos){
            Long id = produto.getId();
            Integer quantidadePedida = qntPedidaMap.getOrDefault(id,0);
            Integer quantidadeEstoque = estoqueDisponivelMap.getOrDefault(id,0);

            produto.setQuantPed(Math.min(quantidadePedida, quantidadeEstoque));
        }
    }

    public void precoTotalProdutos(List<Produto> produtosPedidos){
        Map<Long, Double> precoMap = produtosPedidos.stream()
                .collect(Collectors.toMap(
                        Produto::getId,
                        Produto::getPrecoParaVenda));

        double precoTotal = 0;
        for (Produto produto : produtosPedidos){
            Long id = produto.getId();
            Integer quantPedida = produto.getQuantPed();
            double preco = precoMap.getOrDefault(id,0.0);

            precoTotal += quantPedida * preco;
        }

    }
}

