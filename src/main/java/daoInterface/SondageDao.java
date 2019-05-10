package daoInterface;

import java.util.List;

import metier.*;

public interface SondageDao {

	Utilisateur getUtilisateur();
	
	List<Utilisateur> getlisteUtilisateurs();

    List<DateProposee> getlisteDatesProposees(Long idSondage);
    
    List<Sondage> getlisteSondage();

	List<ReponsesSondage> getlisteReponse(Long idSondage);

	Reunion getreunionDuSondage();
	
	Sondage save(Sondage s,String createur);

	DateProposee addDateSondage(Long idSondage,DateProposee p);

	ReponsesSondage saveParticipation(Long idSondage,Long idDate, ReponsesSondage r);

    List<Sondage> getlisteSondageByUser(String mail);
}
