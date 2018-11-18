package aaweni.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aaweni.entity.Offre_Agent;

import aaweni.service.interf.IOffreAgentServiceRemote;

@Stateless
public class Offre_AgentServiceImpl implements IOffreAgentServiceRemote {

	@PersistenceContext(unitName = "aaweni-ejb")
	EntityManager em;

	@Override
	public void removeOffre(int id) {
		System.out.println("In Mathode : ");
		em.remove(em.find(Offre_Agent.class, id));
		System.out.println("Out of Methode : ");
	}

	@Override
	public void updatOffre(Offre_Agent offre) {
		System.out.println("In Methode : ");
		Offre_Agent offre1 = findOffreAgentById(offre.getId());
		offre1.setDemande(offre.getDemande());
		offre1.setEtat(offre.getEtat());
		offre1.setPrixpropose(offre.getPrixpropose());
		offre1.setUser(offre.getUser());

		em.merge(offre1);

		System.out.println("Out of Methode : ");
	}

	@Override
	public List<Offre_Agent> findOffreByDemende(int id) {

		List<Offre_Agent> listeOffre = null;
		try {
			Query query = em.createQuery("select e from Offre_Agent e where e.demande.id=:id");
			query.setParameter("id", id);

			listeOffre = query.getResultList();
		} catch (Exception e) {
			System.out.println("no data found");

		}

		if (listeOffre != null) {
			System.out.println(listeOffre.toString());
			return listeOffre;
		}
		return null;

	}

	@Override
	public int addOffre_Agent(Offre_Agent offre) {
		em.persist(offre);
		return offre.getId();
	}

	@Override
	public Offre_Agent findOffreAgentById(int id) {
		System.out.println("In findUserById : ");
		Offre_Agent offre = new Offre_Agent();
		try {
			offre = em.find(Offre_Agent.class, id);
			System.out.println("Out of findUserById : ");
			System.out.println(offre);
		} catch (Exception e) {
			System.out.println("Offre introuvable");
		}
		return offre;
	}

	@Override
	public Offre_Agent Offre_Agent_Demande(int idDemande, int idAgent) {
		Offre_Agent o = new Offre_Agent();
		try {
			Query query = em
					.createQuery("select e from Offre_Agent e where e.demande.id=:idDemande and e.user.id=:idAgent");
			query.setParameter("idDemande", idDemande);
			query.setParameter("idAgent", idAgent);
			o = (Offre_Agent) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("erreur !! no data found");
		}
		if (o != null)
			return o;

		return null;
	}

}
