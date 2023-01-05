package bibliotheque.model;

public class Views {

	public static class ViewBase {}
	
	// COMPTES //

	public static class ViewCompte extends ViewBase {}
	
	// INSCRITS //

	public static class ViewInscrit extends ViewBase {}
	public static class ViewInscritDetail extends ViewBase {}

	// EDITEURS //
	
	public static class ViewEditeur extends ViewBase {}
	public static class ViewEditeurDetail extends ViewEditeur {}
	
	// EMPRUNTS //
	
	public static class ViewEmprunt extends ViewBase {}
	public static class ViewEmpruntDetail extends ViewEmprunt {}
	
	
	// GENRES //
	
	public static class ViewGenre extends ViewBase {}
	public static class ViewGenreWithLivres extends ViewGenre {}
	public static class ViewGenreDetail extends ViewGenreWithLivres {}
	
	// LIVRES //
	
	public static class ViewLivreWithAuteur extends ViewBase {}
	public static class ViewLivreWithAuteurAndGenre extends ViewLivreWithAuteur {}
	public static class ViewLivre extends ViewLivreWithAuteurAndGenre {}
	public static class ViewLivreWithAll extends ViewLivreWithAuteurAndGenre {}
	public static class ViewLivreDetail extends ViewLivreWithAll {}
	
	// EXEMPLAIRES //
	
	public static class ViewExemplaire extends ViewBase {}
	public static class ViewExemplaireDetail extends ViewExemplaire {}
	
	// EDITIONS //
	
	public static class ViewEdition extends ViewBase {}
	public static class ViewEditionDetail extends ViewEdition {}
}
