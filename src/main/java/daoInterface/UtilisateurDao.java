package daoInterface;

import java.sql.SQLException;
import java.util.List;

import metier.Utilisateur;

public interface UtilisateurDao {
	List<Utilisateur> getListUtilisateur() throws SQLException;
	void save(Utilisateur u);
}
