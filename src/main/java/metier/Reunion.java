package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Reunion {

	private long idReunion;
	private List<Sondage> listeSondages=new ArrayList<Sondage>();
	private List<Participant> listeParticipants=new ArrayList<Participant>();
	public Reunion(List<Sondage> listeSondages, List<Participant> listeParticipants) {
		super();
		this.listeSondages = listeSondages;
		this.listeParticipants = listeParticipants;
	}
	
	public Reunion() {}
	@Id
	@GeneratedValue
	public long getIdReunion() {
		return idReunion;
	}

	public void setIdReunion(long idReunion) {
		this.idReunion = idReunion;
	}
	
	@OneToMany(mappedBy="reunionDuSondage")
	public List<Sondage> getListeSondages() {
		return listeSondages;
	}

	public void setListeSondages(List<Sondage> listeSondages) {
		this.listeSondages = listeSondages;
	}

	public List<Participant> getListeParticipants() {
		return listeParticipants;
	}

	public void setListeParticipants(List<Participant> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}
	
	
	

	
}
