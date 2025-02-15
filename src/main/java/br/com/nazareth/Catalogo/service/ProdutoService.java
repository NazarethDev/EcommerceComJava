package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.model.product.*;
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

    public ResponseEntity showFoodDetails(@PathVariable Long id){
        var food = productRepository.findById(id);
        if (food.isPresent()){
            return ResponseEntity.ok(new showFoodDetails(food.get()));
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity searchByCategory(@PathVariable CategoriaProduto categoria){
        var categSelecionada = productRepository.findByCategoriaProduto(categoria);
        if (categSelecionada.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categSelecionada);
    }

    public ResponseEntity searchByNome(@PathVariable String nomeProduto){
        var buscaNome = productRepository.findByNomeContaining(nomeProduto);
        if (buscaNome.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(buscaNome);
    }

}