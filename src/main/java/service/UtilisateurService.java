package service;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.sql.SQLException;
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

	EntityManager manager = EntityManagerHelper.getEntityManager();
	@DELETE
	@Path("/delete/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur delete(@PathParam("mail") String mail) {
		System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.deleteUser(mail);
	}
	@GET
	@Path("/alluser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Utilisateur> list() throws SQLException {
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return	utilisateurDao.getListUtilisateur();
	}
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur add(Utilisateur u) {
		//System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.save(u);	 
	}
	@GET
	@Path("/getUser/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUser(@PathParam("mail") String mail) {
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.getUtilisateurByEmail(mail);
	}
}
