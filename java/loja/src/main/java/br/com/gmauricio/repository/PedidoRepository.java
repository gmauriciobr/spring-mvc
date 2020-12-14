package br.com.gmauricio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	public List<Pedido> findByStatusPedido(StatusPedido statusPedido);

}
