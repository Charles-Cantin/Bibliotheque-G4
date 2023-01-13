package bibliotheque.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Compte;

public interface IDAOCompte extends JpaRepository<Compte,Integer>{
	
	@Query("Select c from Compte c where c.login = :login and c.password = :password")
	public Optional<Compte> findByLoginAndPassword(@Param("login") String login, @Param("password")String password);
}