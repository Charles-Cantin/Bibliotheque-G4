package bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Livre;

public interface IDAOLivre extends JpaRepository<Livre,Integer>{
	// find all by auteurs / auteur ?
	// find all by genres / genre ?
	// find by (chaque attribut)
	
	
	@Query("select distinct l from Livre l left join fetch l.auteurs")
	List<Livre> findAllWithAuteurs();
	
	@Query("select distinct l from Livre l left join fetch l.auteurs where l.id = :id")
	Optional<Livre> findByIdWithAuteurs(@Param("id") Integer id);
	
	@Query("select distinct l from Livre l left join fetch l.genres where l.id = :id")
	Optional<Livre> findByIdWithGenres(@Param("id") Integer id);
	
	@Query("select distinct l from Livre l left join fetch l.editions where l.id = :id")
	Optional<Livre> findByIdWithEditions(@Param("id") Integer id);
	
	/* Y a-t-il au moins un exemplaire disponible pour un livre donné ? UNTESTED*/
	@Query("select max(1-ex.emprunted) from Exemplaire ex join ex.edition.livre l where l.id = ?1")
	Boolean livreDisponible(Integer idLivre);
	
	@Query("from Livre l where lower(l.titre) like lower(concat('%',?1,'%'))")
	List<Livre> findByTitleContainingIgnoreCase(String searchTerm);
	
	@Query("from Livre l join l.auteurs a "
			+ "where lower(l.titre) like lower(concat('%',?1,'%')) "
			+ "or lower(a.nom) like lower(concat('%',?1,'%')) "
			+ "or lower(a.prenom) like lower(concat('%',?1,'%'))")
	List<Livre> findByTitleOrAuteursContainingIgnoreCase(String searchTerm);
	
}
