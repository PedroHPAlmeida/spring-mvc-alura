package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping(path = "/pedidos")
    public ModelAndView home(Principal principal){
        List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping(path = "/pedidos/{status}")
    public ModelAndView aguardando(@PathVariable("status") String status, Principal principal){
        List<Pedido> pedidos = pedidoRepository.findByStatusAndUserUsername(
                StatusPedido.valueOf(status.toUpperCase()),
                principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        mv.addObject("status", status);
        return mv;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }

}
