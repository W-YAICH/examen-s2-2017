package tn.esprit.examen_s2_2017.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.examen_s2_2017.persistence.Individu;
import tn.esprit.examen_s2_2017.persistence.Question;
import tn.esprit.examen_s2_2017.persistence.Reponse;

@Remote
public interface SondageServiceRemote {
	public int ajouterPersonneEtAffecterReponse(Integer selectedReponseSondageId, Individu personne);
	public List<Question> getAllQuestionsEtReponses();
	
	public int ajouterQuestion(Question question);
	public int ajouterReponse(Reponse reponse);
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3);
	public void ajouterQuestionEtReponses(Question question);
	public int nbPersonneParReponse(int reponseId);
	public Long nbPersonne();
	public List<Reponse> getAllResponsesParPersonnes(int personneId);
	public void affecterReponseAPersonne(int reponseId, int personneId);
}
