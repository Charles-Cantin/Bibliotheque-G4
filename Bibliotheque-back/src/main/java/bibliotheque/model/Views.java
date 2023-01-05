package bibliotheque.model;

public class Views {
	public static class ViewBase {}	
	
	public static class ViewEditeur extends ViewBase {}
	
	public static class ViewEditeurDetail extends ViewEditeur {}
	
	public static class ViewEmprunt extends ViewBase {}
	
	public static class ViewEmpruntDetail extends ViewEmprunt {}
	
}
