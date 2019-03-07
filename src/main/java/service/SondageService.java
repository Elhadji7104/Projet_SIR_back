package service;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import daoImpl.SondageDaoImp;
import daoInterface.SondageDao;
import metier.Sondage;
import metier.Utilisateur;

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
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Sondage add(
			@FormParam("lienWeb") String lienWeb,
			@FormParam("mailCreateur") String mailCreateur
			) {
		  SondageDaoImp sondageDao = new SondageDaoImp();
		  return sondageDao.save(lienWeb, mailCreateur);
	}
}
