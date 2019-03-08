package service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.ObjectMapper;

import daoImpl.SondageDaoImp;
import daoInterface.SondageDao;
import metier.DateProposee;
import metier.Sondage;
import metier.Utilisateur;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown=true)
@Path("/sondage")
public class SondageService {
	@GET
	@Path("/user")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
	@GET
	@Path("/allsondage")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Sondage> getallsondage() {
		SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.getlisteSondage();
	}
	@POST
	@Path("/add/{mail}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void add(Sondage s,@PathParam("mail") String mail) {
		  SondageDaoImp sondageDao = new SondageDaoImp();
		  sondageDao.save(s,mail);
	}
	@POST
	@Path("/repondreAUnSondage/{idSondage}/{mailUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void participerAUnSondage(@PathParam("idsondage") int idsSondage,@PathParam("mail") String mail,DateProposee p) {
		  System.out.println();
		  SondageDaoImp sondageDao = new SondageDaoImp();
	}
	@POST
	@Path("/definirDateSondate/{idSondage}/{mailUser}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void adjouterDateSondage(@PathParam("idsondage") int idsSondage,@PathParam("mail") String mail,DateProposee p) {
		  System.out.println();
		  SondageDaoImp sondageDao = new SondageDaoImp();
	}
}
