package bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

	@Query("select ex from Exemplaire ex join ex.edition ed where ed.id = :id")
    List<Exemplaire> findByEdition(@Param("id") Integer idLivre);
	
	/* Y a-t-il un exemplaire disponible pour un livre donné ? */
	@Query("select count(ex) from Exemplaire ex join ex.edition.livre l where l.id = ?1 and ex.emprunted = false")
    Boolean livreDisponible(Integer idLivre); //MUST REMOVE BY V1 
	
	@Query("SELECT ex FROM Exemplaire ex WHERE ex.edition.id = ?1")
	public List<Exemplaire> findAllByEdition(Integer id_edition);

	@Query("select ex from Exemplaire ex where ex.id = ?1 and ex.emprunted = false")
	Optional<Exemplaire> findAvailableById(Integer idExemplaire);
	
	
}
