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

import com.mysql.fabric.xmlrpc.base.Data;


@Entity
public class DateProposee {
	
	private long  idDate;
	@Temporal(TemporalType.DATE)
	private Date  datePauseDejeuner;
	private Date  datePause;
	private List<Sondage> listeSondages = new ArrayList<Sondage>();
	public DateProposee() {}
	public DateProposee(Date  datesond2,Date  datesond3) {
		super();
		this.datePauseDejeuner = datesond2;
		this.datePause = datesond3;	
	}
	@Id
	@GeneratedValue
	public long  getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	
	
	
	public Date getDatePauseDejeuner() {
		return datePauseDejeuner;
	}
	public void setDatePauseDejeuner(Date datePauseDejeuner) {
		this.datePauseDejeuner = datePauseDejeuner;
	}
	public Date getDatePause() {
		return datePause;
	}
	public void setDatePause(Date datePause) {
		this.datePause = datePause;
	}
	@ManyToMany()
	public List<Sondage>  getListeSondages() {
		return listeSondages;
	}
	public void setListeSondages(List listeSondages) {
		this.listeSondages = listeSondages;
	}
	
	
	
	

}
