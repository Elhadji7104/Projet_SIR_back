package daoInterface;

import java.sql.SQLException;
import java.util.List;

import metier.Utilisateur;

public interface UtilisateurDao {
	List<Utilisateur> getListUtilisateur() throws SQLException;
	Utilisateur save(String mail, String nom, String prenom, String mdp);
}
