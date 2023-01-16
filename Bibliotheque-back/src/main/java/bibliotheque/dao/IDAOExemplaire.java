package bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

	@Query("select ex from Exemplaire ex join ex.edition ed where ed.id = :id")
    List<Exemplaire> findByEdition(@Param("id") Integer idLivre);

	/* Cette requête vérifie si, pour un livre donné, il existe au moins un exemplaire disponible */
	@Query("select max(ex.disponible) from Exemplaire ex join ex.edition.livre l where l.id = :id")
    Boolean livreDisponible(@Param("id") Integer idLivre);
	
}
