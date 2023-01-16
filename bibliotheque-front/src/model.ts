export class Compte {

  id: number;
  login: string;
  password: string;
  type: string;
  nom: string;
  prenom: string;
  naissance: string;
  blocked: boolean;
  finAbonnement: string;

  constructor(id?: number, login?: string, password?: string, type?: string, nom?: string, prenom?: string, naissance?: string, blocked?: boolean, finAbonnement?: string) {
    this.id = id;
    this.login = login;
    this.password = password;
    this.type = type;
    this.nom = nom;
    this.prenom = prenom;
    this.naissance = naissance;
    this.blocked = blocked;
    this.finAbonnement = finAbonnement;
  }
}

export class Emprunt {

  id: number;
  dateDebut: string;
  duree: number;
  dateFin: string;
  rendu: boolean;
  exemplaire: Exemplaire;
  emprunteur: Inscrit;

  constructor(id?: number, dateDebut?: string, duree?: number, dateFin?: string, rendu?: boolean, exemplaire?: Exemplaire, emprunteur?: Inscrit) {
    this.id = id;
    this.dateDebut = dateDebut;
    this.duree = duree;
    this.dateFin = dateFin;
    this.rendu = rendu;
    this.exemplaire = exemplaire;
    this.emprunteur = emprunteur;
  }
}

export class EmpruntDTO {

  idExemplaire: number;
  debut: string;
  duree: number;
  fin: string;
  rendu: boolean;
  titreLivre: string;

  constructor(idExemplaire?: number, debut?: string, duree?: number, fin?: string, rendu?: boolean, titreLivre?: string) {
    this.idExemplaire = idExemplaire;
    this.debut = debut;
    this.duree = duree;
    this.fin = fin;
    this.rendu = rendu;
    this.titreLivre = titreLivre;
  }
}

export class Exemplaire {

  id: number;
  disponible: boolean;
  //edition: Edition;

  constructor(id?: number, disponible?: boolean) {
    this.id = id;
    this.disponible = disponible;
  }
}

export class Inscrit extends Compte {
}

export class EditionDTO {

  // from Edition
  idEdition: number;
  ISBN: string;
  pages: number;
  format: string;
  langue: string;

  // from Livre
  titre: string;
  resume: string;
  anneeParution: number;

  // from others (just get 1 property)
  nomsAuteurs: string;
  nomEditeur: string;
  nomsGenres: string;

  constructor(idEdition?: number, titre?: string, resume?: string, ISBN?: string, pages?: number, anneeParution?: number, format?: string, langue?: string, nomsAuteurs?: string, nomEditeur?: string, nomsGenres?: string) {
    this.idEdition = idEdition;
    this.titre = titre;
    this.resume = resume;
    this.ISBN = ISBN;
    this.pages = pages;
    this.anneeParution = anneeParution;
    this.format = format;
    this.langue = langue;
    this.nomsAuteurs = nomsAuteurs;
    this.nomEditeur = nomEditeur;
    this.nomsGenres = nomsGenres;
  }
}

export class ExemplaireByEditionDTO {

  idExemplaire: number;
  disponible: Boolean;
  nomEditeur: string;
  dateProchaineDispo: string;

  constructor(idExemplaire: number, disponible: Boolean, nomEditeur: string, dateProchaineDispo: string) {
    this.idExemplaire = idExemplaire;
    this.disponible = disponible;
    this.nomEditeur = nomEditeur;
    this.dateProchaineDispo = dateProchaineDispo;
  }
}

export class Livre{
  id: number;
  titre: string;
  resume: string;
  parution: string;
  nomAuteurs: string; // transformer en array<auteurDTO> ?? at least nom auteur + id (possibly lien vers page auteur plus tard)
  editions: Array<number>; //liste des ID d'editions
  nomGenres: string;
  disponibilite: number;


  constructor(id?: number, titre?: string, resume?: string, parution?: string, nomAuteurs?: string, editions?: Array<number>, nomGenres?: string, disponibilite?: number) {
    this.id = id;
    this.titre = titre;
    this.resume = resume;
    this.parution = parution;
    this.nomAuteurs = nomAuteurs;
    this.editions = editions;
    this.nomGenres = nomGenres;
    this.disponibilite = disponibilite;
  }

}