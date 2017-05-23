package tn.esprit.examen_s2_2017.presentation.mbeans;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_s2_2017.persistence.Individu;
import tn.esprit.examen_s2_2017.persistence.Question;
import tn.esprit.examen_s2_2017.services.SondageService;

@ManagedBean
public class SondageBean {
		
	private String nom;
	
	private String prenom;
	
	private Integer age;
	
	private Question question;
	
	private Integer selectedReponseId;
		
	@EJB
	SondageService sondageService;
	
	@PostConstruct
	public void init(){
		List<Question>  questions = sondageService.getAllQuestionsEtReponses();

		if(!questions.isEmpty()){
			Random random = new Random();
			int indexRandom = random.nextInt(questions.size());
			question = questions.get(indexRandom);			
		}
	}
	
	public void ajouterSondage(){
		Individu personne = new Individu(nom, prenom, age);
		sondageService.ajouterPersonneEtAffecterReponse(selectedReponseId, personne);
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getSelectedReponseId() {
		return selectedReponseId;
	}

	public void setSelectedReponseId(Integer selectedReponseId) {
		this.selectedReponseId = selectedReponseId;
	}

	public SondageService getSondageService() {
		return sondageService;
	}

	public void setSondageService(SondageService sondageService) {
		this.sondageService = sondageService;
	}

}
