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