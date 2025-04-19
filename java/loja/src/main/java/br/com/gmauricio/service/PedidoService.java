package br.com.gmauricio.service;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;

import java.util.List;

public interface PedidoService extends PersistenceService {

	public void salvar(Pedido pedido) throws Exception;
	
	public List<Pedido> lista(StatusPedido statusPedido) throws Exception;
	
}
