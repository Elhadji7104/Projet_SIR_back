package daoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.PreferenceAlimentaire;
import metier.Reunion;
import metier.Utilisateur;

@SuppressWarnings("unchecked")
@Transactional
public class UtilisateurDaoImp implements UtilisateurDao {
	EntityManager manager ; 
	EntityTransaction tx ;
	private final static String QUERY_FIND_ALL_UTILISATEUR = "SELECT u FROM Utilisateur  u";
	private final static String QUERY_FIND_UTILISATEUR_BY_MAIL = "SELECT u FROM Utilisateur u where u.mail =:mail";

	public UtilisateurDaoImp() {
		this.manager = EntityManagerHelper.getEntityManager();
		this.tx      =  manager.getTransaction();
	}
	//get liste user
	public List<Utilisateur> getListUtilisateur() throws SQLException{	
		this.tx.begin();
		List<Utilisateur> listesEleves = new ArrayList<Utilisateur>();
		listesEleves = manager.createQuery(QUERY_FIND_ALL_UTILISATEUR).getResultList();
		tx.commit();
		return listesEleves;
	}
	//get user 
	public Utilisateur getUtilisateurByEmail(String mail) {
		Objects.requireNonNull(mail, "Ne doit pas être vide");
		this.tx.begin();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur =  (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL).setParameter("mail", mail).getSingleResult();	
		tx.commit();
		return utilisateur;
	}
	//delete user
	public Utilisateur deleteUser(String mail) {
		Objects.requireNonNull(mail, "Ne doit pas être vide");
		this.tx.begin();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur =  (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL).setParameter("mail", mail).getSingleResult();
		tx.commit();
		manager.remove(utilisateur);
		this.tx.begin();
		tx.commit();
		return utilisateur;
	}
	//saver un utilisateur
	public Utilisateur save( Utilisateur u ) {	
		Objects.requireNonNull(u, "Ne doit pas être vide");
		this.tx.begin();
		try {		
			manager.persist(u);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return u;	
	}
	//add prference alimentaire
	public void addPreferenceAli(PreferenceAlimentaire p,String mail) {
		tx.begin();
		Objects.requireNonNull(p ,"preference  not null");
		Objects.requireNonNull(mail ,"mail not null");
		Utilisateur u = manager.find(Utilisateur.class, mail);
		u.addPreference(p);
		manager.persist(u);
		try {	
			manager.persist(p);	
			this.tx.commit();
		}catch (Exception e) {

		}
		System.out.println("La préférence a été crée!");
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

		if(manager != null) {
			String d = "SELECT u FROM Utilisateur as u";

			List<Utilisateur> it = 	manager.createQuery(d).getResultList();

			for( Utilisateur u : it) {

				System.out.println(u.getMail());
			}
		}
	}

}
