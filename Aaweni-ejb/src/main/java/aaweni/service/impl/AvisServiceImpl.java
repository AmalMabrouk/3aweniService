package aaweni.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aaweni.entity.Avis;
import aaweni.entity.CordgeoDemande;
import aaweni.entity.Demande;
import aaweni.entity.User;
import aaweni.service.interf.IAvisServiceRemote;
import aaweni.service.interf.IDemandeServiceRemote;

@Stateless
public class AvisServiceImpl implements IAvisServiceRemote {

	@PersistenceContext(unitName = "aaweni-ejb")
	EntityManager em;

	@Override
	public int addAvis(Avis avis) {

		System.out.println("In Mathode : ");
		// em.persist(user.getCordgeouser());

		em.persist(avis);
		System.out.println("Out of addUser" + avis.getId());
		return avis.getId();
	}

	@Override
	public void removeAvis(int id) {
		System.out.println("In remove : ");
		System.out.println(em.find(Avis.class, id));

		em.remove(em.find(Avis.class, id));
		System.out.println("Out of remove : ");

	}

	@Override
	public List<Avis> AvisParAgent(int id) {
		List<Avis> listeAvis = null;
		try {
			Query query = em.createQuery("select e from Avis e where e.agent.id=:id");
			query.setParameter("id", id);

			listeAvis = query.getResultList();
		} catch (Exception e) {
			System.out.println("no data found");
		}
		if (listeAvis != null) {
			System.out.println(listeAvis.toString());
			return listeAvis;
		}
		return null;
	}

}
