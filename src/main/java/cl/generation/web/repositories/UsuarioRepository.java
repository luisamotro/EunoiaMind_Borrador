package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import cl.generation.web.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Long> {

}
