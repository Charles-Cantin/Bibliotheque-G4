package bibliotheque.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Emprunt;

public interface IDAOEmprunt extends JpaRepository<Emprunt, Integer>{
	// find by emprunteur
	
	@Query("SELECT e from Emprunt e where e.emprunteur.id = :id")
	public List<Emprunt> findAllByEmprunteur(@Param("id") Integer idEmprunteur);
	
	// find by exemplaire
	
//	@Query("SELECT e from Emprunt e where e.exemplaire.id = :id")
//	public List<Emprunt> findAllByExemplaire(@Param("id") Integer idExemplaire);
	
	// trouver emprunts en cours
	
//	@Query("SELECT e from Emprunt e where e.rendu = false")
//	public List<Emprunt> findByRenduFalse();
	
}
