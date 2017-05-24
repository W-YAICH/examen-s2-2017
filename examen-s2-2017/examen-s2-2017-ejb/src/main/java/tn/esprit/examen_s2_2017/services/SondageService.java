package tn.esprit.examen_s2_2017.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.examen_s2_2017.persistence.Individu;
import tn.esprit.examen_s2_2017.persistence.Question;
import tn.esprit.examen_s2_2017.persistence.Reponse;

@Stateless
@LocalBean
public class SondageService implements SondageServiceRemote{
	
	@PersistenceContext(unitName="examen")
	EntityManager em;

	@Override
	public int ajouterQuestion(Question question){
		em.persist(question);
		return question.getId();
	}
	
	@Override
	public int ajouterReponse(Reponse reponse){
		em.persist(reponse);
		return reponse.getId();
	}
	
	
	@Override
	public void affecterQuestionReponses(int idQuestion, int idReponse1, int idReponse2, int idReponse3) {
		Reponse reponse1 = new Reponse(idReponse1);
		Reponse reponse2 = new Reponse(idReponse2);
		Reponse reponse3 = new Reponse(idReponse3);
		
		Question question = em.find(Question.class, idQuestion);
		question.getReponses().add(reponse1);
		question.getReponses().add(reponse2);
		question.getReponses().add(reponse3);

		em.merge(question);
	}
	
	@Override
	public void ajouterQuestionEtReponses(Question question){
		em.persist(question);
	}
	
	@Override
	public List<Question> getAllQuestionsEtReponses(){
		return em.createQuery("from Question").getResultList();
	}
	
	@Override
	public int ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Individu personne){
		if(personne.getReponses() == null){
			List<Reponse> reponseSondages = new ArrayList<>();
			reponseSondages.add(em.find(Reponse.class, reponseSondageId));
			personne.setReponses(reponseSondages);
		}else{
			personne.getReponses().add(em.find(Reponse.class, reponseSondageId));
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
	public List<Reponse> getAllResponsesParPersonnes(int personneId) {
		Query query = em.createQuery("select p from Personne p where p.id=:personneId");
		query.setParameter("personneId", personneId);
		Individu p = (Individu) query.getSingleResult();
		return p.getReponses();
	}

	@Override
	public void affecterReponseAPersonne(int reponseId, int personneId) {
		Individu personne = em.find(Individu.class, personneId);
		personne.getReponses().add(em.find(Reponse.class, reponseId));
	}
	
}
