package tn.esprit.examen_s2_2017.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.examen_s2_2017.persistence.Personne;
import tn.esprit.examen_s2_2017.persistence.QuestionSondage;
import tn.esprit.examen_s2_2017.persistence.ReponseSondage;

@Stateless
@LocalBean
public class SondageService {
	
	@PersistenceContext(unitName="examen-sondage")
	EntityManager em;

	public void ajouterQuestionEtReponses(QuestionSondage question){
		em.persist(question);
	}
	
	public List<QuestionSondage> getAllQuestionsEtReponses(){
		return em.createQuery("from QuestionSondage").getResultList();
	}
	
	public void ajouterPersonneEtAffecterReponse(Integer selectedReponseSondageId, Personne personne){
		em.persist(personne);
		ReponseSondage reponseSondage = em.find(ReponseSondage.class, selectedReponseSondageId);
		
		if(reponseSondage.getPersonne() != null){
			reponseSondage.getPersonne().add(personne);
		}else{
			List<Personne> persList = new ArrayList<>();
			persList.add(personne);
			reponseSondage.setPersonne(persList);
		}
	}
	
}
