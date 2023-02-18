package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;


@Controller
@RequestMapping(path = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/formulario")
    public ModelAndView formulario(RequisicaoNovoPedido requisicao) {
        return new ModelAndView("pedido/formulario");
    }

    @CacheEvict(cacheNames="pedidos", allEntries=true)
    @PostMapping(path = "/novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return "pedido/formulario";
        }

        String loggedUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(loggedUsername);
        pedidoRepository.save(requisicao.toPedido(user));
        return "redirect:/home";
    }

}
