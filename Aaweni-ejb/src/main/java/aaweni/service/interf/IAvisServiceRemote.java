package aaweni.service.interf;

import java.util.List;

import javax.ejb.Remote;

import aaweni.entity.Avis;
import aaweni.entity.Demande;

@Remote
public interface IAvisServiceRemote {
	
	
	public int addAvis(Avis avis);

	public void removeAvis(int id);

	//public void updatDemande(Demande demande);

	public List<Avis> AvisParAgent(int id);
	


	//Demande findDemandeById(int id);

	
}
