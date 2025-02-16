package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Produto;
import br.com.nazareth.Catalogo.model.product.CategoriaProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {

    List<Produto> findByCategoriaProduto(CategoriaProduto categoriaProduto);

    List<Produto> findByNomeContaining(String nomeProduto);
}