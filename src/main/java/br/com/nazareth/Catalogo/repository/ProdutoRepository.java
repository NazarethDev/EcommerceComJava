package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
}