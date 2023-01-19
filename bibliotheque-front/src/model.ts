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
  dateFinEffective: string;
  rendu: boolean;
  exemplaire: Exemplaire;
  emprunteur: Inscrit;

  constructor(id?: number, dateDebut?: string, duree?: number, dateFin?: string, dateFinEffective?: string, rendu?: boolean, exemplaire?: Exemplaire, emprunteur?: Inscrit) {
    this.id = id;
    this.dateDebut = dateDebut;
    this.duree = duree;
    this.dateFin = dateFin;
    this.dateFinEffective = dateFinEffective;
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

export class EmpruntDetail {
    
    id:               number;
    idInscrit:        number;
    nomPrenomInscrit: string;
    idLivre:          number;
    titreLivre:       string;
    debutEmprunt:     Date;
    finEmprunt:       Date;
    rendu:            boolean;

    constructor( id?: number, idInscrit?:number, nomPrenomInscrit?: string , idLivre?: number, titreLivre?: string, debutEmprunt? :Date, finEmprunt?: Date,rendu?:boolean) {
        
        this.id= id;
        this.idInscrit = idInscrit;
        this.nomPrenomInscrit = nomPrenomInscrit;
        this.idLivre = idLivre;
        this.titreLivre = titreLivre;
        this.debutEmprunt = debutEmprunt;
        this.finEmprunt = finEmprunt;
        this.rendu = rendu;
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
  urlCover: string;
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

  constructor(idEdition?: number, urlCover?:string, titre?: string, resume?: string, ISBN?: string, pages?: number, anneeParution?: number, format?: string, langue?: string, nomsAuteurs?: string, nomEditeur?: string, nomsGenres?: string) {
    this.idEdition = idEdition;
    this.urlCover = urlCover;
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

  constructor(idExemplaire?: number, disponible?: Boolean, nomEditeur?: string, dateProchaineDispo?: string) {
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
  publication: string;
  auteurs: Object[];
  editions: Object[];
  nomGenres: string;
  disponibilite: number;

  constructor(id?: number, titre?: string, resume?: string, publication?: string, auteurs?: Object[], editions?: Object[], nomGenres?: string, disponibilite?: number) {
    this.id = id;
    this.titre = titre;
    this.resume = resume;
    this.publication = publication;
    this.auteurs = auteurs;
    this.editions = editions;
    this.nomGenres = nomGenres;
    this.disponibilite = disponibilite;
  }

}

export class Auteur {
  id:        number;
  nom:       string;
  prenom:    string;
  naissance: Date;
  livres: Object[];

  constructor(id?: number, nom?: string, prenom?: string, naissance?: Date, livres?: Object[] ) {
      this.id = id;
      this.nom = nom;
      this.prenom = prenom;
      this.naissance = naissance;
      this.livres = livres;
  }
}

export class ResultatDTO {
  idLivre: number;
  titre: string;
  auteurs: string;
  genres: string;
  nombreLivresDispo: number;
  publication: string;
  editions: Array<ResultatEddy>; //liste des ID d'editions


  constructor(idLivre?: number, titre?: string, auteurs?: string, genres?: string, nombreLivresDispo?: number, publication?: string, editions?: Array<ResultatEddy>) {
    this.idLivre = idLivre;
    this.titre = titre;
    this.publication = publication;
    this.auteurs = auteurs;
    this.genres = genres;
    this.editions = editions;
    this.nombreLivresDispo = nombreLivresDispo;
  }

}

export class ResultatEddy{
  idEdition: number;
  urlCover: string;
  ISBN: string;
  pages: number;
  format: string;
  langue: string;
  nomEditeur: string;
  nombreEditionDispo: number;

  constructor(editionDispo?: number, urlCover?:string, idEdition?: number, ISBN?: string, pages?: number, format?: string, langue?: string, nomEditeur?: string) {
    this.nombreEditionDispo = editionDispo;
    this.idEdition = idEdition;
    this.urlCover = urlCover;
    this.ISBN = ISBN;
    this.pages = pages;
    this.format = format;
    this.langue = langue;
    this.nomEditeur = nomEditeur;
  }
}




