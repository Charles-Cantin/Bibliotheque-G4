package bibliotheque.web;

import java.util.ArrayList;
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
import bibliotheque.dao.IDAOExemplaire;
import bibliotheque.model.Editeur;
import bibliotheque.model.Emprunt;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Views;
import bibliotheque.web.dto.ExemplaireByEditionDTO;

@RestController
@RequestMapping("/exemplaires")
@CrossOrigin("*")
public class ExemplaireResource {
	
	@Autowired
	private IDAOExemplaire daoExemplaire;
	@Autowired
	private IDAOEmprunt daoEmprunt;

	@GetMapping("")
	@JsonView(Views.ViewExemplaire.class)
	public List <Exemplaire> findAll() {
		List<Exemplaire> exemplaires = daoExemplaire.findAll();

		return exemplaires;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewExemplaireDetail.class)
	public Exemplaire findById(@PathVariable Integer id) {
		Optional<Exemplaire> optExemplaire = daoExemplaire.findById(id);

		if (optExemplaire.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optExemplaire.get();
	}

	@GetMapping("/by-edition/{id}")
	@JsonView(Views.ViewExemplaireDetail.class)
	public List<ExemplaireByEditionDTO> findByEdition(@PathVariable Integer id) {
		List<Exemplaire> exemplaires = daoExemplaire.findByEdition(id);
		List<ExemplaireByEditionDTO> exemplairesByEditions = new ArrayList<ExemplaireByEditionDTO>();
		
		for (Exemplaire e : exemplaires) {
			Editeur editeur = e.getEdition().getEditeur();
			
			ExemplaireByEditionDTO eDTO = new ExemplaireByEditionDTO();
			eDTO.setIdExemplaire(e.getId());
			eDTO.setEmprunted(e.isEmprunted());
			eDTO.setNomEditeur(editeur.getNom());
			Optional<Emprunt> optEmprunt = daoEmprunt.findCurrentByExemplaire(e.getId());
			
			if(optEmprunt.isEmpty()) {
				eDTO.setDateProchaineDispo(null);
			}
			else {
			eDTO.setDateProchaineDispo(optEmprunt.get().getFin());
			}
			exemplairesByEditions.add(eDTO);
		}
		
		return exemplairesByEditions;
	}

	@PostMapping("")
	@JsonView(Views.ViewExemplaireDetail.class)
	public Exemplaire create(@Valid @RequestBody Exemplaire exemplaire, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le exemplaire n'a pu être créé");
		}

		exemplaire = daoExemplaire.save(exemplaire);
		Optional<Exemplaire> optExemplaire = daoExemplaire.findById(exemplaire.getId());
		
		return optExemplaire.get();
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewExemplaireDetail.class)
	public Exemplaire update(@PathVariable Integer id, @RequestBody Exemplaire exemplaire) {
		if (id != exemplaire.getId() || !daoExemplaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		exemplaire = daoExemplaire.save(exemplaire);
		Optional<Exemplaire> optExemplaire = daoExemplaire.findById(id);
		return optExemplaire.get();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoExemplaire.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoExemplaire.deleteById(id);
	}
}
