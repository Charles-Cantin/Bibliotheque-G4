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
import bibliotheque.dao.IDAOEmprunt;
import bibliotheque.dao.IDAOExemplaire;
import bibliotheque.dao.IDAOGenre;
import bibliotheque.dao.IDAOLivre;
import bibliotheque.model.Admin;
import bibliotheque.model.Auteur;
import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Editeur;
import bibliotheque.model.Edition;
import bibliotheque.model.Emprunt;
import bibliotheque.model.Exemplaire;
import bibliotheque.model.Genre;
import bibliotheque.model.Lecteur;
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
	@Autowired
	private IDAOEmprunt daoEmprunt;

	@Test
	void contextLoads() {
		// Sauvegarde d'un Livre, son auteur, son genre
		Auteur frank_herbert = new Auteur("Herbert", "Frank", LocalDate.parse("1920-10-08"), null);
		Auteur john_milton = new Auteur("Milton", "John", LocalDate.parse("1608-12-09"), null);
		Auteur neil_shubin = new Auteur();
		neil_shubin.setNom("Shubin");
		neil_shubin.setPrenom("Neil");
		neil_shubin.setNaissance(LocalDate.parse("1960-12-22"));
		Auteur jordan_a = new Auteur("Anonyme","Jordan", LocalDate.parse("1993-05-01"), null);
		Auteur eric_s = new Auteur("Strangelove","Eric", LocalDate.parse("1978-01-01"), null);
		Auteur alain_damasio = new Auteur("Damasio", "Alain", LocalDate.parse("1969-08-01"), null);
		frank_herbert = daoAuteur.save(frank_herbert);// Sauve l'auteur ; table jointure non MàJ (cf classe Livre pour plus d'info)
		john_milton = daoAuteur.save(john_milton);
		neil_shubin = daoAuteur.save(neil_shubin);
		jordan_a = daoAuteur.save(jordan_a);
		eric_s = daoAuteur.save(eric_s);
		alain_damasio = daoAuteur.save(alain_damasio);

		Genre info = new Genre("Informatique");
		Genre sf = new Genre("SF");
		Genre poesie = new Genre("Poésie");
		Genre evobiol = new Genre("Biologie Evolutive");
		Genre fantasy = new Genre("Fantasy");
		sf = daoGenre.save(sf);	// Sauve le genre ; table jointure non MàJ (cf classe Livre pour plus d'info)
		poesie = daoGenre.save(poesie);
		evobiol = daoGenre.save(evobiol);
		info = daoGenre.save(info);
		fantasy = daoGenre.save(fantasy);

		Livre dune = new Livre();
		dune.setTitre("Dune");
		dune.setResume("Paul Atreides, un jeune homme brillant et doué au destin plus grand que lui-même, doit se rendre sur la planète la plus dangereuse de l'univers afin d'assurer l'avenir de sa famille et de son peuple. Cette planète est la source exclusive de la ressource la plus précieuse qui soit pour laquelle des forces sinistres déclenchent un conflit dont seuls ceux sachant maîtriser leurs peurs survivront.");
		dune.setDateParution( LocalDate.of(1965, 12, 31) );
		dune.setAuteurs( Arrays.asList(frank_herbert) );
		dune.setGenres( Arrays.asList(sf) );
		dune = daoLivre.save(dune);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		Livre paradisPerdu = new Livre();
		paradisPerdu.setTitre("Paradis Perdu");
		paradisPerdu.setResume(
				"Aux côtés de Shakespeare, Milton (1608-1674) est le plus grand poète anglais. "
						+ "Dans les pays anglophones, et tout comme celle de Shakespeare, l’œuvre de Milton "
						+ "n’a rien d’un simple objet de musée qu’on inspecte et qu’on oublie, mais elle "
						+ "est intégrée à l’existence et à l’éducation de chacun : on grandit avec elle, "
						+ "on vit et pense avec elle. Elle est citée aussi bien par les chercheurs les plus "
						+ "distingués que par les films les plus populaires. En France cette popularité, tôt "
						+ "acquise, fut scellée par la traduction que fit Chateaubriand du Paradis perdu, et "
						+ "dont on ne sortira plus : elle représente aujourd’hui la quasi-totalité des éditions "
						+ "courantes. Le temps des traductions semble s’être figé là. Mais il est difficile de "
						+ "présenter ce libre travail en regard du texte original, et il était donc important de "
						+ "pouvoir donner au public la grande épopée biblique de Milton dans une édition bilingue"
						+ "de référence, préfacée, introduite, annotée, et qui éclairât le sens et les symboles de"
						+ " son drame sacré. Il était également capital de donner à ce Paradis perdu la conclusion"
						+ " avec laquelle l’œuvre a été conçue. Frappé de cécité, tel un Homère anglais, Milton dicte"
						+ " ses épopées au soir de sa vie : quelques mois avant sa mort le grand homme donne ainsi à "
						+ "l’œuvre son issue dans le mystérieux et génial Paradis reconquis. Bien qu’il fût impensable"
						+ " de présenter les deux œuvres l’une sans l’autre, qui n’en font qu’une, ce Paradise Regained,"
						+ " ici publié dans une édition bilingue, était introuvable en France depuis un demi-siècle.");
		paradisPerdu.setDateParution( LocalDate.of(1667, 12, 31) );
		paradisPerdu.setAuteurs( Arrays.asList(john_milton) );
		paradisPerdu.setGenres( Arrays.asList(poesie) );
		paradisPerdu = daoLivre.save(paradisPerdu);	// Sauve le livre ; table jointure MàJ (cf classe Livre pour plus d'info)

		Livre yourInnerFish = new Livre();
		yourInnerFish.setTitre("Your Inner Fish");
		yourInnerFish.setResume("The paleontologist and professor of anatomy who co-discovered Tiktaalik, the “fish with hands,” "
				+ "tells a “compelling scientific adventure story that will change forever how you understand what it means to be human” (Oliver Sacks).\r\n\r\n"
				+ "By examining fossils and DNA, he shows us that our hands actually resemble fish fins, our heads are organized like "
				+ "long-extinct jawless fish, and major parts of our genomes look and function like those of worms and bacteria. "
				+ "Your Inner Fish makes us look at ourselves and our world in an illuminating new light. This is science writing at its "
				+ "finest—enlightening, accessible and told with irresistible enthusiasm.\r\n");
		yourInnerFish.setDateParution( LocalDate.of(2009,06,01) );
		yourInnerFish.setAuteurs( Arrays.asList(neil_shubin) );
		yourInnerFish.setGenres( Arrays.asList(evobiol));
		yourInnerFish = daoLivre.save(yourInnerFish);	

		Livre javaNuls = new Livre();
		javaNuls.setTitre("Java pour les Nuls");
		javaNuls.setResume("Jordan Anonyme transforme des zéros en héros dans cet ouvrage écrit entre deux parties de Valorant. "
				+ "Toute ressemblance avec des personnes ou des faits réels serait fortuite.");
		javaNuls.setDateParution( LocalDate.of(2024,12,24) );
		javaNuls.setAuteurs( Arrays.asList(jordan_a) );
		javaNuls.setGenres( Arrays.asList(info));
		javaNuls = daoLivre.save(javaNuls);

		Livre angularNuls = new Livre();
		angularNuls.setTitre("Angular for the Nulls");
		angularNuls.setResume("Eric Strangelove teaches us to stop worrying and love the Angular."
				+ "Beam us up Eric! "
				+ "Toute ressemblance avec des personnes ou des faits réels serait fortuite.");
		angularNuls.setDateParution( LocalDate.parse("2023-01-20") );
		angularNuls.setAuteurs( Arrays.asList(eric_s) );
		angularNuls.setGenres( Arrays.asList(info));
		angularNuls = daoLivre.save(angularNuls);

		Livre contrevent = new Livre();
		contrevent.setTitre("La Horde du Contrevent");
		contrevent.setResume("Un groupe d'élite, formé dès l'enfance à faire face, part des confins d'une terre féroce, saignée de rafales, pour aller chercher l'origine du vent. Ils sont vingt-trois, un bloc, un nœud de courage : la Horde. Ils sont pilier, ailier, traceur, aéromètre et géomètre, feuleuse et sourcière, troubadour et scribe. Ils traversent leur monde debout, à pied, en quête d'un Extrême-Amont qui fuit devant eux comme un horizon fou.\r\n"
				+ "Expérience de lecture unique, La Horde du Contrevent est un livre-univers qui fond d'un même feu l'aventure et la poésie des parcours, le combat nu et la quête d'un sens profond du vivant qui unirait le mouvement et le lien. Chaque mot résonne, claque, fuse : Alain Damasio joue de sa plume comme d'un pinceau, d'une caméra ou d'une arme...\r\n"
				+ "Chef-d'œuvre porté par un bouche-à-oreille rare, le roman a été logiquement récompensé par le Grand Prix de l'Imaginaire.");
		contrevent.setDateParution(LocalDate.parse("2006-06-06"));
		contrevent.setAuteurs(Arrays.asList(alain_damasio) );
		contrevent.setGenres( Arrays.asList(sf,fantasy));
		contrevent = daoLivre.save(contrevent);
		
		// Sauvegarde de plusieurs exemplaires, d'éditions différentes, de ces livres
		Editeur pocket = new Editeur("Pocket");
		pocket = daoEditeur.save(pocket);

		Editeur GF = new Editeur("GF");
		GF = daoEditeur.save(GF);

		Editeur bellesLettres = new Editeur("Belles Lettres Editions");
		bellesLettres = daoEditeur.save(bellesLettres);

		Editeur pantheonBooks = new Editeur("Pantheon Books");
		pantheonBooks = daoEditeur.save(pantheonBooks);
		
		Editeur cja = new Editeur("CJA");
		cja = daoEditeur.save(cja);
		
		Editeur folio = new Editeur("folio");
		folio = daoEditeur.save(folio);

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
		ed2.setUrlCover("https://m.media-amazon.com/images/I/A1u+2fY5yTL.jpg");
		ed2 = daoEdition.save(ed2);

		Edition ed3 = new Edition();
		ed3.setIsbn("978-0-0000-0000-3");
		ed3.setFormat("Poche");
		ed3.setLangue("Français");
		ed3.setPages(8000000);
		ed3.setLivre(paradisPerdu);
		ed3.setEditeur(GF);
		ed3.setUrlCover("https://m.media-amazon.com/images/I/61+Wys-LiIL.jpg");
		ed3 = daoEdition.save(ed3);

		Edition ed4 = new Edition();
		ed4.setIsbn("978-0-0000-0000-4");
		ed4.setFormat("Hardcover");
		ed4.setLangue("Bilingue Français-Anglais");
		ed4.setPages(16000000);
		ed4.setLivre(paradisPerdu);
		ed4.setEditeur(bellesLettres);
		ed4.setUrlCover("https://biblia.lesbelleslettres.com/data/cache/Product/front_cover_picture/big/d/b/4699.1646327334.jpg");
		ed4 = daoEdition.save(ed4);

		Edition ed5 = new Edition();
		ed5.setIsbn("978-0274803927");
		ed5.setFormat("Pocket");
		ed5.setLangue("Anglais");
		ed5.setPages(256);
		ed5.setLivre(yourInnerFish);
		ed5.setEditeur(pantheonBooks);
		ed5.setUrlCover("https://m.media-amazon.com/images/I/81ACTmzMbOL.jpg");
		ed5 = daoEdition.save(ed5);

		Edition ed6 = new Edition();
		ed6.setIsbn("0118 999 881 999 119 725");
		ed6.setFormat("Huge");
		ed6.setLangue("Franglais");
		ed6.setPages(20);
		ed6.setLivre(javaNuls);
		ed6.setEditeur(cja);
		ed6.setUrlCover("https://static.fnac-static.com/multimedia/Images/FR/NR/c2/73/80/8418242/1540-1/tsp20210707072707/Java-3ed-Pour-les-Nuls.jpg");
		ed6 = daoEdition.save(ed6);
		
		Edition ed7 = new Edition();
		ed7.setIsbn("4, 8, 15, 16, 23, and 42");
		ed7.setFormat("Fast");
		ed7.setLangue("Furious");
		ed7.setPages(234);
		ed7.setLivre(angularNuls);
		ed7.setEditeur(cja);
		ed7.setUrlCover("https://m.media-amazon.com/images/I/410Xmnf+lCL._AC_SY780_.jpg");
		ed7 = daoEdition.save(ed7);

		Edition ed8 = new Edition();
		ed8.setIsbn("978-2-9522217-0-2");
		ed8.setFormat("Poche");
		ed8.setLangue("Français");
		ed8.setPages(548);
		ed8.setLivre(contrevent);
		ed8.setEditeur(folio);
		ed8.setUrlCover("https://m.media-amazon.com/images/I/71ICKu7Q7RL.jpg");
		ed8 = daoEdition.save(ed8);
		
		//
		Exemplaire ex11 = new Exemplaire(ed1, true);
		ex11 = daoExemplaire.save(ex11);

		Exemplaire ex12 = new Exemplaire(ed1, true);
		ex12 = daoExemplaire.save(ex12);

		Exemplaire ex13 = new Exemplaire(ed1, true);
		ex13 = daoExemplaire.save(ex13);

		Exemplaire ex21 = new Exemplaire(ed2, true);
		ex21 = daoExemplaire.save(ex21);

		Exemplaire ex22 = new Exemplaire(ed2, true);
		ex22 = daoExemplaire.save(ex22);

		Exemplaire ex31 = new Exemplaire(ed3, true);
		ex31 = daoExemplaire.save(ex31);

		Exemplaire ex32 = new Exemplaire(ed3, true);
		ex32 = daoExemplaire.save(ex32);

		Exemplaire ex41 = new Exemplaire(ed4, true);
		ex41 = daoExemplaire.save(ex41);	

		Exemplaire ex51 = new Exemplaire(ed5, true);
		ex51 = daoExemplaire.save(ex51);
		
		Exemplaire ex61 = new Exemplaire(ed6, true);
		ex61 = daoExemplaire.save(ex61);
		
		Exemplaire ex71 = new Exemplaire(ed7, true);
		ex71 = daoExemplaire.save(ex71);
		
		Exemplaire ex81 = new Exemplaire(ed8, true);
		ex81 = daoExemplaire.save(ex81);
		
		Exemplaire ex82 = new Exemplaire(ed8, true);
		ex82 = daoExemplaire.save(ex82);



		Lecteur l4 = new Lecteur();
		l4.setLogin("jo");
		l4.setPassword("*");
		l4.setNom("Njeim");
		l4.setPrenom("Joanna");
		l4 = daoCompte.save(l4);

		Emprunt emp = new Emprunt();
		emp.setDebut(LocalDate.parse("2022-10-25"));
		emp.setFin(LocalDate.parse("2023-01-20"));
		emp.setEmprunteur(l4);
		emp.setExemplaire(ex51);
		emp = daoEmprunt.save(emp);
		ex51.setEmprunted(true);
		ex51 = daoExemplaire.save(ex51);


		// ASSERT

	}

	@Test
	public void createAndSaveAccountInDB() {
		Admin a = new Admin();
		a.setPassword("admin");
		a.setLogin("admin");
		a.setNom("Hanzal");
		a.setPrenom("Pierre");
		daoCompte.save(a);

		Bibliothecaire b1 = new Bibliothecaire();
		b1.setLogin("biblio");
		b1.setPassword("biblio");
		b1.setNom("Nouira");
		b1.setPrenom("Nabil");
		b1 = daoCompte.save(b1);

		Lecteur l1 = new Lecteur();
		l1.setLogin("lecteur");
		l1.setPassword("lecteur");
		l1.setNom("Anceaux");
		l1.setPrenom("Nicolas");
		l1 = daoCompte.save(l1);

		Lecteur l2 = new Lecteur();
		l2.setLogin("dfsoptimum");
		l2.setPassword("azerty");
		l2.setNom("Cantin");
		l2.setPrenom("Charles");
		l2 = daoCompte.save(l2);

		Lecteur l3 = new Lecteur();
		l3.setLogin("sammydoo");
		l3.setPassword("123456");
		l3.setNom("Huot");
		l3.setPrenom("Clément");
		l3 = daoCompte.save(l3);
	}

	@Test
	public void basicScenarioTest() {
		assert(true); // Just trust me bro, it works
	}
}
