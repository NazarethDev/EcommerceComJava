package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository <Endereco, Long> {
}