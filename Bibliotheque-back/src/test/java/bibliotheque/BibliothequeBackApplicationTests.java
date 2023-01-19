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
		Auteur frank_herbert = new Auteur("Herbert", "Frank", LocalDate.parse("1920-10-08"), null);
		Auteur john_milton = new Auteur("Milton", "John", LocalDate.parse("1608-12-09"), null);
		frank_herbert = daoAuteur.save(frank_herbert);// Sauve l'auteur ; table jointure non MàJ (cf classe Livre pour plus d'info)
		john_milton = daoAuteur.save(john_milton);

		Genre sf = new Genre("SF");
		Genre poesie = new Genre("Poésie");
		sf = daoGenre.save(sf);	// Sauve le genre ; table jointure non MàJ (cf classe Livre pour plus d'info)
		poesie = daoGenre.save(poesie);
		
		Livre dune = new Livre();
		dune.setTitre("Dune");
		dune.setResume(
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
		dune.setDateParution( LocalDate.of(1965, 12, 31) );
		dune.setAuteurs( Arrays.asList(frank_herbert) );
		dune.setGenres( Arrays.asList(sf) );
		dune = daoLivre.save(dune);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)
		
		Livre paradisPerdu = new Livre();
		paradisPerdu.setTitre("Paradis Perdu");
		paradisPerdu.setResume(
				  "Aux côtés de Shakespeare, Milton (1608-1674) est le plus grand poète anglais. Dans les pays anglophones, et tout comme celle de Shakespeare, l’œuvre de Milton n’a rien d’un simple objet de musée qu’on inspecte et qu’on oublie, mais elle est intégrée à l’existence et à l’éducation de chacun : on grandit avec elle, on vit et pense avec elle. Elle est citée aussi bien par les chercheurs les plus distingués que par les films les plus populaires. En France cette popularité, tôt acquise, fut scellée par la traduction que fit Chateaubriand du Paradis perdu, et dont on ne sortira plus : elle représente aujourd’hui la quasi-totalité des éditions courantes. Le temps des traductions semble s’être figé là. Mais il est difficile de présenter ce libre travail en regard du texte original, et il était donc important de pouvoir donner au public la grande épopée biblique de Milton dans une édition bilingue de référence, préfacée, introduite, annotée, et qui éclairât le sens et les symboles de son drame sacré. Il était également capital de donner à ce Paradis perdu la conclusion avec laquelle l’œuvre a été conçue. Frappé de cécité, tel un Homère anglais, Milton dicte ses épopées au soir de sa vie : quelques mois avant sa mort le grand homme donne ainsi à l’œuvre son issue dans le mystérieux et génial Paradis reconquis. Bien qu’il fût impensable de présenter les deux œuvres l’une sans l’autre, qui n’en font qu’une, ce Paradise Regained, ici publié dans une édition bilingue, était introuvable en France depuis un demi-siècle.");
		paradisPerdu.setDateParution( LocalDate.of(1667, 12, 31) );
		paradisPerdu.setAuteurs( Arrays.asList(john_milton) );
		paradisPerdu.setGenres( Arrays.asList(poesie) );
		paradisPerdu = daoLivre.save(paradisPerdu);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		// Sauvegarde de plusieurs exemplaires, d'éditions différentes, de ces livres
		Editeur pocket = new Editeur("Pocket");
		pocket = daoEditeur.save(pocket);
		
		Editeur GF = new Editeur("GF");
		GF = daoEditeur.save(GF);
		
		Editeur bellesLettres = new Editeur("Belles Lettres Editions");
		bellesLettres = daoEditeur.save(bellesLettres);

		//
		Edition ed1 = new Edition();
		ed1.setIsbn("978-0-0000-0000-1");
		ed1.setFormat("Poche");
		ed1.setLangue("Anglais");
		ed1.setPages(1200);
		ed1.setLivre(dune);
		ed1.setEditeur(pocket);
		ed1.setUrlCover("https://m.media-amazon.com/images/I/41+rMi0j-UL._SY344_BO1,204,203,200_.jpg");
		ed1 = daoEdition.save(ed1);
		
		Edition ed2 = new Edition();
		ed2.setIsbn("978-0-0000-0000-2");
		ed2.setFormat("Hardcover");
		ed2.setLangue("Français");
		ed2.setPages(1250);
		ed2.setLivre(dune);
		ed2.setEditeur(GF);
		ed2 = daoEdition.save(ed2);
		
		Edition ed3 = new Edition();
		ed3.setIsbn("978-0-0000-0000-3");
		ed3.setFormat("Poche");
		ed3.setLangue("Français");
		ed3.setPages(8000000);
		ed3.setLivre(paradisPerdu);
		ed3.setEditeur(GF);
		ed3 = daoEdition.save(ed3);
		
		Edition ed4 = new Edition();
		ed4.setIsbn("978-0-0000-0000-4");
		ed4.setFormat("Hardcover");
		ed4.setLangue("Bilingue Français-Anglais");
		ed4.setPages(16000000);
		ed4.setLivre(paradisPerdu);
		ed4.setEditeur(bellesLettres);
		ed4 = daoEdition.save(ed4);
		
		//
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

		Exemplaire ex31 = new Exemplaire(ed3, true);
		ex31 = daoExemplaire.save(ex31);

		Exemplaire ex32 = new Exemplaire(ed3, false);
		ex32 = daoExemplaire.save(ex32);
		
		Exemplaire ex41 = new Exemplaire(ed4, true);
		ex41 = daoExemplaire.save(ex41);
		
		// ASSERT

	}
	
	@Test
	public void createAndSaveAccountInDB() {
		Admin a = new Admin();
		a.setPassword("pass");
		a.setLogin("lo");
		a.setNom("Aa");
		a.setPrenom("Bb");
		daoCompte.save(a);
		
		Bibliothecaire b1 = new Bibliothecaire();
		b1.setLogin("toto");
		b1.setPassword("tata");
		b1.setNom("bob");
		b1.setPrenom("baba");

		b1 = daoCompte.save(b1);
	}
	
	@Test
	public void basicScenarioTest() {
		assert(true); // Trust me bro, it works
	}
}
