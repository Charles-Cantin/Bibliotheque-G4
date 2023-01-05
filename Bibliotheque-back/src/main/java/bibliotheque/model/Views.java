package bibliotheque.model;

public class Views {

	public class ViewBase {}
	
	// COMPTES //

	public class ViewCompte extends ViewBase {}
	
	// INSCRITS //

	public class ViewInscrit extends ViewBase {}
	public class ViewInscritDetail extends ViewBase {}


	public static class ViewEditeur extends ViewBase {}
	public static class ViewEditeurDetail extends ViewEditeur {}
	public static class ViewEmprunt extends ViewBase {}
	public static class ViewEmpruntDetail extends ViewEmprunt {}
}