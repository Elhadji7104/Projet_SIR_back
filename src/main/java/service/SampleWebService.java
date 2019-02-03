package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)

@Path("/hello")
public class SampleWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello, how are you?";
	}
	@GET
	@Path("/index")
	@Produces(MediaType.APPLICATION_JSON)
	public Index getHome() {
		Index h = new Index();
		h.setName("toto");
		Heater h1 = new Heater();
		h1.setPower("500w");
		Heater h2 = new Heater();
		h2.setPower("600w");
		h.addDevice(h1);
		h.addDevice(h2);
		return h;
	}

}
