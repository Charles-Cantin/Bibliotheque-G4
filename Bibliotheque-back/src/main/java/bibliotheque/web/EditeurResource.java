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

import bibliotheque.dao.IDAOEditeur;
import bibliotheque.model.Editeur;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/editeurs")
@CrossOrigin("*")
public class EditeurResource {
	
	@Autowired
	private IDAOEditeur daoEditeur;

	@GetMapping("")
	@JsonView(Views.ViewEditeur.class)
	public List <Editeur> findAll() {
		List<Editeur> editeurs = daoEditeur.findAll();

		return editeurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEditeurDetail.class)
	public Editeur findById(@PathVariable Integer id) {
		Optional<Editeur> optEditeur = daoEditeur.findById(id);

		if (optEditeur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optEditeur.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewEditeurDetail.class)
	public Editeur create(@Valid @RequestBody Editeur editeur, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'éditeur n'a pu être créé");
		}

		editeur = daoEditeur.save(editeur);

		return editeur;
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewEditeurDetail.class)
	public Editeur update(@PathVariable Integer id, @RequestBody Editeur editeur) {
		if (id != editeur.getId() || !daoEditeur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		editeur = daoEditeur.save(editeur);

		return editeur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoEditeur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoEditeur.deleteById(id);
	}
}
