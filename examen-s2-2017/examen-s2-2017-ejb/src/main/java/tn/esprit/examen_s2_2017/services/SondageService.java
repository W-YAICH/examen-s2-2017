package tn.esprit.examen_s2_2017.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.examen_s2_2017.persistence.Personne;
import tn.esprit.examen_s2_2017.persistence.QuestionSondage;
import tn.esprit.examen_s2_2017.persistence.ReponseSondage;

@Stateless
@LocalBean
public class SondageService implements SondageServiceRemote{
	
	@PersistenceContext(unitName="examen-sondage")
	EntityManager em;

	@Override
	public int ajouterQuestion(QuestionSondage question){
		em.persist(question);
		return question.getId();
	}
	
	@Override
	public int ajouterReponse(ReponseSondage reponse){
		em.persist(reponse);
		return reponse.getId();
	}
	
	
	@Override
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3) {
		ReponseSondage reponse1 = new ReponseSondage(idReponse1);
		ReponseSondage reponse2 = new ReponseSondage(idReponse2);
		ReponseSondage reponse3 = new ReponseSondage(idReponse3);
		
		QuestionSondage questionSondage = em.find(QuestionSondage.class, idQuestion);
		questionSondage.getReponses().add(reponse1);
		questionSondage.getReponses().add(reponse2);
		questionSondage.getReponses().add(reponse3);

		em.merge(questionSondage);
	}
	
	@Override
	public void ajouterQuestionEtReponses(QuestionSondage question){
		em.persist(question);
	}
	
	@Override
	public List<QuestionSondage> getAllQuestionsEtReponses(){
		return em.createQuery("from QuestionSondage").getResultList();
	}
	
	@Override
	public int ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Personne personne){
		if(personne.getReponses() == null){
			List<ReponseSondage> reponseSondages = new ArrayList<ReponseSondage>();
			reponseSondages.add(em.find(ReponseSondage.class, reponseSondageId));
			personne.setReponses(reponseSondages);
		}else{
			personne.getReponses().add(em.find(ReponseSondage.class, reponseSondageId));
		}
		em.persist(personne);
		return personne.getId();
	}

	
	@Override
	public int nbPersonneParReponse(int reponseId){
		Query query = em.createQuery("select count(p) from Personne p where p.reponses.id=:reponseId");
		query.setParameter("reponseId", reponseId);
		return (int)query.getSingleResult();
	}
	
	@Override
	public Long nbPersonne(){
		Query query = em.createQuery("select count(p) from Personne p");
		return (Long)query.getSingleResult();
	}

	@Override
	public List<ReponseSondage> getAllResponsesParPersonnes(int personneId) {
		Query query = em.createQuery("select p from Personne p where p.id=:personneId");
		query.setParameter("personneId", personneId);
		Personne p = (Personne) query.getSingleResult();
		return p.getReponses();
	}

	@Override
	public void affecterReponseAPersonne(int reponseId, int personneId) {
		Personne personne = em.find(Personne.class, personneId);
		personne.getReponses().add(em.find(ReponseSondage.class, reponseId));
	}
	
}
