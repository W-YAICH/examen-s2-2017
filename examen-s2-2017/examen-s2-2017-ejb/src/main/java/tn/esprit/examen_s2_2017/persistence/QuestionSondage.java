package tn.esprit.examen_s2_2017.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class QuestionSondage implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String label;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<ReponseSondage> reponses;

	
	public QuestionSondage() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionSondage(String question) {
		this.label = question;
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

	public List<ReponseSondage> getReponses() {
		return reponses;
	}

	public void setReponses(List<ReponseSondage> reponses) {
		this.reponses = reponses;
	}

	

}
