package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;

import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;

@Transactional
public class UtilisateurDaoImp implements UtilisateurDao {
	@PersistenceContext(unitName="doodle")
	EntityManager manager ; 
	EntityTransaction tx ;

	private final static String QUERY_FIND_ELEVES = "SELECT u FROM Utilisateur  u";
	private final static String QUERY_FIND_UTILISATEUR_BY_MAIL = "SELECT u FROM Utilisateur u where u.mail = :mail";


	public UtilisateurDaoImp() {
		this.manager = EntityManagerHelper.getEntityManager();
		this.tx      =  manager.getTransaction();
	}

	public List<Utilisateur> getListUtilisateur() throws SQLException{	
		this.tx.begin();
		List<Utilisateur> listesEleves = new ArrayList<Utilisateur>();
		listesEleves = manager.createQuery(QUERY_FIND_ELEVES).getResultList();
		tx.commit();
		return listesEleves;
	}

	private Utilisateur rsetToEleve(ResultSet rset) throws SQLException {

		String mail = rset.getString("mail");
		String nom = rset.getString("nom");
		String prenom = rset.getString("prenom");
		String mdp = rset.getString("mdp");

		Utilisateur u = new Utilisateur(mail, nom, prenom,mdp);
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
	//saver un utilisateur
	public Utilisateur save(String mail, String nom, String prenom, String mdp ) {
		Utilisateur u = new Utilisateur();
		u.setMail(mail);
		u.setNom(nom);
		u.setPrenom(prenom);
		u.setMdp(mdp);
		this.tx.begin();
		try {		
			manager.persist(u);
			this.tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return u;	
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

	public Utilisateur getUtilisateurByEmail(String mail) {
		this.tx.begin();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = manager.createQuery(QUERY_FIND_ELEVES);
		tx.commit();
		return utilisateur;
	}

	
}
