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

import bibliotheque.dao.IDAOAuteur;
import bibliotheque.model.Auteur;
import bibliotheque.model.Views;


@RestController
@RequestMapping("/auteurs")
@CrossOrigin("*")
public class AuteurRessource {

@Autowired	
private IDAOAuteur daoAuteur;

@GetMapping("")
@JsonView(Views.ViewBase.class)
public List <Auteur> findAll() {
	List<Auteur> auteur = daoAuteur.findAll();

	return auteur;
}


@GetMapping("/{id}")
@JsonView(Views.ViewAuteurDetail.class)
public Auteur findByIdWithLivres(@PathVariable Integer id) {
	Optional<Auteur> optAuteur = daoAuteur.findByIdWithLivres(id);

	if (optAuteur.isEmpty()) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	return optAuteur.get();
}

@PostMapping("")
@JsonView(Views.ViewBase.class)
public Auteur create(@Valid @RequestBody Auteur auteur, BindingResult result) {
	if (result.hasErrors()) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'auteur n'a pu être créé");
	}

	auteur = daoAuteur.save(auteur);

	return auteur;
}


@PutMapping("/{id}")
@JsonView(Views.ViewBase.class)
public Auteur update(@PathVariable Integer id, @RequestBody Auteur auteur) {
	if (id != auteur.getId() || !daoAuteur.existsById(id)) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}

	auteur = daoAuteur.save(auteur);

	return auteur;
}

@DeleteMapping("/{id}")
public void delete(@PathVariable Integer id) {
	if (!daoAuteur.existsById(id)) {
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	daoAuteur.deleteById(id);
}

	
}
