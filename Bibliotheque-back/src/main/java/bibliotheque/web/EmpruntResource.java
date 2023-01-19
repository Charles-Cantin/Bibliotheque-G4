package bibliotheque.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
import bibliotheque.dao.IDAOLecteur;
import bibliotheque.model.Emprunt;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Lecteur;
import bibliotheque.model.Views;
import bibliotheque.web.dto.AjoutEmpruntDTO;
import bibliotheque.web.dto.EmpruntLecteurDTO;

@RestController
@RequestMapping("/emprunts")
@CrossOrigin("*")
public class EmpruntResource {

	@Autowired
	private IDAOEmprunt daoEmprunt;
	@Autowired
	private IDAOExemplaire daoExemplaire;
	@Autowired
	private IDAOLecteur daoLecteur;

	@GetMapping("")
	@JsonView(Views.ViewEmprunt.class)
	public List <Emprunt> findAll() {
		List<Emprunt> emprunts = daoEmprunt.findAll();

		return emprunts;
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt findById(@PathVariable Integer id) {
		return daoEmprunt.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@GetMapping("/{id_emprunteur}/empruntsDTO")
	@JsonView(Views.ViewEmpruntLecteurDTO.class)

	public List<EmpruntLecteurDTO> findEmpruntsByLecteur(@PathVariable Integer id_emprunteur) {

		List<Emprunt> emprunts = daoEmprunt.findAllByEmprunteur(id_emprunteur);

		System.out.println(emprunts);

		List<EmpruntLecteurDTO> empruntsDTO = new ArrayList<>();

		for (Emprunt emprunt : emprunts) {

			EmpruntLecteurDTO empruntLecteurDTO = new EmpruntLecteurDTO();

			empruntLecteurDTO.setIdExemplaire(emprunt.getExemplaire().getId());
			empruntLecteurDTO.setTitreLivre(emprunt.getExemplaire().getEdition().getLivre().getTitre());
			empruntLecteurDTO.setDebut(emprunt.getDebut());
			empruntLecteurDTO.setFin(emprunt.getFin());
			empruntLecteurDTO.setDateRendu(emprunt.getDateRendu());

			empruntsDTO.add(empruntLecteurDTO);

		}

		return empruntsDTO;
	}
	
	@PostMapping("")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt create(@Valid @RequestBody AjoutEmpruntDTO ajoutEmprunt, BindingResult result) {
		if (result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "L'emprunt n'a pu être créé");
		}

		Exemplaire exemplaire = daoExemplaire.findById(ajoutEmprunt.getIdExemplaire())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, 
						"No exemplaires with specified ID were found"));
		
		Lecteur emprunteur = daoLecteur.findById(ajoutEmprunt.getIdEmprunteur())
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,
						"No lecteurs with specified ID were found"));
		
		Emprunt emprunt = new Emprunt();
		emprunt.setExemplaire(exemplaire);
		emprunt.setEmprunteur(emprunteur);
		emprunt.setDebut(ajoutEmprunt.getDebut());
		emprunt.setFin(ajoutEmprunt.getFin());
		emprunt.setDateRendu(ajoutEmprunt.getDateRendu());
		emprunt = daoEmprunt.save(emprunt);
		
		if (ajoutEmprunt.getDateRendu()==null) {
			exemplaire.setEmprunted(true);
			exemplaire = daoExemplaire.save(exemplaire);
		}
		
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


	@PatchMapping("/rendre/{id}")
	@JsonView(Views.ViewEmpruntDetail.class)
	public Emprunt update(@PathVariable Integer id) {
		
		Emprunt empruntARendre = daoEmprunt.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	
		
		
		empruntARendre.setDateRendu(LocalDate.now());
		empruntARendre = daoEmprunt.save(empruntARendre);
		
		Exemplaire exemplaire = empruntARendre.getExemplaire();
		exemplaire.setEmprunted(false);
		
		return empruntARendre;
	}



	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if (!daoEmprunt.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		daoEmprunt.deleteById(id);
	}
}
