package tn.esprit.examen_s2_2017.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import tn.esprit.examen_s2_2017.persistence.QuestionSondage;
import tn.esprit.examen_s2_2017.persistence.ReponseSondage;
import tn.esprit.examen_s2_2017.services.SondageService;

@ManagedBean
//@RequestScoped
public class QuestionReponseBean {
	
	private String question;
	
	private String reponse1;
	
	private String reponse2;
	
	private String reponse3;
	
	@EJB
	SondageService sondageService;
	
	
	//il faut mettre cascade persist
	public void ajouterQuestionEtReponses(){
		QuestionSondage questionSondage = new QuestionSondage();
		questionSondage.setQuestion(question);
		
		List<ReponseSondage> reponseSondagesList = new ArrayList<>();
		ReponseSondage reponseSondage1 = new ReponseSondage(reponse1);
		//reponseSondage1.setQuestion(questionSondage);
		
		ReponseSondage reponseSondage2 = new ReponseSondage(reponse2);
		//reponseSondage2.setQuestion(questionSondage);
		
		ReponseSondage reponseSondage3 = new ReponseSondage(reponse3);
		//reponseSondage3.setQuestion(questionSondage);
		
		reponseSondagesList.add(reponseSondage1);
		reponseSondagesList.add(reponseSondage2);
		reponseSondagesList.add(reponseSondage3);
		
		questionSondage.setReponses(reponseSondagesList);

		sondageService.ajouterQuestionEtReponses(questionSondage);
	}

	
	public List<QuestionSondage> getQuestions(){
		return sondageService.getAllQuestionsEtReponses();
	}

	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getReponse1() {
		return reponse1;
	}


	public void setReponse1(String reponse1) {
		this.reponse1 = reponse1;
	}


	public String getReponse2() {
		return reponse2;
	}


	public void setReponse2(String reponse2) {
		this.reponse2 = reponse2;
	}


	public String getReponse3() {
		return reponse3;
	}


	public void setReponse3(String reponse3) {
		this.reponse3 = reponse3;
	}
	
	
}
