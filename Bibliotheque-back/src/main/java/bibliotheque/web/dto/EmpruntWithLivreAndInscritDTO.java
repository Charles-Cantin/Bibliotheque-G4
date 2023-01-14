package bibliotheque.web.dto;

import java.time.LocalDate;

public class EmpruntWithLivreAndInscritDTO {

	private Integer idInscrit;
	private String nomPrenomInscrit;

	private Integer idLivre;
	private String titreLivre;

	private LocalDate debutEmprunt;
	private LocalDate finEmprunt;
	private Boolean rendu;
	
	public EmpruntWithLivreAndInscritDTO() {}

	public Integer getIdInscrit() {
		return idInscrit;
	}

	public void setIdInscrit(Integer idInscrit) {
		this.idInscrit = idInscrit;
	}

	public String getNomPrenomInscrit() {
		return nomPrenomInscrit;
	}

	public void setNomPrenomInscrit(String nomPrenomInscrit) {
		this.nomPrenomInscrit = nomPrenomInscrit;
	}

	public Integer getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}

	public String getTitreLivre() {
		return titreLivre;
	}

	public void setTitreLivre(String titreLivre) {
		this.titreLivre = titreLivre;
	}

	public LocalDate getDebutEmprunt() {
		return debutEmprunt;
	}

	public void setDebutEmprunt(LocalDate debutEmprunt) {
		this.debutEmprunt = debutEmprunt;
	}

	public LocalDate getFinEmprunt() {
		return finEmprunt;
	}

	public void setFinEmprunt(LocalDate finEmprunt) {
		this.finEmprunt = finEmprunt;
	}

	public Boolean getRendu() {
		return rendu;
	}

	public void setRendu(Boolean rendu) {
		this.rendu = rendu;
	}
}
