package tn.esprit.examen_s2_2017.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Demande
 *
 */
@Entity

public class Demande implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libele;
	
	@ManyToMany
	private List<User> users;
	private static final long serialVersionUID = 1L;

	public Demande() {
		super();
	}
	
	public Demande(String libele) {
		super();
		this.libele = libele;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	
	public String getLibele() {
		return this.libele;
	}

	public void setLibele(String libele) {
		this.libele = libele;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
   
}
