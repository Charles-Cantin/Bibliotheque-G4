package bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Edition;

public interface IDAOEdition extends JpaRepository<Edition, Integer>{
	
	@Query("select distinct e from Edition e join e.livre l where l.id = :id")
	List<Edition> findAllByLivre(@Param("id") Integer idLivre);
	
	@Query("select distinct e from Edition e join e.exemplaires where e.id = :id")
	Optional<Edition> findByIdWithExemplaires(@Param("id") Integer id);
	
	/* Combien d'exemplaires disponibles pour une edition donnée ?*/
	@Query("select count(ex) from Exemplaire ex join ex.edition e where e.id = ?1 and ex.disponible=true")
	Integer compterEditionDisponible(Integer idEdition);
}
