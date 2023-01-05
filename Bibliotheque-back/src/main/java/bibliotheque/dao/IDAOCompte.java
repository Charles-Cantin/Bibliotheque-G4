package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{
	
	public Compte findByLoginAndPassword(String login, String password);
	
	@Query("Select b from Bibliothecaire b ")
	public Compte findAllBibliothecaire();
	
	@Query("Select b from Bibliothecaire b where b.id =:id ")
	public Compte findBibliothecairebyId(@Param(value = "id") Integer id);
}