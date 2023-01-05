package bibliotheque.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bibliotheque.model.Auteur;

public interface IDAOAuteur extends JpaRepository<Auteur,Integer>{

	
	@Query("select distinct a from Auteur a left join fetch a.livres where a.id = :id")
	public Optional<Auteur> findByIdWithLivres(Integer id);

	
	
}
