package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Editeur;

public interface IDAOEditeur extends JpaRepository<Editeur, Integer>{

//	@Query("SELECT distinct e from Editeur e left join fetch e.exemplaires where e.id = :id")
//	public Optional<Editeur> findByIdWithEditions(@Param("id") Integer id);
}
