package tn.esprit.examen_s2_2017.presentation.mbeans;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_s2_2017.persistence.Personne;
import tn.esprit.examen_s2_2017.persistence.QuestionSondage;
import tn.esprit.examen_s2_2017.services.SondageService;

@ManagedBean
public class SondageBean {
		
	private String nom;
	
	private String prenom;
	
	private Integer age;
	
	private QuestionSondage questionSondage;
	
	private Integer selectedReponseSondageId;
		
	@EJB
	SondageService sondageService;
	
	@PostConstruct
	public void init(){
		List<QuestionSondage>  questionSondages = sondageService.getAllQuestionsEtReponses();
		// if you need to generate numbers from min to max (including both)
		//random.nextInt(max - min + 1) + min
		if(!questionSondages.isEmpty()){
			Random random = new Random();
			int indexRandom = random.nextInt(questionSondages.size());
			questionSondage = questionSondages.get(indexRandom);			
		}
	}
	
	public void ajouterSondage(){
		Personne personne = new Personne(nom, prenom, age);
		sondageService.ajouterPersonneEtAffecterReponse(selectedReponseSondageId, personne);
	}


	public Integer getSelectedReponseSondageId() {
		return selectedReponseSondageId;
	}

	public void setSelectedReponseSondageId(Integer selectedReponseSondageId) {
		this.selectedReponseSondageId = selectedReponseSondageId;
	}

	public QuestionSondage getQuestionSondage() {
		return questionSondage;
	}

	public void setQuestionSondage(QuestionSondage questionSondage) {
		this.questionSondage = questionSondage;
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
