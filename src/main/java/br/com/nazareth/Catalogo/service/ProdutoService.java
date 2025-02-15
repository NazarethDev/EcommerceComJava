package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.model.product.ProductData;
import br.com.nazareth.Catalogo.model.product.ProductDataFood;
import br.com.nazareth.Catalogo.model.product.showProductDetails;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;

    public Produto newProduct(ProductData dadosNovoProduto){
        Produto produto = new Produto(dadosNovoProduto);
        return productRepository.save(produto);
    }

    public Produto newFood(ProductDataFood dadosNovoProduto){
        Produto food = new Produto(dadosNovoProduto);
        return productRepository.save(food);
    }

    public ResponseEntity showProduct(@PathVariable Long id){
        var product = productRepository.findById(id);
        if (product.isPresent()){
            return ResponseEntity.ok(new showProductDetails(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

}