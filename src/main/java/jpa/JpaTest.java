package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import metier.Utilisateur;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			Utilisateur u1=new Utilisateur("gora@gmail.com","fall","Gora");
			Utilisateur u2=new Utilisateur("jl@gmail.com","le lec","Jean-Loup");
			
			manager.persist(u1);
			manager.persist(u2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
 

		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}


}
