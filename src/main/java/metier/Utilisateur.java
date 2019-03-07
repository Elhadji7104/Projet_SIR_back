package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

<<<<<<< HEAD

=======
>>>>>>> 92ec98db26639e77e4b6b171c0220ea24f247f03
@Entity
public class Utilisateur {
	private String mail;
	
	private String nom;
	
	private String prenom;
	
	private String mdp;
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	private List<Sondage> listeSondagesCrees=new ArrayList<Sondage>();
	
	private List<Sondage> listeSondages=new ArrayList<Sondage>();
	
	private List<Alergie> listeAlergie=new ArrayList<Alergie>();

	private List<PreferenceAlimentaire> listePreferenceAlimentaire=new ArrayList<PreferenceAlimentaire>();

	/*
	private List<Alergie> listeAlergies=new ArrayList<Alergie>();
	
	private List<PreferenceAlimentaire> listePrefsAlimentaire=new ArrayList<PreferenceAlimentaire>();
	*/
	
	@OneToMany()
	@JsonIgnore
	public List<PreferenceAlimentaire> getListePreferenceAlimentaire() {
		return listePreferenceAlimentaire;
	}

	public void setListePreferenceAlimentaire(List<PreferenceAlimentaire> listePreferenceAlimentaire) {
		this.listePreferenceAlimentaire = listePreferenceAlimentaire;
	}

	@OneToMany()
	@JsonIgnore
	public List<Alergie> getListeAlergie() {
		return listeAlergie;
	}

	public void setListeAlergie(List<Alergie> listeAlergie) {
		this.listeAlergie = listeAlergie;
	}

	public Utilisateur() {
	}
	
	public Utilisateur(String mail, String nom, String prenom,String mdp) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.mdp = mdp;
	}

	@Id
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToMany(mappedBy="createur" ,cascade ={CascadeType.PERSIST,CascadeType.MERGE})
	@JsonManagedReference(value = "sondage_cree")
	@JsonIgnore
	public List<Sondage> getListeSondagesCrees() {
		return listeSondagesCrees;
	}

	public void setListeSondagesCrees(List<Sondage> listeSondagesCrees) {
		this.listeSondagesCrees = listeSondagesCrees;
	}

	@ManyToMany()
	@JsonIgnore
	public List<Sondage> getListeSondages() {
		return listeSondages;
	}

	public void setListeSondages(List<Sondage> listeSondages) {
		this.listeSondages = listeSondages;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [mail=" + mail + ", nom=" + nom + ", prenom=" + prenom + "]";
	}	
}
