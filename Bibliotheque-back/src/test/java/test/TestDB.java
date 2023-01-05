package test;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bibliotheque.dao.IDAOAuteur;
import bibliotheque.dao.IDAOCompte;
import bibliotheque.dao.IDAOEditeur;
import bibliotheque.dao.IDAOEdition;
import bibliotheque.dao.IDAOExemplaire;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Admin;
import bibliotheque.model.Auteur;
import bibliotheque.model.Editeur;
import bibliotheque.model.Edition;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Genre;
import bibliotheque.model.Livre;

@RunWith(SpringJUnit4ClassRunner.class)
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
	@Autowired
	private IDAOCompte daoCompte;
	
	@Test
	public void createAndSaveBookInDB() {
		// ARRANGE
		
		// ACT
		// Sauvegarde d'un Livre, son auteur, son genre
		Auteur a1 = new Auteur("Herbert", "Frank", LocalDate.parse("1920-10-08"), null);
		a1 = daoAuteur.save(a1);// Sauve l'auteur ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Genre g1 = new Genre("SF");
		g1 = daoGenre.save(g1);	// Sauve le genre ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Livre l1 = new Livre("Dune",1965,a1,g1,null);
		l1 = daoLivre.save(l1);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		// Sauvegarde de plusieurs exemplaires, de deux éditions différentes, de ce livre
		Editeur pocket = new Editeur("Pocket");
		pocket = daoEditeur.save(pocket);
		
		Editeur GF = new Editeur("GF");
		GF = daoEditeur.save(GF);

		Edition ed1 = new Edition("978-0-0000-0000-1",l1,pocket,null);
		ed1 = daoEdition.save(ed1);
		
		Edition ed2 = new Edition("978-0-0000-0000-2", l1, GF, null);
		ed2 = daoEdition.save(ed2);

		Exemplaire ex11 = new Exemplaire(ed1, true);
		ex11 = daoExemplaire.save(ex11);
		
		Exemplaire ex12 = new Exemplaire(ed1, true);
		ex12 = daoExemplaire.save(ex12);
		
		Exemplaire ex13 = new Exemplaire(ed1, false);
		ex13 = daoExemplaire.save(ex13);

		Exemplaire ex21 = new Exemplaire(ed2, true);
		ex21 = daoExemplaire.save(ex21);
		
		Exemplaire ex22 = new Exemplaire(ed2, false);
		ex22 = daoExemplaire.save(ex22);
		
		// ASSERT

	}
	
	@Test
	public void createAndSaveAccountInDB() {
		Admin a = new Admin();
		a.setPassword("pass");
		a.setLogin("lo");
		daoCompte.save(a);
		
		/*Compte b1 = new Bibliothecaire();
		b1.setLogin("toto");
		b1.setPassword("tata");
		b1.setNom("bob");
		b1.setPrenom("baba");

		b1 = daoCompte.save(b1);*/
	}
}
