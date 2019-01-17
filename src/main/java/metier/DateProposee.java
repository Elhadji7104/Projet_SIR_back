package metier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.mysql.fabric.xmlrpc.base.Data;


@Entity
public class DateProposee {
	
	private long  idDate;
	
	private LocalDate  datePaugeDegener;
	private LocalDate  datePauge;
	private List<Sondage> listeSondages = new ArrayList<Sondage>();
	public DateProposee() {}
	public DateProposee(LocalDate  datesond2, LocalDate  datesond3) {
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
	
	
	public LocalDate  getDatePaugeDegener() {
		return datePaugeDegener;
	}
	public void setDatePaugeDegener(LocalDate  datePaugeDegener) {
		this.datePaugeDegener = datePaugeDegener;
	}
	public LocalDate  getDatePauge() {
		return datePauge;
	}
	public void setDatePauge(LocalDate  datePauge) {
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
