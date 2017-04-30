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
	
	private String question;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<ReponseSondage> reponses;

	
	public QuestionSondage() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionSondage(String question) {
		this.question = question;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	

}
