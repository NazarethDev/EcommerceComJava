package br.com.nazareth.Catalogo.service;

import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.entity.Usuario;
import br.com.nazareth.Catalogo.model.product.*;
import br.com.nazareth.Catalogo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;


    //mostra produtos com base no id
    public ResponseEntity showProductDetails(Long id) {
        var produtoOptional = productRepository.findById(id);
        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ShowProductDetails(produtoOptional.get()));
    }

    //cria um novo produto
    public ResponseEntity newProduct(ProductData dadosNovoProduto){
        Produto produto = new Produto(dadosNovoProduto);
        productRepository.save(produto);
        return ResponseEntity.ok(new ProductData(produto));
    }

    //cria um novo produto do tipo alimento
    public ResponseEntity newFood(ProductDataFood dadosNovoProduto){
        Produto food = new Produto(dadosNovoProduto);
        productRepository.save(food);
        return ResponseEntity.ok(new ProductDataFood(food));
    }

    //apresenta os produtos de acordo com a categoria indicada
    public ResponseEntity searchByCategory(String categoria){
        String string = categoria.toUpperCase().replace(" ", "_");
        CategoriaProduto categoriaEnum = CategoriaProduto.valueOf(string);
        var categSelecionada = productRepository.findByCategoriaProduto(categoriaEnum);
        if (categSelecionada.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categSelecionada);
    }

    //encontra produtos através do nome
    public ResponseEntity searchByNome(String nomeProduto){
        var buscaNome = productRepository.findByNomeContaining(nomeProduto);
        if (buscaNome.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscaNome);
    }

    //configura um produto como 'deletado' no banco de dados
    public ResponseEntity deleteProduct(Long id){
        var produto = productRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        produto.get().setDeleted(true);
        productRepository.save(produto.get());
        return ResponseEntity.noContent().build();
    }

    //atualiza um produto
    public ResponseEntity updateProduct(Long id, UpdateProduct dadosAtualizados) {
        var produto = productRepository.findById(id);
        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        produto.get().update(dadosAtualizados);
        if (Boolean.TRUE.equals(produto.get().getAlimento())){
            return ResponseEntity.ok(new ProdutoAlimentoAtualizado(produto.get()));
        } else{
            return ResponseEntity.ok(new ProdutoAtualizado(produto.get()));
        }
    }
}