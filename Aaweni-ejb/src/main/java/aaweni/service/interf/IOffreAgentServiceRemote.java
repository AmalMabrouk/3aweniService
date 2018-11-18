package aaweni.service.interf;

import java.util.List;

import javax.ejb.Remote;


import aaweni.entity.Offre_Agent;

@Remote
public interface IOffreAgentServiceRemote {
	
	public int addOffre_Agent(Offre_Agent offre);
	
	public Offre_Agent findOffreAgentById(int id);
	public void removeOffre(int id);

	public void updatOffre(Offre_Agent offre);

	public List<Offre_Agent> findOffreByDemende(int id);
	
	
	
	public Offre_Agent Offre_Agent_Demande(int idDemande, int idAgent);
	

}
