package bibliotheque.dao;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Auteur;

public interface IDAOAuteur extends JpaRepository<Auteur,Integer>{

	
	@Query("select distinct a from Auteur a left join fetch a.livres where a.id = :id")
	public Optional<Auteur> findByIdWithLivres(@Param("id") Integer id);

	
	@Query("select distinct a from Auteur a join a.livres l where l.id = :id")
	List<Auteur> findAllByLivre(@Param("id") Integer idLivre);
}
