package service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.mysql.fabric.Response;

import daoImpl.UtilisateurDaoImp;
import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;
@Path("/user")
public class UtilisateurService implements UtilisateurDao {

	EntityManager manager = EntityManagerHelper.getEntityManager();
	EntityTransaction tx = manager.getTransaction();
	private final static String QUERY_FIND_ELEVES = "SELECT * FROM utilisateur ";
	private final static String QUERY_FIND_ELEVES_BY_CLASSE = "SELECT * FROM utilisateur WHERE classe = ? ";
	private UtilisateurDaoImp utilisateur;
	
	@GET
	@Path("{mail}")
	public Response getUser(@PathParam("mail") String mail,
			@MatrixParam("Utilisateur") String author,
			@MatrixParam("country") String country) {

		return null;

	}
	public List<Utilisateur> findAll() throws SQLException {
		tx.begin();
		List<Utilisateur> listesEleves = new ArrayList<Utilisateur>();


		ResultSet rset = (ResultSet) manager.createQuery(QUERY_FIND_ELEVES);
		tx.commit();
		while (rset.next()) {
			Utilisateur eleve = rsetToEleve(rset);
			listesEleves.add(eleve);
		}


		return listesEleves;
	}
	
	private Utilisateur rsetToEleve(ResultSet rset) throws SQLException {

		String email = rset.getString("nom");
		String nom = rset.getString("nom");
		String prenom = rset.getString("prenom");


		Utilisateur u = new Utilisateur(email, nom, prenom);
		return u;
	}

	public List<Utilisateur> getListUtilisateur() {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(Utilisateur u) {
		// TODO Auto-generated method stub

	}
}
