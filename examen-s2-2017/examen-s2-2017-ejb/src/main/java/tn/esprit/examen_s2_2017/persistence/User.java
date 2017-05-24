package tn.esprit.examen_s2_2017.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Demande> demandesCrees;

	@ManyToMany(mappedBy = "users")
	private List<Demande> demandesTraitees;
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}

	public User(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Demande> getDemandesCrees() {
		return demandesCrees;
	}

	public void setDemandesCrees(List<Demande> demandesCrees) {
		this.demandesCrees = demandesCrees;
	}

	public List<Demande> getDemandesTraitees() {
		return demandesTraitees;
	}

	public void setDemandesTraitees(List<Demande> demandesTraitees) {
		this.demandesTraitees = demandesTraitees;
	}

}
