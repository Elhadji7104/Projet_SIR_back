package daoImpl;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Alergie;
import metier.PreferenceAlimentaire;
import metier.Utilisateur;

import static java.util.Objects.requireNonNull;

@SuppressWarnings("unchecked")
@Transactional
public class UtilisateurDaoImp implements UtilisateurDao {
	EntityManager manager ;
	private final static String QUERY_FIND_ALL_UTILISATEUR = "SELECT u FROM Utilisateur  u";
	private final static String QUERY_FIND_UTILISATEUR_BY_MAIL = "SELECT u FROM Utilisateur u where u.mail =:mail";
	private final static String QUERY_FIND_UTILISATEUR_BY_MAIL_AND_MDP = "SELECT u FROM Utilisateur u where u.mail =:mail and u.mdp =:mdp ";

	public UtilisateurDaoImp() {
		this.manager = EntityManagerHelper.getEntityManager();
	}
	//get liste user
	public List<Utilisateur> getListUtilisateur() throws SQLException{
		EntityManagerHelper.beginTransaction();
		List listesEleves = new ArrayList<Utilisateur>();
		listesEleves = manager.createQuery(QUERY_FIND_ALL_UTILISATEUR).getResultList();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return listesEleves;
	}
	//get user 
	public Utilisateur getUtilisateurByEmail(String mail) {
		requireNonNull(mail, "Ne doit pas être vide");
		EntityManagerHelper.beginTransaction();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur =  (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL).setParameter("mail", mail).getSingleResult();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		manager.close();
		return utilisateur;
	}
	//delete user
	public Utilisateur deleteUser(String mail) {
		requireNonNull(mail, "Ne doit pas être vide");
		EntityManagerHelper.beginTransaction();
		Utilisateur utilisateur = new Utilisateur();
		utilisateur =  (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL).setParameter("mail", mail).getSingleResult();
		EntityManagerHelper.commit();
		manager.remove(utilisateur);
		EntityManagerHelper.beginTransaction();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return utilisateur;
	}
	//saver un utilisateur
	public Utilisateur save( Utilisateur u ) {	
		requireNonNull(u, "Ne doit pas être vide");
		EntityManagerHelper.beginTransaction();
		try {		
			manager.persist(u);
			EntityManagerHelper.commit();
		}catch (Exception e) {
			// TODO: handle exception
		}
		manager.close();
		return u;	
	}
	//add prference alimentaire
	public PreferenceAlimentaire addPreferenceAli(PreferenceAlimentaire p,String mail) {
		EntityManagerHelper.beginTransaction();
		requireNonNull(p ,"preference  not null");
        	requireNonNull(mail ,"mail not null");
		Utilisateur u = manager.find(Utilisateur.class, mail);
		u.addPreference(p);
		manager.persist(u);
		try {
			manager.persist(p);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		}catch (Exception e) {
		}
		System.out.println("La préférence a été crée!");
		return  p;
	}
	public Utilisateur loginUser(Utilisateur u) {
		EntityManagerHelper.beginTransaction();
		manager.find(Utilisateur.class, u);
		String mail =	u.getMail();
		String mdp  =	u.getMdp();
		Utilisateur ur = (Utilisateur) manager.createQuery(QUERY_FIND_UTILISATEUR_BY_MAIL_AND_MDP)
				.setParameter(
						"mail", mail)
				.setParameter("mdp", mdp)
				.getSingleResult();
		EntityManagerHelper.commit();
		EntityManagerHelper.closeEntityManager();
		return  ur;
	}
	//add alergie
	public Alergie addAlergie(Alergie a, String mail) {
		EntityManagerHelper.beginTransaction();
		requireNonNull(a ,"Alergie  not null");
		requireNonNull(mail ,"mail not null");
		Utilisateur u = manager.find(Utilisateur.class, mail);
		u.addAlergie(a);
		manager.persist(u);
		try {
			manager.persist(a);
			EntityManagerHelper.commit();
			EntityManagerHelper.closeEntityManager();
		}catch (Exception e) {

		}
		System.out.println("L'alergie a été crée!");
		return  a;

	}
	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
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
