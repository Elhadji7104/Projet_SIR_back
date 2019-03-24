package metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonBackReference;


@Entity
public class DateProposee {
	
	private long  idDate;
	@Temporal(TemporalType.DATE)
	private Date heureDebut;
	private Date  heureFin;
	private Date  dateSondage;
	private List<Sondage> listeSondages = new ArrayList<Sondage>();
	public  DateProposee() {}
	
	public DateProposee(Date  datesond2,Date  datesond3,Date dateSondage) {
		super();
		this.heureDebut = datesond2;
		this.heureFin = datesond3;
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
	
	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date dateFin) {
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

	@ManyToMany(mappedBy="listeDatesProposees")
	@JsonBackReference(value="date_sondage")
	public List<Sondage>  getListeSondages() {
		return listeSondages;
	}
	public void setListeSondages(List listeSondages) {
		this.listeSondages = listeSondages;
	}
}
