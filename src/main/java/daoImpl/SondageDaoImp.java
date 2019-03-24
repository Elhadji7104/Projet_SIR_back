package daoImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import daoInterface.SondageDao;
import jpa.EntityManagerHelper;
import metier.*;

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
	private final static String QUERY_ALL_PARTICIPANTS = "SELECT r FROM ReponseSondage r,Sondage s  WHERE s.id = :idSondage and r.idReponse = s.idSondage";

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

	public Sondage save(Sondage s, String mail) {
		tx.begin();
		Objects.requireNonNull(s ,"le sondage ne doit pas etre null");
	    Objects.requireNonNull(mail ,"le  mail ne doit pas etre null");
		Reunion r = new Reunion();
		s.setReunionDuSondage(r);
		Utilisateur u = manager.find(Utilisateur.class, mail);
		u.addSondage(s);
		manager.persist(r);
		manager.persist(u);
		s.setCreateur(u);	
		try {	
		manager.persist(s);	
			this.tx.commit();
		}catch (Exception e) {
			
		}
		return  s;
	}

	@Override
	public DateProposee addDateSondage(Long idSondage,DateProposee p) {
		tx.begin();
		Objects.requireNonNull(idSondage ,"le sondage ne doit pas etre null");
		Objects.requireNonNull(p ,"la date ne doit pas etre null");
		Sondage s = manager.find(Sondage.class, idSondage);
		s.addDateSondate(p);
		manager.persist(s);
		try {
		 this.manager.persist(p);
		 this.tx.commit();
		}catch (Exception e){}
		System.out.println("la date a été ajouté");
		return null;
	}

	@Override
	public ReponsesSondage saveParticipation(Long idSondage,ReponsesSondage r) {
		this.tx.begin();
		Objects.requireNonNull(idSondage ,"le sondage ne doit pas etre null");
		Objects.requireNonNull(r ,"la date ne doit pas etre null");

		Sondage s = manager.find(Sondage.class,idSondage);
		s.addReponse(r);
		manager.persist(s);
		try{
			manager.persist(r);
			this.tx.commit();
		}catch (Exception e){

		}
		System.out.println("La participation est bien enregistrée");
		return r;
	}

	public List<Sondage> getlisteSondage() {
		this.tx.begin();
		return this.manager.createNamedQuery("findAllsondage", Sondage.class).getResultList();
	}

	@Override
	public List<ReponsesSondage> getlisteReponse(Long idSondage) {
		this.tx.begin();

		List<ReponsesSondage> list = new ArrayList<>();
		//list = this.manager.createNamedQuery("allParticipant",ReponsesSondage.class).getResultList();
		list = manager.createQuery(QUERY_ALL_PARTICIPANTS).getResultList();
		tx.commit();
		return list;
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
