package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Alergie {

	private long id;
	private Utilisateur ulisateurAlergie;
	public Alergie(Utilisateur ulisateur) {
		super();
		this.ulisateurAlergie = ulisateur;
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
	public Utilisateur getulisateurAlergie() {
		return ulisateurAlergie;
	}
	public void setulisateurAlergie(Utilisateur ulisateur) {
		this.ulisateurAlergie = ulisateur;
	}
	
	
	
	
}
