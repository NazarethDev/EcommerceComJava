package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.model.order.DadosDoPedido;
import br.com.nazareth.Catalogo.repository.PedidoRepository;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository orderRepository;

    @Autowired
    private ProdutoRepository productRepository;

    @Autowired
    private VerificacaoProdutosService verificacaoProdutosService;

    @Autowired


    public ResponseEntity newOrder (@RequestBody DadosDoPedido dados, Long userId){
        var produtos = dados.produtos();
        verificacaoProdutosService.ajustaQuantidades(produtos);
        verificacaoProdutosService.ajustaQuantidades(produtos);
        verificacaoProdutosService.precoTotalProdutos(produtos);
    }

}
