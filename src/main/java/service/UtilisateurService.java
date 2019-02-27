package service;

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

import daoImpl.UtilisateurDaoImp;
import daoInterface.UtilisateurDao;
import jpa.EntityManagerHelper;
import metier.Utilisateur;
@Path("/user")
public class UtilisateurService {

	UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
	EntityManager manager = EntityManagerHelper.getEntityManager();
   
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur add(@FormParam("mail") String mail,
			@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("mdp") String mdp
			) {
		return utilisateurDao.save(mail,nom,prenom,mdp);
	}
	
    
    
   
   
	@GET
	@Path("{mail}")
	public Response getUser(@PathParam("mail") String mail,
			@MatrixParam("Utilisateur") String author,
			@MatrixParam("country") String country) {

		return null;

	}
	
	
}
