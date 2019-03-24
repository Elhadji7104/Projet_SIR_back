package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
@Entity
@NamedQueries({ 
	@NamedQuery(name = "findAllsondage", query = "SELECT s FROM Sondage s"),
	@NamedQuery(name = "findsondageById", query = "SELECT s FROM Sondage s WHERE s.id = :idSondage"),
})
public class Sondage {
	
	
	private long idSondage;
	
	private String lienWeb;
	
	private Utilisateur createur;
	
	private List<Utilisateur> listeUtilisateurs;

	private List<DateProposee> listeDatesProposees;



	private List<ReponsesSondage> listDeReponses;

	private Reunion reunionDuSondage;
	
	@ManyToOne
	@JsonManagedReference(value="reunion_sondage")
	@JsonIgnore
	public Reunion getReunionDuSondage() {
		return reunionDuSondage;
	}

	@OneToMany
	@JsonIgnore
	public List<ReponsesSondage> getListDeReponses() {
		return listDeReponses;
	}

	public void setListDeReponses(List<ReponsesSondage> listDeReponses) {
		this.listDeReponses = listDeReponses;
	}
	public void setReunionDuSondage(Reunion reunionDuSondage) {
		this.reunionDuSondage = reunionDuSondage;
	}

	public Sondage() {
		listeUtilisateurs=new ArrayList<Utilisateur>();
		listeDatesProposees=new ArrayList<DateProposee>();
		reunionDuSondage = new Reunion();
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
	@JsonBackReference(value = "sondage_cree")
	public Utilisateur getCreateur() {
		return createur;
	}

	public void setCreateur(Utilisateur createur) {
		this.createur = createur;
	}

	@ManyToMany(mappedBy="listeSondages")
	@JsonBackReference(value ="reunion_sondage")
	@JsonIgnore
	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}

	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
	@ManyToMany()
	@JsonIgnore
	public List<DateProposee> getListeDatesProposees() {
		return listeDatesProposees;
	}

	public void setListeDatesProposees(List<DateProposee> listeDatesProposees) {
		this.listeDatesProposees = listeDatesProposees;
	}
	public  void addDateSondate(DateProposee p){
		this.listeDatesProposees.add(p);
	}
	@Override
	public String toString() {
		return "Sondage [idSondage=" + idSondage + ", lienWeb=" + lienWeb;//, listeUtilisateurs=" + listeUtilisateurs
			//	+ "]";
	}

	public void addReponse(ReponsesSondage r) {
		this.listDeReponses.add(r);
	}
}
