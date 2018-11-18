package aaweni.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aaweni.entity.CordgeoDemande;
import aaweni.entity.Demande;
import aaweni.entity.User;
import aaweni.service.interf.IDemandeServiceRemote;

@Stateless
public class DemandeServiceImpl implements IDemandeServiceRemote {

	@PersistenceContext(unitName = "aaweni-ejb")
	EntityManager em;

	@Override
	public int addDemande(Demande demande) {

		System.out.println("In addDemande : ");
		// em.persist(user.getCordgeouser());
		em.persist(demande.getCordgeoudemande());
		em.persist(demande);
		System.out.println("Out of addUser" + demande.getId());
		return demande.getId();

	}

	@Override
	public void removeDemande(int id) {
		System.out.println("In removeUser : ");
		System.out.println(em.find(Demande.class, id));
		em.remove(em.find(CordgeoDemande.class, (em.find(Demande.class, id).getCordgeoudemande().getId())));

		em.remove(em.find(Demande.class, id));
		System.out.println("Out of removeUser : ");

	}

	@Override
	public void updatDemande(Demande demande) {

		System.out.println("In updateUser : ");
		Demande d1 = findDemandeById(demande.getId());

		d1.setClientD(demande.getClientD());
		d1.setOffreAgent(demande.getOffreAgent());
		d1.setCordgeoudemande(demande.getCordgeoudemande());
		d1.setPanne(demande.getPanne());
		d1.setType(demande.getType());
		d1.setEtat(demande.getEtat());
		d1.setDatedemande(demande.getDatedemande());
		// em.merge(demande.getCordgeoudemande());

		em.merge(d1);

		System.out.println("Out of updateUser : ");
	}

	@Override
	public List<Demande> findDemandeByIdClient(int id) {

		List<Demande> listedemande = null;
		try {
			Query query = em.createQuery("select e from Demande e where e.clientD.id=:id");
			query.setParameter("id", id);

			listedemande = query.getResultList();
		} catch (Exception e) {
			System.out.println("no data found");
		}
		if (listedemande != null) {
			System.out.println(listedemande.toString());
			return listedemande;
		}
		return null;

	}

	@Override
	public Demande findDemandeById(int id) {
		System.out.println("In Methode : ");
		Demande demande = new Demande();
		try {
			demande = em.find(Demande.class, id);
			System.out.println("Out of Methode : ");
			System.out.println(demande);
		} catch (Exception e) {
			System.out.println("no data found");
		}
		return demande;
	}

}
