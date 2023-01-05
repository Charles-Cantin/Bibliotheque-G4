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

import bibliotheque.dao.IDAOInscrit;
import bibliotheque.model.Inscrit;
import bibliotheque.model.Views;

@RestController
@RequestMapping("/inscrits")
@CrossOrigin("*")
public class InscritResource {
	
	@Autowired
	private IDAOInscrit daoInscrit;

	@GetMapping("")
	@JsonView(Views.ViewInscrit.class)
	public List <Inscrit> findAll() {
		List<Inscrit> inscrits = daoInscrit.findAll();

		return inscrits;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewInscrit.class)
	public Inscrit findById(@PathVariable Integer id) {
		Optional<Inscrit> optInscrit = daoInscrit.findById(id);

		if (optInscrit.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optInscrit.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewInscritDetail.class)
	public Inscrit create(@Valid @RequestBody Inscrit inscrit, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le inscrit n'a pu être créé");
		}

		inscrit = daoInscrit.save(inscrit);

		return inscrit;
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewInscritDetail.class)
	public Inscrit update(@PathVariable Integer id, @RequestBody Inscrit inscrit) {
		if (id != inscrit.getId() || !daoInscrit.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		inscrit = daoInscrit.save(inscrit);

		return inscrit;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoInscrit.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoInscrit.deleteById(id);
	}
}
