package br.com.gmauricio.service.impl;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.repository.PedidoRepository;
import br.com.gmauricio.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class PedidoServiceImpl extends PersistenceServiceImpl implements PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void salvar(Pedido pedido) throws Exception {
		try {
			this.getEm().persist(pedido);
			this.getEm().flush();
		} catch (Exception e) {
			throw new Exception("Erro ao salvar pedido: " + e);
		}
	}
	
	@Override
	public List<Pedido> lista(StatusPedido statusPedido) throws Exception {
		try {
			if(statusPedido == null) {
				return pedidoRepository.findAll();
			} else {
				return pedidoRepository.findByStatusPedido(statusPedido);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception("Erro ao lista pedido: " + e);
		}
	}

}
