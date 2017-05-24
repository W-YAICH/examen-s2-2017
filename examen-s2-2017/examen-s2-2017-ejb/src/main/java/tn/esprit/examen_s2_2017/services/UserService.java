package tn.esprit.examen_s2_2017.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.examen_s2_2017.persistence.Demande;
import tn.esprit.examen_s2_2017.persistence.User;

@Stateless
@LocalBean
public class UserService{
	
	@PersistenceContext(unitName="examen")
	EntityManager em;

	public void ajouterUser(User user){
		em.persist(user);
	}
	
	public List<User> getUsers(){
		return em.createQuery("from User").getResultList();
	}

	public List<Demande> getDemandesByUserId(Integer userId) {
		User user = em.find(User.class, userId);
		return user.getDemandesCrees();
	}
	
//	@Override
//	public int ajouterPersonneEtAffecterReponse(Integer reponseSondageId, Individu personne){
//		if(personne.getReponses() == null){
//			List<Reponse> reponseSondages = new ArrayList<>();
//			reponseSondages.add(em.find(Reponse.class, reponseSondageId));
//			personne.setReponses(reponseSondages);
//		}else{
//			personne.getReponses().add(em.find(Reponse.class, reponseSondageId));
//		}
//		em.persist(personne);
//		return personne.getId();
//	}
//
//	
//	@Override
//	public int nbPersonneParReponse(int reponseId){
//		Query query = em.createQuery("select count(p) from Personne p where p.reponses.id=:reponseId");
//		query.setParameter("reponseId", reponseId);
//		return (int)query.getSingleResult();
//	}
//	
//	@Override
//	public Long nbPersonne(){
//		Query query = em.createQuery("select count(p) from Personne p");
//		return (Long)query.getSingleResult();
//	}
//
//	@Override
//	public List<Reponse> getAllResponsesParPersonnes(int personneId) {
//		Query query = em.createQuery("select p from Personne p where p.id=:personneId");
//		query.setParameter("personneId", personneId);
//		Individu p = (Individu) query.getSingleResult();
//		return p.getReponses();
//	}
//
//	@Override
//	public void affecterReponseAPersonne(int reponseId, int personneId) {
//		Individu personne = em.find(Individu.class, personneId);
//		personne.getReponses().add(em.find(Reponse.class, reponseId));
//	}
	
}
