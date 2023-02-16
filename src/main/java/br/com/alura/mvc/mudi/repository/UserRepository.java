package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}
