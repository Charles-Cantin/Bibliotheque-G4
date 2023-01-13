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

import bibliotheque.dao.IDAOCompte;
import bibliotheque.model.Compte;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/comptes")
@CrossOrigin("*")
public class CompteResource {
	
	@Autowired
	private IDAOCompte daoCompte;

	@GetMapping("")
	@JsonView(Views.ViewCompte.class)
	public List <Compte> findAll() {
		List<Compte> comptes = daoCompte.findAll();

		return comptes;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte findById(@PathVariable Integer id) {
		Optional<Compte> optCompte = daoCompte.findById(id);

		if (optCompte.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompte.get();
	}

	
	@PostMapping("/inscription")
	@JsonView(Views.ViewCompte.class)
	public Compte create(@Valid @RequestBody Compte compte, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le compte n'a pu être créé");
		}

		compte = daoCompte.save(compte);

		return compte;
	}
	
	@PostMapping("/connexion")
	@JsonView(Views.ViewCompte.class)
	public Compte connecter(@RequestBody Compte compte) {
		
		Optional<Compte> optCompte = daoCompte.findByLoginAndPassword(compte.getLogin(), compte.getPassword());

		return optCompte.get();
	}
	

	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCompte.class)
	public Compte update(@PathVariable Integer id, @RequestBody Compte compte) {
		if (id != compte.getId() || !daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		compte = daoCompte.save(compte);

		return compte;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompte.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompte.deleteById(id);
	}
}
