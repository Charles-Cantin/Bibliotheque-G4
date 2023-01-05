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

import bibliotheque.dao.IDAOEmprunt;
import bibliotheque.model.Emprunt;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/emprunts")
@CrossOrigin("*")
public class EmpruntResource {
	
	@Autowired
	private IDAOEmprunt daoEmprunt;

	@GetMapping("")
	@JsonView(Views.ViewEmprunt.class)
	public List <Emprunt> findAll() {
		List<Emprunt> emprunts = daoEmprunt.findAll();

		return emprunts;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt findById(@PathVariable Integer id) {
		Optional<Emprunt> optEmprunt = daoEmprunt.findById(id);

		if (optEmprunt.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optEmprunt.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt create(@Valid @RequestBody Emprunt emprunt, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'emprunt n'a pu être créé");
		}

		emprunt = daoEmprunt.save(emprunt);

		return emprunt;
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt update(@PathVariable Integer id, @RequestBody Emprunt emprunt) {
		if (id != emprunt.getId() || !daoEmprunt.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		emprunt = daoEmprunt.save(emprunt);

		return emprunt;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoEmprunt.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoEmprunt.deleteById(id);
	}
}
