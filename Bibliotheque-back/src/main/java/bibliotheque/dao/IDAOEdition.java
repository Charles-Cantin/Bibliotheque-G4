package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Edition;

public interface IDAOEdition extends JpaRepository<Edition, Integer>{

}
