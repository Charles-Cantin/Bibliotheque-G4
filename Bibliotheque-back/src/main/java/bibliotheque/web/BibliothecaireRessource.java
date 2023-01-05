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

import bibliotheque.dao.IDAOBibliothecaire;
import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Compte;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/bibliothecaires")
@CrossOrigin("*")
public class BibliothecaireRessource {

	@Autowired	
	private IDAOBibliothecaire daoBibliothecaire;

	@GetMapping("")
	@JsonView(Views.ViewBase.class)
	public List <Bibliothecaire> findAll() {
		List<Bibliothecaire> bibliothecaire = daoBibliothecaire.findAll();

		return bibliothecaire;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Bibliothecaire> optBibliothecaire = daoBibliothecaire.findById(id);

		if (optBibliothecaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optBibliothecaire.get();
	}



	@PostMapping("")
	@JsonView(Views.ViewBase.class)
	public Bibliothecaire create(@Valid @RequestBody Bibliothecaire bibliothecaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'auteur n'a pu être créé");
		}

		bibliothecaire = daoBibliothecaire.save(bibliothecaire);

		return bibliothecaire;
	}


	@PutMapping("/{id}")
	@JsonView(Views.ViewBase.class)
	public Bibliothecaire update(@PathVariable Integer id, @RequestBody Bibliothecaire bibliothecaire) {
		if (id != bibliothecaire.getId() || !daoBibliothecaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		bibliothecaire = daoBibliothecaire.save(bibliothecaire);

		return bibliothecaire;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoBibliothecaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoBibliothecaire.deleteById(id);
	}


}
