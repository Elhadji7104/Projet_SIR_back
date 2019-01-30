package service;

import java.util.List;

import daoImpl.UtilisateurDaoImp;
import metier.Utilisateur;

public class UtilisateurService {
	
 private UtilisateurDaoImp utilisateur;
 
 public List<Utilisateur> findAll() {
	         List<Utilisateur> listes = utilisateur.getListUtilisateur();
	         return listes;
	     }
}
