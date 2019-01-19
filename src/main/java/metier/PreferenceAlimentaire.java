package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PreferenceAlimentaire {

	private long id;
	private Utilisateur utilisateurPreferenceAli;
	public PreferenceAlimentaire(Utilisateur utilisateurPreferenceAli) {
		super();
		this.utilisateurPreferenceAli = utilisateurPreferenceAli;
	}
	public PreferenceAlimentaire() {		
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@ManyToOne
	public Utilisateur getUtilisateurPreferenceAli() {
		return utilisateurPreferenceAli;
	}
	public void setUtilisateurPreferenceAli(Utilisateur itulisateurPreferenceAli) {
		this.utilisateurPreferenceAli = itulisateurPreferenceAli;
	}
	
	
}
