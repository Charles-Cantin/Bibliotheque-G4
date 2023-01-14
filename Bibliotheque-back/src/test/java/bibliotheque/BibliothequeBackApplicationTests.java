package bibliotheque;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import bibliotheque.dao.IDAOAuteur;
import bibliotheque.dao.IDAOCompte;
import bibliotheque.dao.IDAOEditeur;
import bibliotheque.dao.IDAOEdition;
import bibliotheque.dao.IDAOExemplaire;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Admin;
import bibliotheque.model.Auteur;
import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Editeur;
import bibliotheque.model.Edition;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Genre;
import bibliotheque.model.Livre;

@SpringBootTest
class BibliothequeBackApplicationTests {

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
	void contextLoads() {
		// Sauvegarde d'un Livre, son auteur, son genre
		Auteur a1 = new Auteur("Herbert", "Frank", LocalDate.parse("1920-10-08"), null);
		a1 = daoAuteur.save(a1);// Sauve l'auteur ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Genre g1 = new Genre("SF");
		g1 = daoGenre.save(g1);	// Sauve le genre ; table jointure non MàJ (cf classe Livre pour plus d'info)
		
		Livre l1 = new Livre();
		l1.setTitre("Dune");
		l1.setResume(
				  "Non omnis hic perspiciatis earum consequatur velit. Fugit itaque optio at suscipit accusamus. Est sit rerum sed aut esse. Aut corporis occaecati sit saepe expedita omnis.\n"
				+ "\n"
				+ "Aut architecto itaque accusamus quas dolorum. Quis molestiae qui similique consequuntur cupiditate excepturi voluptate. Libero atque voluptas quasi inventore voluptas eligendi enim. Et reprehenderit est omnis totam sit alias rem dicta.\n"
				+ "\n"
				+ "Dicta non et quasi. Culpa reprehenderit et labore. Aspernatur mollitia distinctio aut itaque. Illo quos ut nobis nemo. Recusandae est fugit rerum perspiciatis quos ex harum. Temporibus esse natus placeat voluptates vero nesciunt sint illum.\n"
				+ "\n"
				+ "Reprehenderit rerum et iste quod tempora voluptatem non omnis. Consequatur est sed autem. Totam ratione cumque nulla quos. Dolorum ut autem possimus eum doloribus maiores eveniet. Numquam cum quia laboriosam ex temporibus.\n"
				+ "\n"
				+ "Quae adipisci laborum nihil ut eaque aut mollitia consequatur. Vel aut ipsam et. Necessitatibus et et est sed quod reiciendis et. Cum soluta omnis totam corporis vero laudantium. Tempore esse expedita quia quo et.\n"
				+ "");
		l1.setDateParution( LocalDate.of(1965, 12, 31) );
		l1.setAuteurs( Arrays.asList(a1) );
		l1.setGenres( Arrays.asList(g1) );
		l1 = daoLivre.save(l1);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		// Sauvegarde de plusieurs exemplaires, de deux éditions différentes, de ce livre
		Editeur pocket = new Editeur("Pocket");
		pocket = daoEditeur.save(pocket);
		
		Editeur GF = new Editeur("GF");
		GF = daoEditeur.save(GF);

		Edition ed1 = new Edition();
		ed1.setIsbn("978-0-0000-0000-1");
		ed1.setFormat("Poche");
		ed1.setLangue("Anglais");
		ed1.setPages(1200);
		ed1.setLivre(l1);
		ed1.setEditeur(pocket);
		ed1 = daoEdition.save(ed1);
		
		Edition ed2 = new Edition();
		ed2.setIsbn("978-0-0000-0000-2");
		ed2.setFormat("Hardcover");
		ed2.setLangue("Français");
		ed2.setPages(1250);
		ed2.setLivre(l1);
		ed2.setEditeur(GF);
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
		
		Bibliothecaire b1 = new Bibliothecaire();
		b1.setLogin("toto");
		b1.setPassword("tata");
		b1.setNom("bob");
		b1.setPrenom("baba");

		b1 = daoCompte.save(b1);
	}

}
