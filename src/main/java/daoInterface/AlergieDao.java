package daoInterface;

import java.sql.SQLException;
import java.util.List;

import metier.Alergie;
import metier.Utilisateur;

public interface AlergieDao {
	List<Alergie> getListAlergie() throws SQLException;
	Alergie save(String libelle);
}
