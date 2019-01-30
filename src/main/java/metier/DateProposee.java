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
	private Date  datePaugeDegener;
	private Date  datePauge;
	private List<Sondage> listeSondages = new ArrayList<Sondage>();
	public DateProposee() {}
	public DateProposee(Date  datesond2,Date  datesond3) {
		super();
		this.datePaugeDegener = datesond2;
		this.datePauge = datesond3;	
	}
	@Id
	@GeneratedValue
	public long  getIdDate() {
		return idDate;
	}
	public void setIdDate(long idDate) {
		this.idDate = idDate;
	}
	
	
	public Date  getDatePaugeDegener() {
		return datePaugeDegener;
	}
	public void setDatePaugeDegener(Date  datePaugeDegener) {
		this.datePaugeDegener = datePaugeDegener;
	}
	public Date  getDatePauge() {
		return datePauge;
	}
	public void setDatePauge(Date  datePauge) {
		this.datePauge = datePauge;
	}
	@ManyToMany(mappedBy="listeDatesProposees")
	public List<Sondage>  getListeSondages() {
		return listeSondages;
	}
	public void setListeSondages(List listeSondages) {
		this.listeSondages = listeSondages;
	}
	
	
	
	

}
