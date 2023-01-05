package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Inscrit;

public interface IDAOInscrit extends JpaRepository<Inscrit,Integer>{
	
//	public Inscrit findByLoginAndPassword(String login, String password);
}