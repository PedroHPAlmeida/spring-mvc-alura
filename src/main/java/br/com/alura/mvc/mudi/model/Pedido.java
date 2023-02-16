package br.com.alura.mvc.mudi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProduto;
    private BigDecimal valorNegociado;
    private LocalDate dataEntrega;
    private String urlProduto;
    private String urlImagem;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.AGUARDANDO;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
