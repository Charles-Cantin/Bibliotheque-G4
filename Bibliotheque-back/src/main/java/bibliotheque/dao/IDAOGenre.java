package bibliotheque.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Genre;

public interface IDAOGenre extends JpaRepository<Genre, Integer>{
	
	@Query("select distinct g from Genre g left join fetch g.livres where g.id = :id")
	Optional<Genre> findByIdWithLivres(@Param("id") Integer id);
	
	@Query("select distinct g from Genre g join g.livres l where l.id = :id")
	List<Genre> findAllByLivre(@Param("id") Integer idLivre);
	

}
