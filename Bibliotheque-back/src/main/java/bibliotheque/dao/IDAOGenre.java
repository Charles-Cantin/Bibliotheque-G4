package bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import bibliotheque.model.Genre;

public interface IDAOGenre extends JpaRepository<Genre, Integer>{

}
