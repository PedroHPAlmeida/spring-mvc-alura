package br.com.alura.mvc.mudi.dto;

import br.com.alura.mvc.mudi.model.Pedido;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RequisicaoNovoPedido {

    private String nomeProduto;
    private String urlProduto;
    private String urlImagem;
    private String descricao;

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(this.nomeProduto);
        pedido.setUrlProduto(this.urlProduto);
        pedido.setUrlImagem(this.urlImagem);
        pedido.setDescricao(this.descricao);
        return pedido;
    }

}
