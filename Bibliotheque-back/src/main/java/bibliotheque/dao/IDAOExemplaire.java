package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

/* Cette requête vérifie si, pour un livre donné, il existe au moins un exemplaire disponible */
	@Query("select max(ex.disponible) from Exemplaire ex join ex.edition.livre l where l.id = :id")
    Boolean livreDisponible(@Param("id") Integer idLivre);
	
}
