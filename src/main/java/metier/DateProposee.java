package metier;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;


@SuppressWarnings("ALL")
@Entity
public class DateProposee {
	
	private long  idDate;
	@Temporal(TemporalType.DATE)
	private String heureDebut;
	private String heureFin;
	private Date  dateSondage;

	private List<ReponsesSondage> listDeReponses;
	public  DateProposee() {}
	
	public DateProposee(Date dateSondage, String heureDebut,String heureFin) {
		super();
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.dateSondage = dateSondage;
	}
	

	@Id
	@GeneratedValue
	public long  getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	private Sondage sondage;
	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String dateFin) {
		this.heureFin = dateFin;
	}
	public Date getDateSondage() {
		return dateSondage;
	}
	public void addDate(Date date,Date dateDebut,Date dateFin) {
	}
	public void setDateSondage(Date dateSondage) {
		this.dateSondage = dateSondage;
	}

	@ManyToOne
	@JsonBackReference(value="sondage_dateproposee")
	public Sondage getSondage() {
		return sondage;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy ="dateProposee" ,cascade = { CascadeType.PERSIST, CascadeType.ALL })
	@JsonManagedReference(value = "date_proposee")
	public List<ReponsesSondage> getListDeReponses() {
		return listDeReponses;
	}


	public void setListDeReponses(List<ReponsesSondage> listDeReponses) {
		this.listDeReponses = listDeReponses;
	}
	public void setSondage(Sondage sondage) {
		this.sondage = sondage;
	}
}
