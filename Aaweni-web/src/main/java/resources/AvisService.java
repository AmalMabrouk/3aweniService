package resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import aaweni.entity.Avis;
import aaweni.entity.Demande;
import aaweni.entity.Offre_Agent;
import aaweni.service.interf.IAvisServiceRemote;
import aaweni.service.interf.IDemandeServiceRemote;
import aaweni.service.interf.IOffreAgentServiceRemote;

@Path("avis")
public class AvisService {

	@EJB
	IAvisServiceRemote as;
	static List<Avis> Avislist;
	
	@POST
	@Path("ajouterAvis")
	@Consumes("application/json")
	public String register(Avis avis) {


		as.addAvis(avis);
		return "ajout";

	}
	

	@POST
	@Path("SuppAvis/{id}")
	public String supprimer(@PathParam(value="id") int id) {

		as.removeAvis(id);
		return "suppression effectuée";

	}
	
	
	@GET
	@Path("AvisdAgent/{id}")
	@Produces("application/json")
	public List<Avis> AvisdAgents(@PathParam(value="id") int id) {
		
		
		System.out.println("here");
		Avislist = as.AvisParAgent(id);
		if (Avislist != null) {
			return Avislist;
		}
		
		return null;
	}
	
	

	
	
	
	
}
