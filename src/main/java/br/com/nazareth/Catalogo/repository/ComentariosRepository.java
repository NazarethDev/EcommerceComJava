package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentariosRepository extends JpaRepository <Comentarios, Long> {
}