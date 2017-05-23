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
public class Reponse implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String label;
	
	@ManyToOne
	private Question question;
	
	@ManyToMany(mappedBy="reponses")
	private List<Individu> personne;

	public Reponse() {
		super();
	}
	
	public Reponse(String reponse) {
		this.label = reponse;
	}
	
	public Reponse(int id) {
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

	public List<Individu> getPersonne() {
		return personne;
	}

	public void setPersonne(List<Individu> personne) {
		this.personne = personne;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	

	
	
}
