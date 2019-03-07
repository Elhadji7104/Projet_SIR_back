package daoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;

@Transactional
public class UtilisateurDaoImp implements UtilisateurDao {
	@PersistenceContext(unitName="doodle")
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
		this.tx.begin();
		Utilisateur utilisateur = new Utilisateur();
		try {
			utilisateur =  (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL).setParameter("mail", mail).getSingleResult();	
		} catch (Exception e) {
			// TODO: handle exception
		}
		tx.commit();
		return utilisateur;
	}
	//delete user
	public Utilisateur deleteUser(String mail) {
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
			this.tx.begin();
			try {		
				manager.persist(u);
				tx.commit();
			}catch (Exception e) {
				// TODO: handle exception
			}
			manager.close();
			return u;	
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
			String d = "SELECT u FROM Utilisateur as u";

			List<Utilisateur> it = 	manager.createQuery(d).getResultList();

			for( Utilisateur u : it) {

				System.out.println(u.getMail());
			}
		}
	}
}
