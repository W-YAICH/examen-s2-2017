package tn.esprit.examen_s2_2017.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_s2_2017.persistence.User;
import tn.esprit.examen_s2_2017.services.UserService;

@ManagedBean
public class UserBean {
	
	private User user = new User();
	
	@EJB
	UserService userService;

	
	public void ajouterUser(){
		userService.ajouterUser(user);
	}
	
	public List<User> getUsers() {
		return userService.getUsers();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
