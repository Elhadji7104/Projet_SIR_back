package daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import daoInterface.SondageDao;
import jpa.EntityManagerHelper;
import metier.DateProposee;
import metier.Reunion;
import metier.Sondage;
import metier.Utilisateur;

public class SondageDaoImp implements SondageDao{
	
	EntityManager manager;
	EntityTransaction tx;
	
	public SondageDaoImp() {
		super();
		this.manager = 	EntityManagerHelper.getEntityManager();
		this.tx      =  manager.getTransaction();
	}
	private final static String QUERY_FIND_ALL_UTILISATEUR = "SELECT s FROM utilisateur_sondage  s";
	private final static String QUERY_FIND_UTILISATEUR_SONDAGE_CREATE_MAIL = "SELECT s FROM Sondage s where s.createur_mail =:mail";
	private final static String QUERY_FIND_ALL_SONDAGE = "SELECT s FROM Sondage  s";

	public Utilisateur getUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Utilisateur> getlisteUtilisateurs() {
		this.tx.begin();
		List<Utilisateur> listesEleves = new ArrayList<Utilisateur>();
		listesEleves = manager.createQuery(QUERY_FIND_ALL_SONDAGE).getResultList();
		tx.commit();
		return listesEleves;
	}

	public List<DateProposee> getlisteDatesProposees() {
		// TODO Auto-generated method stub
		return null;
	}

	public Reunion getreunionDuSondage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sondage save(Sondage s) {
		tx.begin();
		Reunion r = new Reunion();
		List<Sondage> listeSondage = new ArrayList<Sondage>();
		listeSondage.add(s);
		r.setListeSondages(listeSondage);
		s.setCreateur(s.getCreateur());
		s.setReunionDuSondage(r);
		try {	
			manager.persist(r);	
			manager.persist(s);	
			this.tx.commit();
		}catch (Exception e) {
			
		}
		return s;	
	}
	public List<Sondage> getlisteSondage() {
		this.tx.begin();
		List<Sondage> listeSondages = new ArrayList<Sondage>();
		listeSondages = manager.createQuery(QUERY_FIND_ALL_SONDAGE).getResultList();
		tx.commit();
		return listeSondages;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public EntityTransaction getTx() {
		return tx;
	}

	public void setTx(EntityTransaction tx) {
		this.tx = tx;
	}
	public void begin() {
		tx.begin();
	}
	public void commit() {
		tx.commit();
	}
	public void rollback() {
		tx.rollback();
	}
	public void setRollbackOnly() {
		tx.setRollbackOnly();
	}
	public boolean getRollbackOnly() {
		return tx.getRollbackOnly();
	}
	public boolean isActive() {
		return tx.isActive();
	}
	
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		if(manager != null) {
			String d = "SELECT s FROM Sondage as s";

			List<Sondage> it = 	manager.createQuery(d).getResultList();

			for( Sondage u : it) {

				System.out.println(u.getLienWeb());
			}
		}
	}

	
	
}
