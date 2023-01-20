package bibliotheque.web;

import java.util.ArrayList;
import java.util.List;

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
import bibliotheque.dao.IDAOEdition;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Auteur;
import bibliotheque.model.Edition;
import bibliotheque.model.Livre;
import bibliotheque.model.Views;
import bibliotheque.web.dto.LivreCreationDTO;
import bibliotheque.web.dto.ResultatDTO;

@RestController
@RequestMapping("/livres")
@CrossOrigin("*")
public class LivreResource {

	@Autowired
	private IDAOLivre daoLivre;
	@Autowired
	private IDAOEdition daoEdition;
	@Autowired
	private IDAOAuteur daoAuteur;

	@GetMapping("")
	@JsonView(Views.ViewLivre.class)
	public List <Livre> findAll() {
		List<Livre> livres = daoLivre.findAll();

		return livres;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre findById(@PathVariable Integer id) {
		Livre livre = daoLivre.findByIdWithAuteurs(id)
				.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		// Si besoin de charger des listes car problème avec du lazy loading :
		// Hibernate.initialize(livre.getAuteurs());
		// Hibernate.initialize(livre.getEditions());

		return livre;
	}

	@PostMapping("/searchV1")
	@JsonView(Views.ViewResultatsDTO.class)
	public List<ResultatDTO> titleAuthorSearchV1(@RequestBody String keyword) {
		//final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		List<Livre> livres = daoLivre.findByTitleOrAuteursContainingIgnoreCase(keyword);
		List<ResultatDTO> resultats = new ArrayList<>();

		if (livres.isEmpty()) {
			return resultats;
		}
		
		else {
			for (Livre livre : livres) {
				ResultatDTO resultatDTO = new ResultatDTO();
				resultatDTO.setIdLivre(livre.getId());
				resultatDTO.setTitre(livre.getTitre());
				resultatDTO.setAuteurs(livre.auteursToDTO());
				resultatDTO.setGenres(livre.genresToDTO());
				resultatDTO.setNombreLivresDispo(daoLivre.countLivreDisponible(livre.getId()));
				resultatDTO.setPublication(livre.getDateParution());
				for(Edition edition: livre.getEditions()) {
					ResultatDTO.Eddy ed = resultatDTO.new Eddy();
					ed.setIdEdition(edition.getId());
					ed.setUrlCover(edition.getUrlCover());
					ed.setISBN(edition.getIsbn());
					ed.setPages(edition.getPages());
					ed.setFormat(edition.getFormat());
					ed.setLangue(edition.getLangue());
					ed.setNomEditeur(edition.getEditeur().getNom());
					ed.setNombreEditionDispo(daoEdition.compterEditionDisponible(edition.getId()));
					resultatDTO.getEditions().add(ed);
				}
				resultats.add(resultatDTO);
			}

			return resultats;
		}
	}


	/*@PostMapping("")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre create(@Valid @RequestBody Livre livre, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le livre n'a pu être créé");
		}

		livre = daoLivre.save(livre);
		return findById(livre.getId());
	}*/

	@PostMapping("")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre create(@Valid @RequestBody LivreCreationDTO livredto, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Le livre n'a pu être créé");
		}

		Livre livre = new Livre();

		List<Auteur> listauteurs = new ArrayList<Auteur>();

		// for (Integer id : ) {}

		listauteurs.add(daoAuteur.findById(livredto.getAuteurs()).get());	 		 
		livre.setTitre(livredto.getTitre());
		livre.setResume(livredto.getResume());
		livre.setDateParution(livredto.getPublication());
		livre.setAuteurs(listauteurs);



		livre = daoLivre.save(livre);
		return findById(livre.getId());
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewLivreDetail.class)
	public Livre update(@PathVariable Integer id, @RequestBody Livre livre) {
		if (id != livre.getId() || !daoLivre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		livre = daoLivre.save(livre);
		return findById(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoLivre.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoLivre.deleteById(id);
	}
}
