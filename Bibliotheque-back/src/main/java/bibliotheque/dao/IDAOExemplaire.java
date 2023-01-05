package bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Exemplaire;

public interface IDAOExemplaire extends JpaRepository<Exemplaire, Integer>{

	// TODO : VÉRIFIER CETTE HORREUR ANTÉDÉLUVIENNE
	@Query("select distinct ex.disponible from Exemplaire ex join ex.edition.livre l where l.id = :id")
    List<Boolean> findDisponibilitesByLivre(@Param("id") Integer idLivre);
	
}
