package service;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import daoImpl.UtilisateurDaoImp;

import java.sql.SQLException;
import java.util.List;

import metier.PreferenceAlimentaire;
import metier.Utilisateur;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown=true)
@Path("/user")
public class UtilisateurService {
	UtilisateurDaoImp utilisateurDao;
	public UtilisateurService() {
		super();
		this.utilisateurDao = new UtilisateurDaoImp();
	}
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
	@POST
	@Path("/addPreferenceAli/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void addPreference(PreferenceAlimentaire p,@PathParam("mail") String mail) {
		System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		utilisateurDao.addPreferenceAli(p, mail);
	}
	@GET
	@Path("/getUser/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUser(@PathParam("mail") String mail) {
		System.out.print(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.getUtilisateurByEmail(mail);
	}
}
