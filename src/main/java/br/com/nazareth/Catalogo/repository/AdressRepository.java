package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdressRepository extends JpaRepository <Endereco, Long> {


    @Query("SELECT e FROM Endereco e JOIN e.usuario u " +
            "WHERE u.id = :usuarioId " +
            "AND (e.enderecoEntrega = true OR e.enderecoFaturacao = true)")
    List<Endereco> allAdresses(@Param("usuarioId") Long usuarioId);

    @Query("SELECT e FROM Endereco e JOIN e.usuario u " +
            "WHERE u.id = :userId " +
            "AND (:isEntrega = true AND e.enderecoEntrega = true OR " +
            ":isEntrega = false AND e.enderecoFaturacao = true)")
    List<Endereco> searchAdress(@Param("userId") Long userId, @Param("isEntrega") boolean isEntrega);

}