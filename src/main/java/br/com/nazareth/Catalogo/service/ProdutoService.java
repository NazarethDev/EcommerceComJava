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

//cria um novo produto
    public Produto newProduct(ProductData dadosNovoProduto){
        Produto produto = new Produto(dadosNovoProduto);
        return productRepository.save(produto);
    }

//cria um novo produto do tipo ingerível
    public Produto newFood(ProductDataFood dadosNovoProduto){
        Produto food = new Produto(dadosNovoProduto);
        return productRepository.save(food);
    }

//mostra um produto com base no Id
    public ResponseEntity showProduct(@PathVariable Long id){
        var product = productRepository.findById(id);
        if (product.isPresent()){
            return ResponseEntity.ok(new ShowProductDetails(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

//mostra os detalhes sobre um produto do tipo alimento
    public ResponseEntity showFoodDetails(@PathVariable Long id){
        var food = productRepository.findById(id);
        if (food.isPresent()){
            return ResponseEntity.ok(new ShowFoodDetails(food.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //apresenta os produtos de acordo com a categoria indicada
    public ResponseEntity searchByCategory(@PathVariable CategoriaProduto categoria){
        var categSelecionada = productRepository.findByCategoriaProduto(categoria);
        if (categSelecionada.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categSelecionada);
    }

    //encontra produtos através do nome
    public ResponseEntity searchByNome(@PathVariable String nomeProduto){
        var buscaNome = productRepository.findByNomeContaining(nomeProduto);
        if (buscaNome.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscaNome);
    }

    //configura um produto como 'deletado' no banco de dados
    public ResponseEntity deleteProduct(@PathVariable Long id){
        var produto = productRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        produto.get().setDeleted(true);
        productRepository.save(produto.get());
        return ResponseEntity.noContent().build();
    }

    //atualiza um produto
    public ResponseEntity updateProduct(@PathVariable Long id){
        var produto = productRepository.findById(id);
        if (produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        if (produto.get().getAlimento() == true){

        }
    }

}