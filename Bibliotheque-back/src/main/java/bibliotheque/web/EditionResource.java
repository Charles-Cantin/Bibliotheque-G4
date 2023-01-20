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
import bibliotheque.model.Editeur;
import bibliotheque.model.Edition;
import bibliotheque.model.Livre;
import bibliotheque.model.Views;
import bibliotheque.web.dto.EditionDTO;

@RestController
@RequestMapping("/editions")
@CrossOrigin("*")
public class EditionResource {
	
	@Autowired
	private IDAOEdition daoEdition;

	@GetMapping("")
	@JsonView(Views.ViewEdition.class)
	public List <Edition> findAll() {
		List<Edition> editions = daoEdition.findAll();

		return editions;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEditionDetail.class)
	public Edition findById(@PathVariable Integer id) {
		Optional<Edition> optEdition = daoEdition.findByIdWithExemplaires(id);

		if (optEdition.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return optEdition.get();
	}

	@GetMapping("/{id}/dto")
	@JsonView(Views.ViewEditionDTO.class)
	public EditionDTO findDTOById(@PathVariable Integer id) {
		Optional<Edition> optEdition = daoEdition.findById(id);

		if (optEdition.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		Edition edition = optEdition.get();
		Livre livre = edition.getLivre() ;
		Editeur editeur = edition.getEditeur();
		
		EditionDTO editionDTO = new EditionDTO();

		editionDTO.setIdEdition(edition.getId()) ;
		editionDTO.setISBN(edition.getIsbn()) ;
		editionDTO.setPages(edition.getPages()) ;
		editionDTO.setFormat(edition.getFormat()) ;
		editionDTO.setLangue(edition.getLangue()) ;

		editionDTO.setTitre(livre.getTitre()) ;
		editionDTO.setResume(livre.getResume()) ;
		editionDTO.setAnneeParution(livre.getDateParution().getYear()) ;
		editionDTO.setNomsAuteurs(livre.auteursToDTO());
		editionDTO.setNomEditeur(editeur.getNom());
		editionDTO.setNomsGenres(livre.genresToDTO());
		editionDTO.setUrlCover(edition.getUrlCover());

		return editionDTO;
	}
	
	@PostMapping("")
	@JsonView(Views.ViewEditionDetail.class)
	public Edition create(@Valid @RequestBody Edition edition, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le edition n'a pu être créé");
		}

		edition = daoEdition.save(edition);
		Optional<Edition> optEdition = daoEdition.findByIdWithExemplaires(edition.getId());

		return optEdition.get();
	}



	@PutMapping("/{id}")
	@JsonView(Views.ViewEditionDetail.class)
	public Edition update(@PathVariable Integer id, @RequestBody Edition edition) {
		if (id != edition.getId() || !daoEdition.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		edition = daoEdition.save(edition);
		Optional<Edition> optEdition = daoEdition.findByIdWithExemplaires(id);

		return optEdition.get();
	}

	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoEdition.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoEdition.deleteById(id);
	}
}
