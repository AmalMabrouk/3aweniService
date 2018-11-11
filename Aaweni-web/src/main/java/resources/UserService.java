package resources;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.mindrot.jbcrypt.BCrypt;

import com.sun.mail.iap.Response;

import aaweni.entity.User;
import aaweni.service.impl.UserServiceImpl;
import aaweni.service.interf.IUserServiceLocal;

@Path("users")
public class UserService {

	@EJB
	IUserServiceLocal us;
	static List<User> Userlist;

	@GET
	@Produces("application/json")
	public List<User> ListeUser() {
		System.out.println("here");
		Userlist = us.findAllUsers();
		if (Userlist != null) {
			return Userlist;
		}
		return null;
	}

	@POST
	@Path("ajouterUser")
	@PermitAll
	@Consumes("application/json")
	public String register(User u) {

		us.addUser(u);
		return "ajout";

	}

	@GET
	@Path("findUser/{id}")
	@Produces("application/json")
	public User recherche(@PathParam(value = "id") int id) {
		User u = us.findUserById(id);
		if (u != null) {
			return u;
		}
		return null;
	}

	@DELETE
	@Path("SuppUser/{id}")
	public String deleteemp(@PathParam(value = "id") int id)

	{
		us.removeUser(id);
		return "supp";
	}

	@PUT
	@Consumes("application/json")
	@Path("UpdateUser")
	public String updateEmployee(User u) {
		us.updateUser(u);
		
		return "mise a jour ";

	}
	
	
	
	@GET
	@Path("findUserByMail/{mail}")
	@Produces("application/json")
	public User recherche(@PathParam(value = "mail") String mail) {
		User u = us.findUserByMail(mail);
		if (u != null) {
			return u;
		}
		return null;
	}
}
