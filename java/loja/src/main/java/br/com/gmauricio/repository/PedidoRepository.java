package br.com.gmauricio.repository;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	public List<Pedido> findByStatusPedido(StatusPedido statusPedido);

}
