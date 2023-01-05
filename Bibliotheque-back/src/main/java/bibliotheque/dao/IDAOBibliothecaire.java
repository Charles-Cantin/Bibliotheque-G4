package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Compte;

public interface IDAOBibliothecaire extends JpaRepository<Bibliothecaire,Integer>{
	
	
	

}