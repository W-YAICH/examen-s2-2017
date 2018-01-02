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
	
	private String label;
	
	@ManyToMany(mappedBy="reponses")
	private List<Personne> personne;

	public ReponseSondage() {
		super();
	}
	
	public ReponseSondage(String reponse) {
		this.label = reponse;
	}
	
	public ReponseSondage(int id) {
		this.id=id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Personne> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Personne> personne) {
		this.personne = personne;
	}

	
	
	
}
