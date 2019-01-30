package daoImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;

import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;

public class UtilisateurDaoImp implements UtilisateurDao {
	
	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	
	
	public UtilisateurDaoImp() {
		
	}
	
	
	public List<Utilisateur> getListUtilisateur(){	
		this.tx.begin();
		String d = "SELECT u FROM Utilisateur as u";
		
		return manager.createNamedQuery(d).getResultList();
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
	public void save(Utilisateur u) {
		// TODO Auto-generated method stub
		
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
}
