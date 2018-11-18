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
import aaweni.entity.User;
import aaweni.service.interf.IDemandeServiceRemote;
import aaweni.service.interf.IUserServiceRemote;

@Path("demandes")
public class DemandeService {
	
	@EJB
	IDemandeServiceRemote ds;
	static List<Demande> Demandelist;
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public List<Demande> ListeDemandeParClient(@PathParam(value="id") int id) {
		System.out.println("here");
		Demandelist = ds.findDemandeByIdClient(id);
		if (Demandelist != null) {
			return Demandelist;
		}
		
		return null;
	}

	@POST
	@Path("ajouterDemande")
	@Consumes("application/json")
	public String register(Demande e) {

		ds.addDemande(e);
		return "ajout";

	}
	
	
	@POST
	@Consumes("application/json")
	@Path("UpdateDemande")
	public String updateDemande(Demande d) {
		ds.updatDemande(d);
		
		return "mise a jour ";

	}
	
	
	@POST
	@Path("SuppDemande/{id}")
	public String supprimer(@PathParam(value="id") int id) {

		ds.removeDemande(id);
		return "suppression effectuée";

	}
	
	@GET
	@Path("findDemande/{id}")
	@Produces("application/json")
	public Demande recherche(@PathParam(value = "id") int id) {
		Demande u = ds.findDemandeById(id);
		if (u != null) {
			return u;
		}
		return null;
	}
	
}
