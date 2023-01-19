package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Bibliothecaire;

public interface IDAOBibliothecaire extends JpaRepository<Bibliothecaire,Integer>{
	

}