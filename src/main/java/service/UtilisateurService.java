package service;
import daoImpl.UtilisateurDaoImp;
import metier.Alergie;
import metier.PreferenceAlimentaire;

import metier.Utilisateur;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
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
	public Utilisateur add(Utilisateur u) {
		//System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.save(u);	 
	}
	@POST
	@Path("/addPreferenceAli/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	public PreferenceAlimentaire addPreference(PreferenceAlimentaire p,@PathParam("mail") String mail) {
		System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.addPreferenceAli(p, mail);
	}
	@POST
	@Path("/addAlergie/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Alergie addAlergie(Alergie a, @PathParam("mail") String mail) {
		System.out.println(mail);
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.addAlergie(a, mail);
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
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Utilisateur getUser(Utilisateur u) {
		UtilisateurDaoImp utilisateurDao = new UtilisateurDaoImp();
		return utilisateurDao.loginUser(u);
	}
}
