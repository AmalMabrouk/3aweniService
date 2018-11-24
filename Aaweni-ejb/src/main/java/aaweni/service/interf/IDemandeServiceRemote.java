package aaweni.service.interf;

import java.util.List;

import javax.ejb.Remote;

import aaweni.entity.Demande;

@Remote
public interface IDemandeServiceRemote {
	
	
	 int addDemande(Demande demande);

	 void removeDemande(int id);

	 void updatDemande(Demande demande);

	 List<Demande> findDemandeByIdClient(int id);

	 Demande findDemandeById(int id);
	 
	 List<Demande> findDemandeBySpecialite(String specialite);

	
}
