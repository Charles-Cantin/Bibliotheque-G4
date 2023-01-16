package bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

	@Query("select ex from Exemplaire ex join ex.edition ed where ed.id = :id")
    List<Exemplaire> findByEdition(@Param("id") Integer idLivre);
	/* Y a-t-il un exemplaire disponible pour un livre donné ? */
	@Query("select max(ex.disponible) from Exemplaire ex join ex.edition.livre l where l.id = ?1")
    Boolean livreDisponible(Integer idLivre);
	
	
	/* Combien d'exemplaires disponibles pour un livre donné ? UNTESTED*/
	@Query("select sum(ex.disponible) from Exemplaire ex join ex.edition.livre l where l.id = ?1")
	int nombreDisponible(Integer idLivre);
}
