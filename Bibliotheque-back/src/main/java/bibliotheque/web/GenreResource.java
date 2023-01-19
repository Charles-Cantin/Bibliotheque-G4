package bibliotheque.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import bibliotheque.dao.IDAOGenre;
import bibliotheque.model.Genre;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/genres")
@CrossOrigin("*")
public class GenreResource {
	
	@Autowired
	private IDAOGenre daoGenre;

	@GetMapping("")
	@JsonView(Views.ViewGenre.class)
	public List <Genre> findAll() {
		List<Genre> genres = daoGenre.findAll();

		return genres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewGenreDetail.class)
	public Genre findById(@PathVariable Integer id) {
		Optional<Genre> optGenre = daoGenre.findByIdWithLivres(id);

		if (optGenre.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optGenre.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewGenreDetail.class)
	public Genre create(@Valid @RequestBody Genre genre, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le genre n'a pu être créé");
		}

		genre = daoGenre.save(genre);
		Optional<Genre> optGenre = daoGenre.findByIdWithLivres(genre.getId());
		
		return optGenre.get();
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewGenreDetail.class)
	public Genre update(@PathVariable Integer id, @RequestBody Genre genre) {
		if (id != genre.getId() || !daoGenre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		genre = daoGenre.save(genre);
		Optional<Genre> optGenre = daoGenre.findByIdWithLivres(id);
		return optGenre.get();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoGenre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoGenre.deleteById(id);
	}
}
