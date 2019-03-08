package metier;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;


@Entity
public class Utilisateur {
	private String mail;
	
	private String nom;
	
	private String prenom;
	
	private String mdp;

	private List<Sondage> listeSondagesCrees;
	
	private List<Sondage> listeSondages;
	
	private List<Alergie> listeAlergie;

	private List<PreferenceAlimentaire> listePreferenceAlimentaire=new ArrayList<PreferenceAlimentaire>();

	/*
	private List<Alergie> listeAlergies=new ArrayList<Alergie>();
	
	private List<PreferenceAlimentaire> listePrefsAlimentaire=new ArrayList<PreferenceAlimentaire>();
	*/
	
	@OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference(value = "utilisateurPreference")	
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
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	

	public Utilisateur() {
		listeSondagesCrees=new ArrayList<Sondage>();
		
		listeSondages=new ArrayList<Sondage>();
		
		listeAlergie=new ArrayList<Alergie>();
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

	@OneToMany(mappedBy = "createur", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference(value = "sondage_cree")	
	public List<Sondage> getListeSondagesCrees() {
		return listeSondagesCrees;
	}

	public void setListeSondagesCrees(List<Sondage> listeSondagesCrees) {
		this.listeSondagesCrees = listeSondagesCrees;
	}

	@ManyToMany()
	@JsonManagedReference(value = "liste_sondage")
	@JsonIgnore
	public List<Sondage> getListeSondages() {
		return listeSondages;
	}

	public void setListeSondages(List<Sondage> listeSondages) {
		this.listeSondages = listeSondages;
	}
	public void addPreference(PreferenceAlimentaire p) {
		this.listePreferenceAlimentaire.add(p);
	}
	public void addSondage(Sondage sondage) {
		Objects.requireNonNull(sondage, " object not  null");
		this.listeSondages.add(sondage);
	}
	@Override
	public String toString() {
		return "Utilisateur [mail=" + mail + ", nom=" + nom + ", prenom=" + prenom + "]";
	}	
}
