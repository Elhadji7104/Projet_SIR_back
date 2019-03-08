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

import com.mysql.fabric.xmlrpc.base.Data;


@Entity
public class DateProposee {
	
	private long  idDate;
	@Temporal(TemporalType.DATE)
	private Date  dateDebut;
	private Date  dateFin;	
	private Date  dateSondage;
	private boolean pauseDej;
	private List<Sondage> listeSondages = new ArrayList<Sondage>();
	public  DateProposee() {}
	
	public DateProposee(Date  datesond2,Date  datesond3) {
		super();
		this.dateDebut = datesond2;
		this.dateFin = datesond3;	
		if(dateDebut.getHours()<12 && dateFin.getHours()>14) {
			pauseDej=true;
		}
	}
	

	@Id
	@GeneratedValue
	public long  getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Date getDateSondage() {
		return dateSondage;
	}
	public void addDate(Date date,Date dateDebut,Date dateFin) {
		
		
	}
	public void setDateSondage(Date dateSondage) {
		this.dateSondage = dateSondage;
	}
	public boolean isPauseDej() {
		return pauseDej;
	}

	public void setPauseDej(boolean pauseDej) {
		this.pauseDej = pauseDej;
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
