package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bibliotheque.dao.IDAOAuteur;
import bibliotheque.dao.IDAOEditeur;
import bibliotheque.dao.IDAOEdition;
import bibliotheque.dao.IDAOExemplaire;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Auteur;
import bibliotheque.model.Editeur;
import bibliotheque.model.Edition;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Genre;
import bibliotheque.model.Livre;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
public class TestDB {

	@Autowired
	private IDAOLivre daoLivre;
	@Autowired
	private IDAOEdition daoEdition;
	@Autowired
	private IDAOEditeur daoEditeur;
	@Autowired
	private IDAOExemplaire daoExemplaire;
	@Autowired
	private IDAOGenre daoGenre;
	@Autowired
	private IDAOAuteur daoAuteur;
	
	@Test
	public void createAndSaveInDB() {
		// ARRANGE
		
		// ACT
		// Sauvegarde d'un Livre, son auteur, son genre
		Auteur a1 = new Auteur("Herbert", "Frank", LocalDate.parse("1920-10-08"), null);
		List<Auteur> mesAuteurs = new ArrayList<Auteur>();
		mesAuteurs.add(a1);
		a1 = daoAuteur.save(a1);// Sauve l'auteur ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Genre g1 = new Genre();
		g1.setLibelle("SF");
		List<Genre> mesGenres = new ArrayList<Genre>();
		mesGenres.add(g1);
		g1 = daoGenre.save(g1);	// Sauve le genre ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Livre l1 = new Livre();
		l1.setTitre("Dune");
		l1.setAuteurs(mesAuteurs);
		l1.setGenres(mesGenres);
		l1.setParutionAnnee(1965);
		l1.setParution(LocalDate.parse("1965-01-01"));
		l1 = daoLivre.save(l1);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		// Sauvegarde de plusieurs exemplaires, de deux éditions différentes, de ce livre
		Editeur pocket = new Editeur();
		pocket.setNom("Pocket");
		pocket = daoEditeur.save(pocket);
		Editeur GF = new Editeur();
		GF.setNom("GF");
		GF = daoEditeur.save(GF);

		Edition ed1 = new Edition();
		ed1.setLivre(l1);
		ed1.setIsbn("978-0-0000-0000-1");
		ed1.setEditeur(pocket);
		ed1 = daoEdition.save(ed1);
		Edition ed2 = new Edition();
		ed1.setLivre(l1);
		ed2.setIsbn("978-0-0000-0000-2");
		ed2.setEditeur(GF);
		ed2 = daoEdition.save(ed2);

		Exemplaire ex11 = new Exemplaire();
		ex11.setEdition(ed1);
		ex11.setDisponible(true);
		ex11 = daoExemplaire.save(ex11);
		Exemplaire ex12 = new Exemplaire();
		ex11.setEdition(ed1);
		ex11.setDisponible(true);
		ex12 = daoExemplaire.save(ex12);
		Exemplaire ex13 = new Exemplaire();
		ex11.setEdition(ed1);
		ex11.setDisponible(false);
		ex13 = daoExemplaire.save(ex13);

		Exemplaire ex21 = new Exemplaire();
		ex11.setEdition(ed2);
		ex11.setDisponible(true);
		ex21 = daoExemplaire.save(ex21);
		Exemplaire ex22 = new Exemplaire();
		ex11.setEdition(ed2);
		ex11.setDisponible(false);
		ex22 = daoExemplaire.save(ex22);
		
		// ASSERT

	}

}
