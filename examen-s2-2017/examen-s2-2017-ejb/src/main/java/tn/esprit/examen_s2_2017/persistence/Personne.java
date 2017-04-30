package tn.esprit.examen_s2_2017.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Personne implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	
	private String prenom;
	
	private Integer age; // doit etre entier et ne doit pas dépasser 3 chiffre
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<ReponseSondage> reponses;

	
	public Personne(String nom, String prenom, Integer age) {
		this.age = age;
		this.prenom = prenom;
		this.nom = nom;
	}

	public Personne() {
		super();
	}

	
	public List<ReponseSondage> getReponses() {
		return reponses;
	}

	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}
