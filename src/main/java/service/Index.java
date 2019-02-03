package service;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
@JsonAutoDetect
@JsonIgnoreProperties(ignoreUnknown=true)
public class Index implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	Heater h;
	
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void addDevice(Heater h1) {
		// TODO Auto-generated method stub
		this.h = h1;
	}

	public Index(String name, Heater h) {
		super();
		this.name = name;
		this.h = h;
	}
	public Index() {}

}
