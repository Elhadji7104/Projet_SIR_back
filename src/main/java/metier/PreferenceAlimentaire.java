package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PreferenceAlimentaire {

	private long id;
	private Utilisateur itulisateurPreferenceAli;
	public PreferenceAlimentaire(Utilisateur itulisateurPreferenceAli) {
		super();
		this.itulisateurPreferenceAli = itulisateurPreferenceAli;
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
	public Utilisateur getItulisateurPreferenceAli() {
		return itulisateurPreferenceAli;
	}
	public void setItulisateurPreferenceAli(Utilisateur itulisateurPreferenceAli) {
		this.itulisateurPreferenceAli = itulisateurPreferenceAli;
	}
	
	
}
