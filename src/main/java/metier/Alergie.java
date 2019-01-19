package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alergie {

	private long id;
	private Utilisateur utilisateurAlergie;
	public Alergie(Utilisateur ulisateur) {
		super();
		this.utilisateurAlergie = ulisateur;
	}
	public Alergie() {}
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Utilisateur getutilisateurAlergie() {
		return utilisateurAlergie;
	}
	public void setutilisateurAlergie(Utilisateur ulisateur) {
		this.utilisateurAlergie = ulisateur;
	}
	
	
	
	
}
