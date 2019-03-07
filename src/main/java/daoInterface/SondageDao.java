package daoInterface;

import java.util.List;

import metier.DateProposee;
import metier.Reunion;
import metier.Sondage;
import metier.Utilisateur;

public interface SondageDao {

	Utilisateur getUtilisateur();
	
	List<Utilisateur> getlisteUtilisateurs();

    List<DateProposee> getlisteDatesProposees();
    
    List<Sondage> getlisteSondage();

	Reunion getreunionDuSondage();
	
	Sondage save(Sondage s);
	
	
}
