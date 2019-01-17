package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import metier.Sondage;
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
			
			
			
			Utilisateur u1=new Utilisateur("gora1@gmail.com","fall","Gora"); //test
			Utilisateur u2=new Utilisateur("jl1@gmail.com","le lec","Jean-Loup");
			
			Sondage s1=new Sondage("lienWeb",u1);
			Sondage s2=new Sondage("lienWeb2",u2);
			Sondage sCreateur=new Sondage("lienWeb3",u1);
			
			u1.getListeSondages().add(s1);
			u1.getListeSondages().add(s2);
			
			u1.getListeSondagesCrees().add(sCreateur);
			
			manager.persist(s1);
			manager.persist(s2);
			
			
			
			
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
