package test;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import bibliotheque.dao.IDAOCompte;
import bibliotheque.dao.IDAOEditeur;
import bibliotheque.model.Admin;
import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Compte;
import bibliotheque.model.Inscrit;

/* TEST DES FONCTIONNALITÉS EN LIGNE DE COMMANDES
 * Ne fait PAS partie de l'application finale
 * N'est PAS un test JUnit
 * */
@ContextConfiguration(locations = "classpath:application-context.xml")
public class App {

	@Autowired
	static IDAOCompte daoCompte;
	@Autowired
	static IDAOEditeur daoEditeur;

	static Compte compteConnecte;

	public static String saisieString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		String saisie = sc.nextLine();
		return saisie;
	}

	public static double saisieDouble(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		double saisie = sc.nextDouble();
		return saisie;
	}

	public static int saisieInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		int saisie = sc.nextInt();
		return saisie;
	}
	public static boolean saisieBoolean(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.nextBoolean();
	}
	public static LocalDate saisieDate(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);

		System.out.println("jour : ");
		String jour = sc.nextLine();
		System.out.println("mois : ");
		String mois = sc.nextLine();
		System.out.println("année : ");
		String annee = sc.nextLine();
		return LocalDate.parse(annee + "-" + mois + "-" + jour);
	}


	/////////////////////////// MENUS ///////////////////////////
	public void main(String[] args) {
		menuPrincipal();
	}

	public void menuPrincipal() {
		System.out.println("Bienvenue dans la Bibliothèque.");
		System.out.println("Choisissez une option :");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Consulter le catalogue");
		int choix = saisieInt("> ");

		switch (choix) {
		case 1 -> seConnecter();
		case 2 -> System.exit(0);
		}
		menuPrincipal();
	}

	public void seDeconnecter() {
		compteConnecte = null;
		menuPrincipal();
	}

	public void seConnecter() {
		String login = saisieString("Saisir login : ");
		String password = saisieString("Saisir password : ");
		compteConnecte = daoCompte.findDistinctByLoginAndPassword(login, password);

		if (compteConnecte instanceof Admin) {
			menuAdmin();
		}

		else if (compteConnecte instanceof Bibliothecaire) {
			menuBibliothecaire();
		}

		else if (compteConnecte instanceof Inscrit) {
			menuInscrit();
		}

		else {
			System.out.println("Identifiants invalides");
		}
	}

	private void menuAdmin() {
		System.out.println("MENU ADMINISTRATEUR");
		System.out.println("Choisissez une option :");
		System.out.println("1 - DROP DATABAZE (NO ROLLBACK) !!1!");
		System.out.println("2 - Ajouter un compte en base de données");
		System.out.println("3 - Se déconnecter");
		int choix = saisieInt("> ");

		switch (choix) {
		case 1 -> System.out.println("DATABAZE DROPPED (lmao you mad tpt); Terminating app.") ;
		case 2 -> ajouterCompte();
		case 3 -> seDeconnecter();
		}
		menuAdmin();

	}

	private void menuBibliothecaire() {
//		System.out.println("MENU Bibliothécaire");
//		System.out.println("Choisissez une option :");
//		System.out.println("1 - ");
//		System.out.println("2 - Ajouter un compte en base de données");
//		System.out.println("3 - Se déconnecter");
//		int choix = saisieInt("> ");
//
//		switch (choix) {
//		case 1 -> System.out.println("DATABAZE DROPPED (lmao you mad tpt); Terminating app.") ;
//		case 2 -> ajouterCompte();
//		case 3 -> seDeconnecter();
//		}
//		menuBibliothecaire();
		
	}

	private void menuInscrit() {
		// TODO Auto-generated method stub

	}

	/////////////////////////// FONCTIONS METIER ///////////////////////////

	public void ajouterCompte() {
		System.out.println("Quel type de compte voulez-vous ajouter ?");
		System.out.println("1 - Admin");
		System.out.println("2 - Bibliothécaire");
		System.out.println("3 - Inscrit");
		int choix = saisieInt("> ");

		switch (choix) {
		case 1 -> ajouterCompteAdmin();
		case 2 -> ajouterCompteBibliothecaire();
		case 3 -> ajouterCompteInscrit();
		}
	}

	private void ajouterCompteAdmin() {
		System.out.println("Entrez les informations du compte :");
		String login = saisieString("login : ");
		String password = saisieString("mot de passe : ");

		Admin nouveauAdmin = new Admin();
		nouveauAdmin.setLogin(login);
		nouveauAdmin.setPassword(password);

		daoCompte.save(nouveauAdmin);
		return;
	}

	private void ajouterCompteBibliothecaire() {
		System.out.println("Entrez les informations du compte :");
		String login = saisieString("login : ");
		String password = saisieString("mot de passe : ");
		String nom = saisieString("nom : ");
		String prenom = saisieString("prenom : ");

		Bibliothecaire nouveauBibliothecaire = new Bibliothecaire();
		nouveauBibliothecaire.setLogin(login);
		nouveauBibliothecaire.setPassword(password);
		nouveauBibliothecaire.setNom(nom);
		nouveauBibliothecaire.setPrenom(prenom);

		daoCompte.save(nouveauBibliothecaire);
		return;
	}

	private void ajouterCompteInscrit() {
		System.out.println("Entrez les informations du compte :");
		String login = saisieString("login : ");
		String password = saisieString("mot de passe : ");
		String nom = saisieString("nom : ");
		String prenom = saisieString("prenom : ");
		LocalDate naissance = saisieDate("Date de naissance :");

		Inscrit nouveauInscrit = new Inscrit();
		nouveauInscrit.setLogin(login);
		nouveauInscrit.setPassword(password);
		nouveauInscrit.setNom(nom);
		nouveauInscrit.setPrenom(prenom);
		nouveauInscrit.setNaissance(naissance);
		nouveauInscrit.setBlocked(false);

		daoCompte.save(nouveauInscrit);
		return;
	}

}
