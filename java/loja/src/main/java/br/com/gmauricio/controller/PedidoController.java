package br.com.gmauricio.controller;


import br.com.gmauricio.dto.PedidoDTO;
import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("formulario")
	public ModelAndView formulario() {
		ModelAndView model = new ModelAndView("pedido/formulario");
		model.addObject("pedidoDTO", new PedidoDTO());
		return model;
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDTO pedidoDTO, BindingResult result) {
		try {
			if(result.hasErrors()) return "pedido/formulario";
			Pedido pedido = PedidoDTO.parseToPedido(pedidoDTO);
			pedidoService.salvar(pedido);
			return "redirect:/home";
		} catch (Exception e) {
			return "pedido/formulario";
		}
	}
}
