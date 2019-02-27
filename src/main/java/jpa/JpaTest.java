package jpa;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import com.mysql.fabric.xmlrpc.base.Data;

import metier.DateProposee;
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
			Utilisateur u1=new Utilisateur("gora1@gmail2.com","fall","Gora","hhh"); //test
			Utilisateur u2=new Utilisateur("jl1@gmail2.com","le lec","Jean-Loup","nnnn");
			Date  datesond =  new Date();
			DateProposee dp = new DateProposee(datesond, datesond);
			DateProposee dp2 = new DateProposee(datesond , datesond );

			manager.persist(dp2);
			manager.persist(dp);

			
			Sondage s1=new Sondage("lienWeb",u1);
			Sondage s2=new Sondage("lienWeb2",u2);
			Sondage sCreateur=new Sondage("lienWeb3",u1);
			
			
			s2.getListeDatesProposees().add(dp2);
			s2.getListeDatesProposees().add(dp);
			
			
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
