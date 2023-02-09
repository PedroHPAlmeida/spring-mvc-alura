package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path = "/formulario")
    public ModelAndView formulario() {
        return new ModelAndView("pedido/formulario");
    }

    @PostMapping(path = "/novo")
    public ModelAndView novo(RequisicaoNovoPedido requisicao) {
        pedidoRepository.save(requisicao.toPedido());
        return new ModelAndView("pedido/formulario");
    }

}
