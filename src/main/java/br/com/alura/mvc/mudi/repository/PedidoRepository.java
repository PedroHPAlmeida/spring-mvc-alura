package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatusAndUserUsername(StatusPedido status, String user);

    @Query("SELECT p FROM Pedido p WHERE p.user.username = :username")
    List<Pedido> findAllByUser(@Param("username") String username);

    List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

}
