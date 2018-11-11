package aaweni.service.interf;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import aaweni.entity.User;


@Local
public interface IUserServiceLocal {
	
	public int addUser(User user);

	public void removeUser(int id);

	public void updateUser(User user);

	public User findUserById(int id);

	public List<User> findAllUsers();

	void findAllUsers1();
	public User findUserByMail(String mail);

}
