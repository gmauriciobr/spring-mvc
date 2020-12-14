package br.com.gmauricio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.service.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping()
	public String home(Model model) {
		try {
			List<Pedido> pedidos = pedidoService.lista(null);
			model.addAttribute("pedidos", pedidos);
			return "home";
		} catch (Exception e) {
			return "redirect:/home";
		}
	}
	
	@GetMapping("/{statusPedido}")
	public String statusPedido(@PathVariable("statusPedido") String statusPedido, Model model) {
		try {
			model.addAttribute("pedidos", pedidoService.lista(StatusPedido.valueOf(statusPedido)));
			return "home";
		} catch (Exception e) {
			return "redirect:/home";
		}
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErro() {
		return "redirect:/home";
	}

}
