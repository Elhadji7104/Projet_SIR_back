package daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import daoInterface.SondageDao;
import jpa.EntityManagerHelper;
import metier.*;

public class SondageDaoImp implements SondageDao{
	
	private EntityManager manager;

	
	public SondageDaoImp() {
		super();
		this.manager = 	EntityManagerHelper.getEntityManager();
	}
	private final static String QUERY_FIND_ALL_UTILISATEUR = "SELECT s FROM utilisateur_sondage  s";
	private final static String QUERY_FIND_UTILISATEUR_SONDAGE_CREATE_MAIL = "SELECT s FROM Sondage s where s.createur =:mail";


    private final static String QUERY_FIND_ALL_SONDAGE = "SELECT s FROM Sondage  s";
	private final static String QUERY_ALL_PARTICIPANTS = "SELECT s FROM Sondage s where s.idSondage =:idSondage";
    private final static String QUERY_ALL_DATEPROPOSEE = "SELECT d FROM DateProposee d where d.sondage.idSondage =:idSondage";

	public Utilisateur getUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Utilisateur> getlisteUtilisateurs() {
		EntityManagerHelper.beginTransaction();
		List<Utilisateur> listesEleves = new ArrayList<Utilisateur>();
		listesEleves = this.manager.createQuery(QUERY_FIND_ALL_SONDAGE).getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return listesEleves;
	}

    @Override
    public List<DateProposee> getlisteDatesProposees(Long idSondage) {
		EntityManagerHelper.beginTransaction();
        List<DateProposee> listeDates = new ArrayList<>();
        listeDates = this.manager.createQuery(QUERY_ALL_DATEPROPOSEE).setParameter("idSondage", idSondage).getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
        return listeDates;
    }


	public Reunion getreunionDuSondage() {
		// TODO Auto-generated method stub
		return null;
	}

	public Sondage save(Sondage s, String mail) {
		EntityManagerHelper.beginTransaction();
		Objects.requireNonNull(s ,"le sondage ne doit pas etre null");
	    Objects.requireNonNull(mail ,"le  mail ne doit pas etre null");
		Reunion r = new Reunion();
		s.setReunionDuSondage(r);
		Utilisateur u = this.manager.find(Utilisateur.class, mail);
		u.addSondage(s);
		this.manager.persist(r);
		this.manager.persist(u);
		s.setCreateur(u);	
		try {	
		this.manager.persist(s);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		}catch (Exception e) {
			
		}
		return  s;
	}

	@Override
	public DateProposee addDateSondage(Long idSondage,DateProposee p) {
		EntityManagerHelper.beginTransaction();
		Objects.requireNonNull(idSondage ,"le sondage ne doit pas etre null");
		Objects.requireNonNull(p ,"la date ne doit pas etre null");
		Sondage s = this.manager.find(Sondage.class, idSondage);
		s.addDateSondage(p);
		this.manager.persist(s);
		p.setSondage(s);
		try {
		 this.manager.persist(p);
		 EntityManagerHelper.commit();
		 EntityManagerHelper.closeEntityManager();
		}catch (Exception e){}
		System.out.println("la date a été ajouté");
		return p;
	}

    public String getIdLasetSondage() {
		EntityManagerHelper.beginTransaction();
        return this.manager.createQuery("SELECT  MAX(s.idSondage) FROM Sondage s").getSingleResult().toString();
	}
	@Override
	public ReponsesSondage saveParticipation(Long idSondage,Long idDate,ReponsesSondage r) {
		EntityManagerHelper.beginTransaction();
		Objects.requireNonNull(idSondage ,"le sondage ne doit pas etre null");
		Objects.requireNonNull(r ,"la date ne doit pas etre null");
		Sondage s = this.manager.find(Sondage.class,idSondage);
		DateProposee d = this.manager.find(DateProposee.class, idDate);
		this.manager.persist(r);
		s.addReponseSondage(r);
		r.setDateProposee(d);
		r.setSondage(s);
		try{
			this.manager.persist(s);
			this.manager.persist(r);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		}catch (Exception e){

		}
		System.out.println("La participation est bien enregistrée");
		return r;
	}
    @Override
    public List<Sondage> getlisteSondageByUser(String mail) {
        Utilisateur u = this.manager.find(Utilisateur.class, mail);
        return this.manager.createQuery(QUERY_FIND_UTILISATEUR_SONDAGE_CREATE_MAIL).setParameter("mail", u).getResultList();
    }

    public List<Sondage> getlisteSondage() {
		return this.manager.createNamedQuery("findAllsondage", Sondage.class).getResultList();
	}

	@Override
	public List<ReponsesSondage> getlisteReponse(Long idSondage) {
		List<ReponsesSondage> list = new ArrayList<>();
		Sondage s = new Sondage();

		list =  manager.createQuery(QUERY_ALL_PARTICIPANTS).setParameter("idSondage", idSondage).getResultList();
	    return list;
	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();

		if(manager != null) {
			String d = "SELECT s FROM DateProposee as s";

			List<DateProposee> it = 	manager.createQuery(d).getResultList();
			for( DateProposee u : it) {

				System.out.println(u.getDateSondage());
			}
		}
	}
}
