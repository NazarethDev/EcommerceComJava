package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ComentariosRepository extends JpaRepository <Comentarios, Long> {

    List<Comentarios> findByProdutoId(Long productId);
}