package br.com.nazareth.Catalogo.repository;

import br.com.nazareth.Catalogo.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Long> {
}