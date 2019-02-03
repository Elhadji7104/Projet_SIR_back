package daoInterface;

import java.util.List;

import metier.DateProposee;
import metier.Reunion;
import metier.Utilisateur;

public interface SondageDao {

	Utilisateur getUtilisateur();
	
	List<Utilisateur> getlisteUtilisateurs();

    List<DateProposee> getlisteDatesProposees();
	
	Reunion getreunionDuSondage();
}
