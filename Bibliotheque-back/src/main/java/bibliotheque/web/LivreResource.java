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

import bibliotheque.dao.IDAOEdition;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Edition;
import bibliotheque.model.Genre;
import bibliotheque.model.Livre;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/livres")
@CrossOrigin("*")
public class LivreResource {
	
	@Autowired
	private IDAOLivre daoLivre;
	@Autowired
	private IDAOGenre daoGenre;
	@Autowired
	private IDAOEdition daoEdition;
	
	@GetMapping("")
	@JsonView(Views.ViewLivre.class)
	public List <Livre> findAll() {
		List<Livre> livres = daoLivre.findAllWithAuteurs();

		return livres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre findById(@PathVariable Integer id) {
		Optional<Livre> optLivre = daoLivre.findByIdWithAuteurs(id);

		if (optLivre.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		List<Genre> genres = daoGenre.findAllByLivre(id);
		List<Edition> editions = daoEdition.findAllByLivre(id);
		
		Livre livre = optLivre.get();
		livre.setGenres(genres);
		livre.setEditions(editions);
		return livre;
	}

	
	@PostMapping("")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre create(@Valid @RequestBody Livre livre, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le livre n'a pu être créé");
		}

		livre = daoLivre.save(livre);
		return findById(livre.getId());
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre update(@PathVariable Integer id, @RequestBody Livre livre) {
		if (id != livre.getId() || !daoLivre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		livre = daoLivre.save(livre);
		return findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoLivre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoLivre.deleteById(id);
	}
}
