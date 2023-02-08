package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping(path = "/home")
    public String home(Model model){
        Pedido pedido = new Pedido(
                "Headphone Philips",
                new BigDecimal("97.91"),
                LocalDate.now(),
                "https://www.amazon.com.br/HEADPHONE-PHILIPS-WIRELESS-TAH1205BK-00/dp/B08XY4KCZ3/ref=zg-bs_electronics_sccl_2/143-4762517-2059366?pd_rd_w=r50oN&content-id=amzn1.sym.b84c4b85-d0b6-44ab-b250-acbd7d0f923e&pf_rd_p=b84c4b85-d0b6-44ab-b250-acbd7d0f923e&pf_rd_r=356DNZPBMD4F4C4DR2WT&pd_rd_wg=7NMan&pd_rd_r=836e400a-56c5-4d29-9a84-35843126ab0a&pd_rd_i=B08XY4KCZ3&psc=1",
                "https://m.media-amazon.com/images/I/41qFwp6esOL._AC_SL1000_.jpg",
                "Headphone Philips Wireless BT Preto TAH1205BK/00"
        );
        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
