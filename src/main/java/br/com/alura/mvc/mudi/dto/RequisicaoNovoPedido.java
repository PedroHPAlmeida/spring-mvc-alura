package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;
    @NotBlank
    private String urlProduto;
    @NotBlank
    private String urlImagem;
    @NotBlank
    private String descricao;

    public Pedido toPedido(User user) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(this.nomeProduto);
        pedido.setUrlProduto(this.urlProduto);
        pedido.setUrlImagem(this.urlImagem);
        pedido.setDescricao(this.descricao);
        pedido.setUser(user);
        return pedido;
    }

}
