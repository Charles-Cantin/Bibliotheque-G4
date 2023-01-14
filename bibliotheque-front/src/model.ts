export class Compte {

  id: number;
  login: string;
  password: string;
  type: string;
  nom: string;
  prenom: string;
  naissance: string;
  blocked: boolean;
  finAbonnement:string;

  constructor(
    id?: number,
    login?: string,
    password?: string,
    type?: string,
    nom?: string,
    prenom?: string,
    naissance?: string,
    blocked?: boolean,
    finAbonnement?:string
    ) {}
  
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