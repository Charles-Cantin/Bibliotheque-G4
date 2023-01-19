package bibliotheque.dao;

import java.time.LocalDate;
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
	
	@Query("select em from Emprunt em where em.exemplaire.id = ?1")
	public List<Emprunt> findAllByExemplaire(Integer idExemplaire);
	
	@Query("select em from Emprunt em where (em.exemplaire.id = ?1 and em.dateRendu is null)")
	public Optional<Emprunt> findCurrentByExemplaire(Integer idExemplaire);
	
	@Query("select em from Emprunt em where (em.fin > ?1 and em.dateRendu is null)")
	public List<Emprunt> findLate(LocalDate dateToday);
	
}
