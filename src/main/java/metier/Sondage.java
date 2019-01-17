package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Sondage {
	
	
	private long idSondage;
	
	private String lienWeb;
	
	
	private Utilisateur createur;
	
	private List<Utilisateur> listeUtilisateurs;

	private List<DateProposee> listeDatesProposees;
	
	public Sondage() {}
	
	public Sondage(String lienWeb,Utilisateur createur) {
		super();
		this.lienWeb = lienWeb;
		this.createur=createur;
		listeUtilisateurs=new ArrayList<Utilisateur>();
		listeDatesProposees=new ArrayList<DateProposee>();
	}

	@Id
	@GeneratedValue
	public long getIdSondage() {
		return idSondage;
	}

	public void setIdSondage(long idSondage) {
		this.idSondage = idSondage;
	}

	public String getLienWeb() {
		return lienWeb;
	}

	public void setLienWeb(String lienWeb) {
		this.lienWeb = lienWeb;
	}
	@ManyToOne()
	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	@ManyToMany(mappedBy="listeSondages")
	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
	@ManyToMany()
	public List<DateProposee> getListeDatesProposees() {
		return listeDatesProposees;
	}

	public void setListeDatesProposees(List<DateProposee> listeDatesProposees) {
		this.listeDatesProposees = listeDatesProposees;
	}

	@Override
	public String toString() {
		return "Sondage [idSondage=" + idSondage + ", lienWeb=" + lienWeb;//, listeUtilisateurs=" + listeUtilisateurs
			//	+ "]";
	}
	
	
	

}
