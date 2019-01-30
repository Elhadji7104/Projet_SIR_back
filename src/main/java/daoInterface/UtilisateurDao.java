package daoInterface;

import java.util.List;

import metier.Utilisateur;

public interface UtilisateurDao {
	List<Utilisateur> getListUtilisateur();
	void save(Utilisateur u);
}
