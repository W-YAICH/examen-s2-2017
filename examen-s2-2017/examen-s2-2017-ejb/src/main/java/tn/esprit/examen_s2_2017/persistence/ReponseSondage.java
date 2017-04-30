package tn.esprit.examen_s2_2017.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ReponseSondage implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String reponse;
	
	
	@ManyToMany(mappedBy="reponses")
	private List<Personne> personne;

	public ReponseSondage() {
		super();
	}
	
	public ReponseSondage(String reponse) {
		this.reponse = reponse;
	}
	
	public ReponseSondage(int id) {
		this.id=id;
	}
	
	public List<Personne> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getReponse() {
		return reponse;
	}


	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

}
