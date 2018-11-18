package aaweni.service.interf;

import java.util.List;

import javax.ejb.Remote;

import aaweni.entity.Demande;

@Remote
public interface IDemandeServiceRemote {
	
	
	public int addDemande(Demande demande);

	public void removeDemande(int id);

	public void updatDemande(Demande demande);

	public List<Demande> findDemandeByIdClient(int id);

	Demande findDemandeById(int id);

	
}
