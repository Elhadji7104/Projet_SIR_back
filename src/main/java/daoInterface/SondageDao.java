package daoInterface;

import java.util.Date;
import java.util.List;

import metier.*;

public interface SondageDao {

	Utilisateur getUtilisateur();
	
	List<Utilisateur> getlisteUtilisateurs();

    List<DateProposee> getlisteDatesProposees();
    
    List<Sondage> getlisteSondage();

	Sondage getlisteReponse(Long idSondage);

	Reunion getreunionDuSondage();
	
	Sondage save(Sondage s,String createur);

	DateProposee addDateSondage(Long idSondage,DateProposee p);

	ReponsesSondage saveParticipation(Long idSondage, ReponsesSondage r);
}
