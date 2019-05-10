package service;
import daoImpl.SondageDaoImp;
import metier.DateProposee;
import metier.ReponsesSondage;
import metier.Sondage;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
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
    @GET
    @Path("/allsondageByUse/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sondage> getallsondageByUser(@PathParam("mail") String mail) {
        SondageDaoImp sondageDao = new SondageDaoImp();
        return sondageDao.getlisteSondageByUser(mail);
    }
    @GET
	@Path("/getIdSondage")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getIdSondage()
	{
		SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.getIdLasetSondage();
	}
	@GET
	@Path("/allParticipants/{idSondage}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReponsesSondage> getallParticipants(@PathParam("idSondage") Long idSondage) {
		SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.getlisteReponse(idSondage);
	}
	@GET
	@Path("/allDateProposee/{idSondage}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<DateProposee> getallDateProposee(@PathParam("idSondage") Long idSondage) {
		SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.getlisteDatesProposees(idSondage);
	}
	@POST
	@Path("/add/{mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Sondage add(Sondage s,@PathParam("mail") String mail) {
		  SondageDaoImp sondageDao = new SondageDaoImp();
		  return   sondageDao.save(s,mail);
	}
	@POST
	@Path("/repondreAUnSondage/{idSondage}/{idDate}")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public ReponsesSondage participerAUnSondage(@PathParam("idSondage") Long idSondage,@PathParam("idDate") Long idDate, ReponsesSondage r) {
		  SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.saveParticipation(idSondage,idDate,r);
	}
	@POST
	@Path("/definirDateSondate/{idSondage}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DateProposee ajouterDateSondage(@PathParam("idSondage") Long idsSondage, DateProposee p) {
		SondageDaoImp sondageDao = new SondageDaoImp();
		return sondageDao.addDateSondage(idsSondage,p);
	}

}
