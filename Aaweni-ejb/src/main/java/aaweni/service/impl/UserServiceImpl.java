package aaweni.service.impl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FetchType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import aaweni.entity.User;

import aaweni.service.interf.IUserServiceRemote;

@Stateless
public class UserServiceImpl implements IUserServiceRemote {

	@PersistenceContext(unitName = "aaweni-ejb")
	EntityManager em;

	@Override
	public int addUser(User user) {
		System.out.println("In addUser : ");
		em.persist(user);
		System.out.println("Out of addUser" + user.getId());
		return user.getId();
	}

	@Override
	public void removeUser(int id) {
		System.out.println("In removeUser : ");
		em.remove(em.find(User.class, id));
		System.out.println("Out of removeUser : ");
	}

	@Override
	public void updateUser(User userNewValues) {
		System.out.println("In updateUser : ");
		User user = findUserById(userNewValues.getId());
		user.setAdresseMail(userNewValues.getAdresseMail());
		user.setCordgeouser(userNewValues.getCordgeouser());
		user.setCin(userNewValues.getCin());
		user.setNom(userNewValues.getNom());
		user.setPrenom(userNewValues.getPrenom());
		user.setPassword(userNewValues.getPassword());
		user.setCordgeouser(userNewValues.getCordgeouser());
		user.setPicture(userNewValues.getPicture());

		em.merge(user);

		System.out.println("Out of updateUser : ");
	}

	@Override
	public User findUserById(int id) {

		User user = new User();
		try {
			System.out.println("In findUserById : ");
			user = em.find(User.class, id);
			System.out.println("Out of findUserById : ");
			System.out.println(user);
		} catch (Exception e) {
			System.out.println("no data found");
		}
		return user;
	}

	@Override
	public List<User> findAllUsers() {
		System.out.println("In findAllUsers : ");
		List<User> users = em.createQuery("Select U from User U", User.class).getResultList();

		System.out.println("Out of findAllUsers : ");

		// System.out.println(users.get(1).toString());
		// users.toArray();
		System.out.println(users.toString());
		return users;

	}

	@Override
	public void findAllUsers1() {
		System.out.println("In findAllUsers : ");
		List<User> users = em.createQuery("from User", User.class).getResultList();
		System.out.println("Out of findAllUsers : ");
		System.out.println(users.toString());
	}

	@Override
	public User findUserByMail(String mail) {
		User user = new User();
		try {
			Query query = em.createQuery("select e from User e where e.adresseMail=:mail");
			query.setParameter("mail", mail);

			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("no data found");
		}
		if (user != null) {
			System.out.println(user.toString());
			return user;
		}
		return null;

	}

}