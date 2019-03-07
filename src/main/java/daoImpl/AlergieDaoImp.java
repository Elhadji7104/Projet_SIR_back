package daoImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import daoInterface.AlergieDao;
import metier.Alergie;
import metier.Utilisateur;

public class AlergieDaoImp implements AlergieDao{
	@PersistenceContext(unitName="doodle")
	EntityManager manager ; 
	EntityTransaction tx ;
	private final static String QUERY_FIND_ALL_ALERGIE = "SELECT a FROM Alergie a";
	
	public List<Alergie> getListAlergie() throws SQLException {
		this.tx.begin();
		List<Alergie> listesAlergies = new ArrayList<Alergie>();
		listesAlergies = manager.createQuery(QUERY_FIND_ALL_ALERGIE).getResultList();
		tx.commit();
		return listesAlergies;
	}

	public Alergie save(Alergie alergie) {
		this.tx.begin();
		try {		
			manager.persist(alergie);
			tx.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		manager.close();
		return alergie;	
	}
	
}
