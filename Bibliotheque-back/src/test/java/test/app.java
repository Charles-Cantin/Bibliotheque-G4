package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bibliotheque.dao.IDAOCompte;
import bibliotheque.dao.IDAOEditeur;
import bibliotheque.model.Admin;
import bibliotheque.model.Bibliothecaire;
import bibliotheque.model.Compte;

public class app {
	
	
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	IDAOCompte daoCompte = context.getBean(IDAOCompte.class);
	IDAOEditeur daoE = context.getBean(IDAOEditeur.class);
	

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

	
	context.close();
}


}
