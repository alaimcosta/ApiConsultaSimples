package br.com.altec.repositories;

import br.com.altec.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//A anotação @Repository é usada para marcar essa interface como um bean Spring que manipula o acesso a dados para a entidade Usuario.
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
