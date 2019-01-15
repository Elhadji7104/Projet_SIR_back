package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Utilisateur {
	private String mail;
	
	private String nom;
	
	private String prenom;
	
	/*
	private List<Sondage> listeSondagesCrees=new ArrayList<Sondage>();
	
	private List<Sondage> listeSondages=new ArrayList<Sondage>();
	
	private List<Alergie> listeAlergies=new ArrayList<Alergie>();
	
	private List<PreferenceAlimentaire> listePrefsAlimentaire=new ArrayList<PreferenceAlimentaire>();
	*/
	
	public Utilisateur() {
	}
	
	public Utilisateur(String mail, String nom, String prenom) {
		super();
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
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

	@Override
	public String toString() {
		return "Utilisateur [mail=" + mail + ", nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
