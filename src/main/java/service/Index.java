package service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import metier.Utilisateur;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown=true)
public class Index implements Serializable {	
	/**
	 * 
	 */
	private List<Utilisateur> Utilisateurs = new ArrayList<Utilisateur>();

    public Index() {
        for (int i = 0; i < 10; i++) {
        	//Utilisateurs.add(new Utilisateur("Mail " + i, "Nom " + i,"Prenom","Mdp"));
        }
    }
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public Collection<Utilisateur> list() {
        return Utilisateurs;
    }
	private static final long serialVersionUID = 1L;
	String name;
	Heater h;
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}	
}
