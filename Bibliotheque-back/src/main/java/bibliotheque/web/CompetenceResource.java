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

import poudlard.model.Competence;
import poudlard.model.Views;
import poudlard.repository.ICompetenceRepository;

@RestController
@RequestMapping("/competences")
@CrossOrigin("*")
public class CompetenceResource {
	
	@Autowired
	private ICompetenceRepository daoCompetence;

	@GetMapping("")
	@JsonView(Views.ViewCompetence.class)
	public List <Competence> findAll() {
		List<Competence> competences = daoCompetence.findAll();

		return competences;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewCompetenceDetail.class)
	public Competence findById(@PathVariable Integer id) {
		Optional<Competence> optCompetence = daoCompetence.findById(id);

		if (optCompetence.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optCompetence.get();
	}

	
	@PostMapping("")
	@JsonView(Views.ViewCompetenceDetail.class)
	public Competence create(@Valid @RequestBody Competence competence, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le competence n'a pu être créé");
		}

		competence = daoCompetence.save(competence);

		return competence;
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewCompetenceDetail.class)
	public Competence update(@PathVariable Integer id, @RequestBody Competence competence) {
		if (id != competence.getId() || !daoCompetence.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		competence = daoCompetence.save(competence);

		return competence;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoCompetence.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoCompetence.deleteById(id);
	}
}
