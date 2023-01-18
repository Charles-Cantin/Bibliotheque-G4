package bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bibliotheque.model.Emprunt;

public interface IDAOEmprunt extends JpaRepository<Emprunt, Integer>{
	// find by emprunteur
	
	@Query("SELECT e from Emprunt e where e.emprunteur.id = ?1")
	public List<Emprunt> findAllByEmprunteur(Integer id_emprunteur);
	
	// find by exemplaire
	
	@Query("select em from Emprunt em where em.exemplaire.id = ?1 and em.rendu = false")
	public Optional<Emprunt> findCurrentByExemplaire(Integer idExemplaire);
	
	// trouver emprunts en cours
	
//	@Query("SELECT e from Emprunt e where e.rendu = false")
//	public List<Emprunt> findByRenduFalse();
	
}
