package metier;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import antlr.collections.List;
@Entity
public class DateProposee {
	
	private Date idDate;
	private Date datePaugeDegener;
	private Date datePauge;
	private List listeSondages;
	public DateProposee(Date idDate, Date datePaugeDegener, Date datePauge) {
		super();
		this.idDate = idDate;
		this.datePaugeDegener = datePaugeDegener;
		this.datePauge = datePauge;
		listeSondages = (List) new ArrayList<Sondage>();
	}
	@Id
	@GeneratedValue
	public Date getIdDate() {
		return idDate;
	}
	
	public void setIdDate(Date idDate) {
		this.idDate = idDate;
	}
	public Date getDatePaugeDegener() {
		return datePaugeDegener;
	}
	public void setDatePaugeDegener(Date datePaugeDegener) {
		this.datePaugeDegener = datePaugeDegener;
	}
	public Date getDatePauge() {
		return datePauge;
	}
	public void setDatePauge(Date datePauge) {
		this.datePauge = datePauge;
	}
	@ManyToMany
	public List getListeSondages() {
		return listeSondages;
	}
	public void setListeSondages(List listeSondages) {
		this.listeSondages = listeSondages;
	}
	
	
	
	

}
