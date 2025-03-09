package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {

    List<Pedido> findByClienteId(@Param("clienteId")Long clienteId);
}