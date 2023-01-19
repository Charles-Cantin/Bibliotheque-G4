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

import bibliotheque.dao.IDAOLecteur;
import bibliotheque.model.Lecteur;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/lecteurs")
@CrossOrigin("*")
public class LecteurResource {
	
	@Autowired
	private IDAOLecteur daoLecteur;

	@GetMapping("")
	@JsonView(Views.ViewLecteur.class)
	public List <Lecteur> findAll() {
		List<Lecteur> lecteurs = daoLecteur.findAll();

		return lecteurs;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLecteur.class)
	public Lecteur findById(@PathVariable Integer id) {
		Optional<Lecteur> optLecteur = daoLecteur.findById(id);

		if (optLecteur.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optLecteur.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewLecteurDetail.class)
	public Lecteur create(@Valid @RequestBody Lecteur lecteur, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le lecteur n'a pu être créé");
		}

		lecteur = daoLecteur.save(lecteur);

		return lecteur;
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewLecteurDetail.class)
	public Lecteur update(@PathVariable Integer id, @RequestBody Lecteur lecteur) {
		if (id != lecteur.getId() || !daoLecteur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		lecteur = daoLecteur.save(lecteur);

		return lecteur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoLecteur.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoLecteur.deleteById(id);
	}
}
