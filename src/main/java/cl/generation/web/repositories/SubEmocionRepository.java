package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import cl.generation.web.models.SubEmocion;

@Repository
public interface SubEmocionRepository extends JpaRepository<SubEmocion, Long>{

}
