package resources;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import aaweni.entity.Demande;
import aaweni.entity.Offre_Agent;
import aaweni.service.interf.IDemandeServiceRemote;
import aaweni.service.interf.IOffreAgentServiceRemote;

@Path("offres")
public class OffreService {

	@EJB
	IOffreAgentServiceRemote os;
	static List<Offre_Agent> Offrelist;
	
	@POST
	@Path("ajouterOffre")
	@Consumes("application/json")
	public String register(Offre_Agent offre) {


		os.addOffre_Agent(offre);
		return "ajout";

	}
	

	@POST
	@Path("SuppOffre/{id}")
	public String supprimer(@PathParam(value="id") int id) {

		os.removeOffre(id);
		return "suppression effectuée";

	}
	
	
	@GET
	@Path("LesOffresDeLaDemande/{id}")
	@Produces("application/json")
	public List<Offre_Agent> ListeOffreParDemande(@PathParam(value="id") int id) {
		
		
		System.out.println("here");
		Offrelist = os.findOffreByDemende(id);
		if (Offrelist != null) {
			return Offrelist;
		}
		
		return null;
	}
	
	
	@GET
	@Path("OffreParAgentEtDemande/{idA}/{idD}")
	@Produces("application/json")
	public Offre_Agent OffreParAgentEtDemande(@PathParam(value="idA") int idA,@PathParam(value="idD") int idD) {
		System.out.println("here");
		Offre_Agent o = os.Offre_Agent_Demande(idD,idA);
		if (o != null) {
			return o;
		}
		
		return null;
	}
	
	
	
	
}
