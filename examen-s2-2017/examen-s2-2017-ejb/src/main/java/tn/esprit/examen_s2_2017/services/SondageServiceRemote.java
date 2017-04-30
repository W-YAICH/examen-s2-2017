package tn.esprit.examen_s2_2017.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.examen_s2_2017.persistence.Personne;
import tn.esprit.examen_s2_2017.persistence.QuestionSondage;
import tn.esprit.examen_s2_2017.persistence.ReponseSondage;

@Remote
public interface SondageServiceRemote {
	public int ajouterPersonneEtAffecterReponse(Integer selectedReponseSondageId, Personne personne);
	public List<QuestionSondage> getAllQuestionsEtReponses();
	
	public int ajouterQuestion(QuestionSondage question);
	public int ajouterReponse(ReponseSondage reponse);
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3);
	public void ajouterQuestionEtReponses(QuestionSondage question);
	public int nbPersonneParReponse(int reponseId);
	public Long nbPersonne();
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId);
	public void affecterReponseAPersonne(int reponseId, int personneId);
}
