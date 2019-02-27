package service;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.lang.ProcessBuilder.Redirect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.mysql.fabric.Response;
import com.sun.jersey.api.Responses;

import daoImpl.UtilisateurDaoImp;
import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;
@Path("/user")
public class UtilisateurService {

	UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
	EntityManager manager = EntityManagerHelper.getEntityManager();
   
	@GET
	@Path("/acc")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
	@POST
	@Path("/add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	public void add(@FormParam("mail") String mail,
			@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("mdp") String mdp
			) {
		utilisateurDao.save(mail,nom,prenom,mdp);	 
		//return utilisateurDao.save(mail,nom,prenom,mdp);
		
	}
	@GET
	@Path("getUuser/{mail}")
	@Produces({ MediaType.APPLICATION_JSON })
    public Utilisateur getUuser(@PathParam("mail") String arg0) {
       return utilisateurDao.getUtilisateurByEmail(arg0);
    }
}
